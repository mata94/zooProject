package com.example.zoo.Controllers;


import com.example.zoo.Service.VrstaIncidentaService;

import com.example.zoo.models.VrstaIncidenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/listVrstaIncidenta")
    public String getAllIncidents(Model model){
        List<VrstaIncidenta> VrstaIncidenta = vrstaIncidentaService.findAll();
        model.addAttribute("vrstaIncidenta",VrstaIncidenta);
        return "VrstaIncidenta/listVrstaIncidenta";
    }

    @GetMapping("/listVrstaIncidenta/delete/{id}")
    public String deleteIncident(@PathVariable("id") long id) {
        vrstaIncidentaService.deleteById(id);
        return "redirect:/listVrstaIncidenta";
    }
    @GetMapping("/listVrstaIncidenta/edit/{id}")
    public String editIncident(@PathVariable("id") long id, Model model) {
        Optional<VrstaIncidenta> optionalVrstaIncidenta = vrstaIncidentaService.findById(id);
        if (optionalVrstaIncidenta.isPresent()) {
            model.addAttribute("vrstaIncidenta", optionalVrstaIncidenta.get());
            return "VrstaIncidenta/editVrstaIncidenta";
        } else {
            return "redirect:/listVrstaIncidenta";
        }
    }

    @PostMapping("/listVrstaIncidenta/edit/{id}")
    public String updateIncident(@PathVariable("id") long id, VrstaIncidenta vrstaIncidenta) {
        vrstaIncidenta.setId(id);
        vrstaIncidentaService.createVrstaIncidenta(vrstaIncidenta);
        return "redirect:/listVrstaIncidenta";
    }
}
