package com.mjc813.swimpool_app.swimpool;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {

    @GetMapping("/swimpool")
    public String swimpoolMenu() {
        return "/swimpool/list";
    }
}
