package com.example.zoo.Controllers;

import com.example.zoo.Service.IncidentService;
import com.example.zoo.Service.NastanbaService;
import com.example.zoo.Service.VrstaIncidentaService;
import com.example.zoo.Service.ZivotinjaService;
import com.example.zoo.models.Incident;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class IncidentController {

    @Autowired
    private IncidentService incidentService;

    @Autowired
    private VrstaIncidentaService vrstaIncidentaService;

    @Autowired
    private ZivotinjaService zivotinjaService;

    @Autowired
    private NastanbaService nastanbaService;

    @GetMapping("/unosIncidenta")
    public String showCreateIncidentForm(Model model) {
        Incident incident = new Incident();
        model.addAttribute("incident", incident);

        model.addAttribute("vrstaIncidentaList", vrstaIncidentaService.findAll());
        model.addAttribute("zivotinjaList", zivotinjaService.findAll());
        model.addAttribute("nastanbaList", nastanbaService.findAll());

        return "Incident/createIncident";
    }

    @PostMapping("/unosIncidenta")
    public String createIncident(@ModelAttribute Incident incident) {
        incidentService.createIncident(incident);
        return "redirect:/unosIncidenta";
    }
    @GetMapping("/listIncident")
    public String getAllIncident(Model model){
        List<Incident> Incident = incidentService.findAll();
        model.addAttribute("incident", Incident);
        return "Incident/ListIncident";
    }

    @GetMapping("/listIncident/delete/{id}")
    public String deleteIncident(@PathVariable Long id){
        incidentService.deleteIncident(id);
        return "redirect:/listIncident";
    }
    @GetMapping("/incident/edit/{id}")
    public String editIncidentForm(@PathVariable("id") Long id, Model model) {
        Incident incident = incidentService.findById(id);
        model.addAttribute("incident", incident);
        return "incident/editIncident";
    }

    @PostMapping("/incident/edit/{id}")
    public String editIncident(@PathVariable("id") Long id, Incident updatedIncident) {
        incidentService.updateIncident(id, updatedIncident);
        return "redirect:/listIncident";
    }
}

