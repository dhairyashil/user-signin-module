package com.postman.webservice.service;

import com.postman.webservice.model.User;

import java.util.UUID;

public interface UserService {
    User signup(User user);

    UUID login(User user);
}
