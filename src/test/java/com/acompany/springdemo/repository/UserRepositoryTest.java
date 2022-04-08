package com.acompany.springdemo.repository;

import com.acompany.springdemo.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;


    @Test
    public void testgetAllUsers(){
        List<User> allUsers = userRepository.getAllUsers();
        Assertions.assertTrue(allUsers.size() > 0);
    }

}
