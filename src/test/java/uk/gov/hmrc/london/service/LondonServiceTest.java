package uk.gov.hmrc.london.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uk.gov.hmrc.london.model.User;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.gov.hmrc.london.service.LondonService.BASE_URL;

@SpringBootTest
class LondonServiceTest {

    public static final String TEST_USERS_WITHIN_LONDON_URL = BASE_URL + "/city/Rokiciny/users";
    public static final String TEST_USERS_OUTSIDE_LONDON_URL = BASE_URL + "/city/Kax/users";

    @Autowired
    private LondonService service;

    @Test
    public void testGetUsersWhenLondonUsersExist() {
        User[] users = service.getUsers(TEST_USERS_WITHIN_LONDON_URL);
        assertThat(users).isNotNull().hasSize(1);
        assertThat(users[0].getId()).isEqualTo(322);
        assertThat(users[0].getFirstName()).isEqualTo("Hugo");
        assertThat(users[0].getLastName()).isEqualTo("Lynd");
        assertThat(users[0].getEmail()).isEqualTo("hlynd8x@merriam-webster.com");
        assertThat(users[0].getIpAddress()).isEqualTo("109.0.153.166");
        assertThat(users[0].getLatitude()).isEqualTo(51.6710832);
        assertThat(users[0].getLongitude()).isEqualTo(0.8078532);
    }

    @Test
    public void testGetUsersWhenLondonUsersNotInList() {
        User[] users = service.getUsers(TEST_USERS_OUTSIDE_LONDON_URL);
        assertThat(users).isNotNull().isEmpty();
    }

    @Test
    public void testGetUsersAll(){
        User[] users = service.getUsers();
        assertThat(users).isNotNull().hasSize(3);
    }
}