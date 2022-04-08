package com.acompany.springdemo.controller;


import com.acompany.springdemo.annotation.TokenRequired;
import com.acompany.springdemo.model.User;
import com.acompany.springdemo.service.UserService;
import com.acompany.springdemo.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("")
    public List<User> getAllusers() {
         return userService.getAllUsers();
    }


    @GetMapping("/{userid}")
    public User getUser(@PathVariable Integer userid) {
        logger.debug("getUser : " + userid);
        //int a = 3/0;
        return userService.getUserById(userid);
    }


    @PostMapping("")
    public User registUser(@RequestBody User user) {
        return userService.registUser(user);
    }


    @PutMapping("/{userId}")
    public void modifyUser(
            @PathVariable Integer userId,
            @RequestBody User user) {
            userService.modifyUser(userId , user);
    }

    @TokenRequired
    @DeleteMapping("/{userid}")
    public void removeUser(@PathVariable Integer userid) {
        userService.removeUser(userid);
    }
}
