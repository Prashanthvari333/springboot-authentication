package com.prashu.auth_requests.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prashu.auth_requests.models.User;
import com.prashu.auth_requests.repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;


@RestController
public class AuthController {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public String signup(@RequestParam String username, @RequestParam String password) {
        if (userRepository.findByUsername(username) != null) {
            return "User already exists";
        }

        User user = new User();
        user.setUsername(username);
//        user.setPassword(passwordEncoder.encode(password)); // Encrypt the password
        user.setPassword(password);
        userRepository.save(user);
        return "User signed up successfully";
    }

    @PostMapping("/signin")
    public String signin(@RequestParam String username, @RequestParam String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && password.equals(user.getPassword())) { //passwordEncoder.matches(password, user.getPassword())
            return "User signed in successfully";
        }
        return "Invalid username or password";
    }
    
    @GetMapping("/get_csrf_token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
    	return (CsrfToken) request.getAttribute("_csrf");
    }


}

