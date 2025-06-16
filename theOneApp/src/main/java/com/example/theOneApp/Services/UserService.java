package com.example.theOneApp.Services;

import com.example.theOneApp.Entites.User;
import com.example.theOneApp.Repositories.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import  java.util.*;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
//    @Autowired
//    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public User create(User user){
        user.setLastUpdated(LocalDateTime.now());
//        if(user.getPassword() != null){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
//        }
        List<String> list = new ArrayList<>();
        list.add("USER");
        list.add("ADMIN");
        user.setRoles(list);

        return userRepository.save(user);
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User getById(String id){
        return userRepository.findById(new ObjectId(id)).orElse(null);
    }

    public User update(String id,User user){
        User u = userRepository.findById(new ObjectId(id)).orElse(null);
        if(u == null){
            return null;
        }

        if(user.getEmail() != null) u.setEmail(user.getEmail());
        if(user.getUsername() != null)  u.setUsername(user.getUsername());
        if(user.getPassword() != null)  u.setPassword(user.getPassword());

        if(user.getEmail() != null || user.getUsername() != null || user.getPassword() != null){
            u.setLastUpdated(LocalDateTime.now());
        }

        return userRepository.save(u);
    }

    public void delete(String id){
        userRepository.deleteById(new ObjectId(id));
    }
    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }
}
