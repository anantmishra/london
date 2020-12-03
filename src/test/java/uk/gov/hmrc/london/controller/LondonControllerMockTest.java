package uk.gov.hmrc.london.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import uk.gov.hmrc.london.model.User;
import uk.gov.hmrc.london.service.LondonService;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LondonControllerMockTest {

    @MockBean
    private LondonService service;

    @Autowired
    private TestRestTemplate template;

    @Test
    public void testGetLondonUsersWhenNoUsersFound() {
        Mockito.when(service.getUsers()).thenReturn(new User[0]);
        ResponseEntity<String> entity = template.getForEntity("/london/users", String.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }
}