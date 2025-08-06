package com.mjc813.food_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebViewController {
    @GetMapping("/")
    public String mainPage() {
        return "index";
    }
}