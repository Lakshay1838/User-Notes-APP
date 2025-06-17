package com.example.theOneApp.Controllers;

import com.example.theOneApp.Entites.User;
import com.example.theOneApp.Services.NoteService;
import com.example.theOneApp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/userController")
public class UserController {

    @Autowired
    private UserService userService;

//  NOTE - either use @Autowired or make a constructor and initialize the user service instance like below:
//    public UserController(UserService userService){
//        this.userService = userService;
//    }



//    @PostMapping
//    public User create(@RequestBody User user){
//        return userService.create(user);
//    }
    @GetMapping("/all")
    public List<User> getAll(){
        return userService.getAll();
    }
    @GetMapping("/")
    public User getByEmail(){
        String email = userService.LoggedInUserEmail();
        return userService.findByEmail(email);
    }
    @PutMapping("/{id}")
    public User update(@PathVariable String id,@RequestBody User user){
        return userService.update(id,user);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        userService.delete(id);
    }
}
