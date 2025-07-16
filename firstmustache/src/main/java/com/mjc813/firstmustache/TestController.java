package com.mjc813.firstmustache;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/gugudan")
public class TestController {
    @GetMapping("")
    public String method(@RequestParam(value = "dan" , defaultValue = "2") Integer dan, Model md) {
        List<String> result = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            result.add(dan + "x" + i + " = " + (dan*i));
        }

        md.addAttribute("result", result);
        md.addAttribute("dan", dan);
        return "gugudan";
    }
    @GetMapping("{dan}")
    public String method2(@PathVariable("dan") Integer dan, Model md) {
        List<String> result = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            result.add(dan + "x" + i + " = " + (dan*i));
        }

        md.addAttribute("result", result);
        md.addAttribute("dan", dan);
        return "gugudan";

    }
}
