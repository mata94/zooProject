package com.example.zoo.Controllers;

import com.example.zoo.Service.KvalifikacijaService;
import com.example.zoo.models.Kvalifikacija;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class KvalifikacijaController {

    @Autowired
    KvalifikacijaService kvalifikacijaService;

    @GetMapping("/kvalifikacija")
    public String createKvalifikacijaForm(Model model){
        Kvalifikacija kvalifikacija = new Kvalifikacija();
        model.addAttribute("kvalifikacija",kvalifikacija);

        return "Kvalifikacija/createKvalifikacija";
    }

    @PostMapping("/kvalifikacija")
    public String createKvalifikacija(Kvalifikacija kvalifikacija){
        this.kvalifikacijaService.create(kvalifikacija);
        return "redirect:/kvalifikacija";
    }
}
