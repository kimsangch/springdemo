package com.acompany.springdemo.service;

import com.acompany.springdemo.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    User getUserById(Integer userid);
    User registUser(User user);
    void modifyUser(Integer userid , User user);
    void removeUser(Integer userid);


}
