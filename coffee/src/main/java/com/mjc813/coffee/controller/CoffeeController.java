package com.mjc813.coffee.controller;

import com.mjc813.coffee.dto.CoffeeDto;
import com.mjc813.coffee.dto.SearchRequestDto;
import com.mjc813.coffee.mybatis.CoffeeMybatis;
import com.mjc813.coffee.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/coffee")
public class CoffeeController {

    @Autowired
    private CoffeeService coffeeService;

    @GetMapping("/add")
    public String add() {
        return "/coffee/add";
    }
    @PostMapping("/insert")
    public String insert(@ModelAttribute CoffeeDto coffeeDto) {
        try{
            this.coffeeService.insert(coffeeDto);
        } catch (Throwable th){
            System.out.println(th.toString());
        }
        return "redirect:/coffee/list";
    }

    @GetMapping("/list")
    public String list(Model model, @ModelAttribute SearchRequestDto search) {
        try {
            List<CoffeeDto> all = this.coffeeService.findWhere(search);
            model.addAttribute("coffeeList", all);
        } catch (Throwable th){
            System.out.println(th.toString());
        }
        return "/coffee/list";
    }

    @GetMapping("/modify")
    public String modify(Model model
    , @RequestParam("id") Long id) {
        try {
            CoffeeDto Id = this.coffeeService.selectById(id);
            model.addAttribute("data", Id);
        } catch (Throwable th){
            System.out.println(th.toString());
        }
        return "/coffee/modify";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute CoffeeDto coffeeDto) {
        try {
            this.coffeeService.update(coffeeDto);
        } catch (Throwable th){
            System.out.println(th.toString());
        }
        return "redirect:/coffee/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        try {
            this.coffeeService.deleteById(id);
        }   catch (Throwable th){
            System.out.println(th.toString());
        }
        return "redirect:/coffee/list";
    }

}
