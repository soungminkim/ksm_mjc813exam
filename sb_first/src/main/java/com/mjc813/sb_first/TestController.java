package com.mjc813.sb_first;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {
    @GetMapping("/first")
    public String method() {
        return "/first";
    }

    @GetMapping("/test/first")
    public String method2(Model md) {
        md.addAttribute ("screenkey", "한길수");
        return "/test/first";
    }
    @GetMapping("/gugudan/{dan}")
    public String method3(@PathVariable int dan, Model md) {
        List<String> result = new ArrayList<>();

        for(int i = 1; i <= 9; i++){
            result.add(dan + "x" + i + " = " + (dan*i));
        }
        md.addAttribute ("gugudanlist", result);
        md.addAttribute ("dan", dan);
        return "/gugudan/view";
    }
}
