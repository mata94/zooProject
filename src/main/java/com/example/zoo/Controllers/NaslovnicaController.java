package com.example.zoo.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NaslovnicaController {

    @GetMapping("/pocetna")
    public String pocetna(){

        return "Naslovnica/PocetnaStranica";

    }

    @GetMapping("/")
    public String redirectToPocetna() {

        return "redirect:/pocetna";
        
    }
}
