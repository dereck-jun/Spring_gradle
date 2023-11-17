package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("hello")
public class HelloViewController {
    @GetMapping("view")
    public String helloView(){
        return "hello";
    }

    @GetMapping("model")
    public String modelView(Model model){
        model.addAttribute("msg", "thymeLeaf");

        return "helloThymeleaf";
    }

}
