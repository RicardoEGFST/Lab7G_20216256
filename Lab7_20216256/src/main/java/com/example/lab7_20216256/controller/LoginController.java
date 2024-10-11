package com.example.lab7_20216256.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/openLoginWindow")
    public String loginWindow(){
        return "loginWindow";
    }
    @GetMapping("/registrarse")
    public String registrarse(){
        return "loginNewForm";
    }
}
