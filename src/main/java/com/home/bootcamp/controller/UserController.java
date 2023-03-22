package com.home.bootcamp.controller;

import com.home.bootcamp.model.entity.User;
import com.home.bootcamp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/")
@RequiredArgsConstructor
public class UserController {
    private static final Logger logger = LogManager.getLogger(UserController.class);
    private final UserRepository userRepository;

    @PostMapping("/user")
    public void addUser(@RequestBody User user){
        userRepository.save(user);
        logger.info("User {} has been added", user.getUsername());
    }

    @GetMapping("/listUsers")
    public List<User> getListUsers(){
        logger.debug("Getting list of all users");
        return userRepository.findAll();
    }
}
