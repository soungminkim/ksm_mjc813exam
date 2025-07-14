package com.mjc813.start_spring.hello.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String asdfewdsaf(@RequestParam("name") String name, Model model) {
        // 화면 템플릿 파일의 경로를 리턴한다.
        System.out.println("hello ; " + name);
        model.addAttribute("name", name);
        return "hello";
    }

    @GetMapping("/hello2/{name}")
    public String asgsadfd(@PathVariable("name") String name) {
        // 화면 템플릿 파일의 경로를 리턴한다.
        System.out.println("hello2 ; " + name);
        return "hello";
    }
}
