package com.example.zoo.Controllers;


import com.example.zoo.Service.KvalifikacijaService;
import com.example.zoo.Service.RadnikService;
import com.example.zoo.models.Radnik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class RadnikController {

    @Autowired
    RadnikService radnikService;

    @Autowired
    private KvalifikacijaService kvalifikacijaService;
    @GetMapping("/unosRadnika")
    public String showCreateRadnikForm(Model model) {
        Radnik radnik = new Radnik();
        model.addAttribute("radnik", radnik);
        model.addAttribute("kvalifikacijaList", kvalifikacijaService.findAll());


        return "Radnik/createRadnik";
    }


    @PostMapping("/unosRadnika")
    public String createRadnik(@ModelAttribute Radnik radnik) {
        radnikService.save(radnik);
        return "redirect:/unosRadnika";
    }
}
