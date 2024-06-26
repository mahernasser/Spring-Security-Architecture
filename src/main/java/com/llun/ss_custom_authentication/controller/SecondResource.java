package com.llun.ss_custom_authentication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resource2")
public class SecondResource {

    @PostMapping
    public String home() {
        return "Welcome Back!2222";
    }

    @GetMapping

    public String read() {
        return "Read!";
    }


}
