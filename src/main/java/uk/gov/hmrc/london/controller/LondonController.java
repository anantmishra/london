package uk.gov.hmrc.london.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uk.gov.hmrc.london.model.User;
import uk.gov.hmrc.london.service.LondonService;

import static uk.gov.hmrc.london.util.ExceptionUtils.throwResponseStatusException;

@RestController
@RequestMapping("london")
public class LondonController {

    private static final Logger logger = LoggerFactory.getLogger(LondonController.class);

    @Autowired
    private LondonService service;

    @RequestMapping(method = RequestMethod.GET, path = "users")
    public User[] getLondonUsers() {
        User[] users = service.getUsers();
        if (users == null || users.length < 1)
            throwResponseStatusException(logger, "No user(s) found.", HttpStatus.NOT_FOUND);
        return users;
    }
}
