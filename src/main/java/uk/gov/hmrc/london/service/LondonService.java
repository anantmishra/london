package uk.gov.hmrc.london.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uk.gov.hmrc.london.model.User;

import java.util.Arrays;

import static uk.gov.hmrc.london.util.DistanceCalculator.getDistanceFromLondonInMiles;

@Service
public class LondonService {

    private static final Logger logger = LoggerFactory.getLogger(LondonService.class);

    public static final String BASE_URL = "https://bpdts-test-app.herokuapp.com";
    public static final String ALL_USERS_URL = BASE_URL + "/users";

    public static final double FIFTY_MILES = 50.0d;

    @Autowired
    private RestTemplate template;

    public User[] getUsers() {
        return getUsers(ALL_USERS_URL, FIFTY_MILES);
    }

    public User[] getUsers(String url, double distanceInMiles) {
        ResponseEntity<User[]> entity = template.getForEntity(url, User[].class);
        User[] users = entity.getBody();
        logger.info("Number of user(s) found at [{}]: {}", url, users.length);
        User[] londonUsers = Arrays.stream(users)
                .filter(user -> getDistanceFromLondonInMiles(user) < distanceInMiles)
                .toArray(User[]::new);
        logger.info("Number of user(s) found within {} miles of London: {}", distanceInMiles, londonUsers.length);
        return londonUsers;
    }

}
