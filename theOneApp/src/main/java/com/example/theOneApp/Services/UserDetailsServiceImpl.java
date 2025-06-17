package com.example.theOneApp.Services;

import com.example.theOneApp.Entites.User;
import com.example.theOneApp.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) throw new UsernameNotFoundException("User not found for email: " + email);

        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role)) // add prefix if needed
                .collect(Collectors.toList());
//        System.out.println(authorities);

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(), // should be BCrypt encoded
                authorities
        );
    }




//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
////        User user = userRepository.findByEmail(email)
////                .orElseThrow(() -> new UsernameNotFoundException("User with this email not found : email : " + email));
//        User user = userRepository.findByEmail(email);
//        if(user == null){
//            throw new UsernameNotFoundException("no user with the email : " + email);
//        }
//        // Assuming user.getRoles() returns a collection of strings or role entities
//         List<GrantedAuthority> authorities = user.getRoles().stream()
//                .map(role -> new SimpleGrantedAuthority("ROLE_" + role)) // or just `role` if it's a String
//                .collect(Collectors.toList());
//
//        return new org.springframework.security.core.userdetails.User(
//                user.getEmail(),
//                user.getPassword(),
////                Collections.emptyList()
//                authorities
//        );
////        return null;
//    }
}
