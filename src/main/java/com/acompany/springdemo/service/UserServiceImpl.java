package com.acompany.springdemo.service;

import com.acompany.springdemo.model.User;
import com.acompany.springdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    public Map<String, Object> getMessage() {
        Map<String, Object> res = new HashMap<>();
        ArrayList<String> arraylist = new ArrayList<String>();
        arraylist.add("Hello");
        arraylist.add("World.");
        arraylist.add(" TEST");
        arraylist.add(" STRING");

        res.put("greet1" ,arraylist);
        res.put("greet2" ,arraylist);
        res.put("greet3" , "Hello World3");
        res.put("greet4" , "Hello World4");

        return res;
    }

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public User getUserById(Integer userid) {
        return userRepository.getUserbyUserid(userid);
    }

    @Override
    public User registUser(User user) {
        return userRepository.insertUser(user);
    }

    @Override
    public void modifyUser(Integer userid, User user) {
        user.setUserid(userid);
        userRepository.updateUser(user);
    }

    @Override
    public void removeUser(Integer userid) {
        userRepository.deleteUser(userid);
    }
}
