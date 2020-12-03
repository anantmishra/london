package uk.gov.hmrc.london.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uk.gov.hmrc.london.model.User;
import uk.gov.hmrc.london.util.DistanceCalculator;

import java.util.Arrays;

@Service
public class LondonService {

    public static final String BASE_URL = "https://bpdts-test-app.herokuapp.com";
    public static final String ALL_USERS_URL = BASE_URL + "/users";

    @Autowired
    private RestTemplate template;

    public User[] getUsers() {
        return getUsers(ALL_USERS_URL);
    }

    public User[] getUsers(String url) {
        ResponseEntity<User[]> entity = template.getForEntity(url, User[].class);
        return Arrays.stream(entity.getBody())
                .filter(user -> DistanceCalculator.getDistanceFromLondonInMiles(user) < 50)
                .toArray(User[]::new);
    }

}
