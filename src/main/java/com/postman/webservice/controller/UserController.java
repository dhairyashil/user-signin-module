package com.postman.webservice.controller;

import com.postman.webservice.model.User;
import com.postman.webservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/signup", consumes = "application/json")
    public Map<String, String> signup(@RequestBody User userToBeRegister) {
        final User signedUpUser = userService.signup(userToBeRegister);

        Map<String, String> response = new HashMap<>();
        response.put("status", "User Signed up Successfully with email id " + signedUpUser.getEmailId());

        return response;
    }

    public UUID login(@RequestBody User user) {
        UUID uuid = userService.login(user);
        return uuid;
    }
}
