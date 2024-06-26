package com.llun.ss_custom_authentication.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resource")
public class Resource {

    @GetMapping
    public String home() {
        return "Welcome Back!";
    }


    @PostMapping("/write")
    public String write() {
        return "Write!";
    }
}
