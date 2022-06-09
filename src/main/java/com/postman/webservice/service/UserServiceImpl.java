package com.postman.webservice.service;

import com.postman.webservice.model.User;
import com.postman.webservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User signup(User user) {
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    @Override
    public UUID login(User user) {
        final User userByEmail = userRepository.findByEmailId(user.getEmailId());
        if(userByEmail == null)
            throw new RuntimeException("User not present with email id");

        if(user.getPassword().equals(userByEmail.getPassword())) {
            UUID uuid = UUID.randomUUID();
            return uuid;
        }

        throw new RuntimeException("password not matching");
    }


}
