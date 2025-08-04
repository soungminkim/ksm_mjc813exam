package com.mjc813.cinema_crud;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {

    @GetMapping("/cinema")
    public String cinemaHome() {
        return "cinema";
    }
}
