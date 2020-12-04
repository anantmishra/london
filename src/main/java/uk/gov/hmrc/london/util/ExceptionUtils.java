package uk.gov.hmrc.london.util;

import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ExceptionUtils {

    public static void throwResponseStatusException(Logger logger, String message, HttpStatus status) {
        logger.warn(message);
        throw new ResponseStatusException(status, message);
    }
}
