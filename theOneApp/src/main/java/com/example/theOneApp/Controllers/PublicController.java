package com.example.theOneApp.Controllers;

import com.example.theOneApp.Entites.User;
import com.example.theOneApp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {

    @GetMapping("/health")
    public String health(){
        return "Spring Application is working fine;";
    }

    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    public User create(@RequestBody User user){
        return userService.create(user);
    }
}
