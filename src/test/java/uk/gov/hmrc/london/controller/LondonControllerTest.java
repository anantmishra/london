package uk.gov.hmrc.london.controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LondonControllerTest {

    @Autowired
    private TestRestTemplate template;

    @Test
    public void testGetLondonUsers() throws IOException, JSONException {
        ResponseEntity<String> entity = template.getForEntity("/london/users", String.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        String expected_json = new String(Files.readAllBytes(Paths.get("src/test/resources/london_users.json")), UTF_8);
        JSONAssert.assertEquals(expected_json, entity.getBody(), true);
    }

}