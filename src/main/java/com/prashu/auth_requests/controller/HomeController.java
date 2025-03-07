package com.prashu.auth_requests.controller;

import java.time.LocalTime;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class HomeController {
    @GetMapping("/greet")
    public String greet() {
        LocalTime time = LocalTime.now();
        if (time.isBefore(LocalTime.NOON)) {
            return "Good Morning!";
        } else if (time.isBefore(LocalTime.of(18, 0))) {
            return "Good Afternoon!";
        } else {
            return "Good Evening!";
        }
    }
    


}
