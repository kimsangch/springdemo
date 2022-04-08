package com.acompany.springdemo.repository;
import com.acompany.springdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    public static List<User> users;

    static {
        users = new ArrayList<>();
        users.add(new User(100 , "kim"));
        users.add(new User(200 , "lee"));
        users.add(new User(300 , "park"));
        users.add(new User(400 , "kwon"));
        users.add(new User(500 , "hwang"));
        users.add(new User(600 , "choi"));
        users.add(new User(700 , "song"));
        users.add(User.builder().userid(800).username("test").build());
    }

    public List<User> getAllUsers() {
        return users;
    }

   public User getUserbyUserid(Integer userid) {
        return users.stream()
                .filter(user -> user.getUserid().equals(userid))
                .findFirst()
                .orElse(new User(0,"no user"));
   }

   public User insertUser(User user){
        users.add(user);
        return user;
   }

   public void updateUser(User user) {
        users.stream()
                .filter(item -> item.getUserid().equals(user.getUserid()))
                .findAny()
                .orElse(new User(0, "no user"))
                .setUsername(user.getUsername());
   }

   public void deleteUser(Integer userid) {
        users.removeIf(user -> user.getUserid().equals(userid));
   }
}
