package uk.gov.hmrc.london.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import uk.gov.hmrc.london.model.User;
import uk.gov.hmrc.london.service.LondonService;

@RestController
@RequestMapping("london")
public class LondonController {

    @Autowired
    private LondonService service;

    @RequestMapping(method = RequestMethod.GET, path = "users")
    public User[] getLondonUsers() {
        User[] users = service.getUsers();
        if (users == null || users.length == 0)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No user(s) found.");
        return users;
    }
}
