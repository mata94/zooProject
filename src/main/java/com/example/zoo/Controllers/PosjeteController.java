package com.example.zoo.Controllers;

import com.example.zoo.models.Posjete;
import com.example.zoo.models.Radnik;
import com.example.zoo.Service.PosjeteService;
import com.example.zoo.Service.RadnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PosjeteController {

    @Autowired
    private PosjeteService posjeteService;

    @Autowired
    private RadnikService radnikService;

    @GetMapping("/unosPosjete")
    public String showCreatePosjeteForm(Model model) {
        Posjete posjete = new Posjete();
        model.addAttribute("posjete", posjete);
        List<Radnik> radnici = radnikService.findAll();
        model.addAttribute("radnici", radnici);
        return "Posjeta/createPosjeta";
    }

    @PostMapping("/unosPosjete")
    public String createPosjete(@ModelAttribute Posjete posjete) {
        posjeteService.save(posjete);
        return "redirect:/unosPosjete";
    }

    @GetMapping("/listPosjeta")
    public String getAllPosjeta(Model model){
        List<Posjete> posjete = posjeteService.findAll();
        model.addAttribute("posjete", posjete);
        return "Posjeta/ListPosjeta";
    }

    @GetMapping
    public String deletePosjeta(@PathVariable Long id){
        posjeteService.deletePosjeta(id);
        return "redirect:/listPosjeta";
    }


}

