package uk.gov.hmrc.london.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ExceptionUtilsTest {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionUtilsTest.class);

    @Test
    public void testThrowResponseStatusException() {
        String message = "Test message.";
        Assertions.assertThatThrownBy(() -> {
            ExceptionUtils.throwResponseStatusException(logger, message, HttpStatus.I_AM_A_TEAPOT);
        }).isInstanceOf(ResponseStatusException.class).hasMessageContaining(message);
    }

}