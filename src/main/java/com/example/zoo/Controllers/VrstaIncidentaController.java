package com.example.zoo.Controllers;


import com.example.zoo.Service.VrstaIncidentaService;

import com.example.zoo.models.VrstaIncidenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VrstaIncidentaController {

    @Autowired
    VrstaIncidentaService vrstaIncidentaService;
    @GetMapping("/vrstaIncidenta")
    public String createVrstaIncidentaForm(Model model){
        VrstaIncidenta vrsta = new VrstaIncidenta();
        model.addAttribute("vrsta",vrsta);

        return "VrstaIncidenta/createVrstaIncidenta";
    }

    @PostMapping("/vrstaIncidenta")
    public String createVrstaIncidenta(Model model,VrstaIncidenta vrstaIncidenta){
        this.vrstaIncidentaService.createVrstaIncidenta(vrstaIncidenta);

        return "redirect:/vrstaIncidenta";
    }
}
