package com.vali.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("/hello") //http://localhost:8080/hello?name=Dolly
    public String sayHello(
            @RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {

        model.addAttribute("user", name);
        return "hello"; //look for hello.html in src/main/resources/templates
    }

}
