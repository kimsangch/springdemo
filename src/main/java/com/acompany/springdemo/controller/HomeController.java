package com.acompany.springdemo.controller;

import com.acompany.springdemo.service.SecurityServiceImpl;
import com.acompany.springdemo.service.UserService;
import com.acompany.springdemo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class HomeController {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private SecurityServiceImpl securityService;

    @GetMapping("")
    public Map<String , Object> home() {
        Map<String , Object> res = userService.getMessage();
        //HashMap<String, String> res = new HashMap<>();
        //res.put("greet" , "Hello World");
        return res;
    }

    @GetMapping("security/generate/token")
    public Map<String , Object> generateToken(@RequestParam String subject) {
        String token = securityService.createToken(subject, 1000 * 60 * 60);
        HashMap<String, Object> map = new HashMap<>();
        map.put("userid" , subject);
        map.put("token" , token);
        return map;
    }

    @GetMapping("security/get/subject")
    public String getSubject(@RequestParam String token) {
        String subject = securityService.getSubject(token);
        return subject;
    }
}
