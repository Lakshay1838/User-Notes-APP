package com.example.theOneApp.Configuration;

import com.example.theOneApp.Repositories.UserRepository;
import com.example.theOneApp.Services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigurer {

//    @Autowired
//    private UserDetailsServiceImpl userDetailsService;
//

    @Autowired
    private UserRepository userRepository;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/public/**").permitAll() // better to use /** if controller has multiple endpoints
                        .anyRequest().authenticated()
                )
                .httpBasic()
                .and()
                .csrf().disable(); // default login form

        return http.build();
    }

//    @Bean
//    public UserDetailsServiceImpl userDetailsService(){
//        return new UserDetailsServiceImpl();
//    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
