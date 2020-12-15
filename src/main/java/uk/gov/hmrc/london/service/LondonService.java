package uk.gov.hmrc.london.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uk.gov.hmrc.london.model.User;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static uk.gov.hmrc.london.util.DistanceCalculator.getDistanceFromLondonInMiles;

@Service
public class LondonService {

    private static final Logger logger = LoggerFactory.getLogger(LondonService.class);

    public static final String CITY_LONDON = "London";
    public static final String BASE_URL = "https://bpdts-test-app.herokuapp.com";
    public static final String ALL_USERS_URL = BASE_URL + "/users";

    public static final double FIFTY_MILES = 50.0d;

    @Autowired
    private RestTemplate template;

    public User[] getUsers() {
        Set<User> users = new HashSet();
        Collections.addAll(users, getUsersWithinMilesOfLondon(ALL_USERS_URL, FIFTY_MILES));
        Collections.addAll(users, getUsersInCity(CITY_LONDON));
        return users.toArray(User[]::new);
    }

    public User[] getUsersWithinMilesOfLondon(String url, double distanceInMiles) {
        ResponseEntity<User[]> entity = template.getForEntity(url, User[].class);
        User[] users = entity.getBody();
        logger.info("Number of user(s) found at [{}]: {}", url, users.length);
        User[] usersWithinMilesOfLondon = Arrays.stream(users)
                .filter(user -> getDistanceFromLondonInMiles(user) < distanceInMiles)
                .toArray(User[]::new);
        logger.info("Number of user(s) found within {} miles of London: {}", distanceInMiles, usersWithinMilesOfLondon.length);
        return usersWithinMilesOfLondon;
    }

    public User[] getUsersInCity(String city) {
        String url = BASE_URL + "/city/" + city + "/users";
        ResponseEntity<User[]> entity = template.getForEntity(url, User[].class);
        User[] users = entity.getBody();
        logger.info("Number of user(s) in city [{}] found at [{}]: {}", city, url, users.length);
        return users;
    }
}
