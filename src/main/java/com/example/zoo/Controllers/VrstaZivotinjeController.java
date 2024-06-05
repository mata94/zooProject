package com.example.zoo.Controllers;

import com.example.zoo.Service.VrstaZivotinjeService;
import com.example.zoo.models.VrstaZivotinje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class VrstaZivotinjeController {

    @Autowired
    VrstaZivotinjeService vrstaZivotinjeService;
    @GetMapping("/vrstaZivotinje")
    public String createVrstaForm(Model model){
        VrstaZivotinje vrsta = new VrstaZivotinje();
        model.addAttribute("vrsta",vrsta);

        return "VrstaZivotinje/createVrsta";
    }

    @PostMapping("/vrstaZivotinje")
    public String createVrsta(Model model,VrstaZivotinje vrstaZivotinje){
        this.vrstaZivotinjeService.createVrsta(vrstaZivotinje);

        return "redirect:/vrstaZivotinje";
    }

    @GetMapping("/listVrstaZivotinje")
    public String getAllSpeciesZivotinja(Model model,VrstaZivotinje vrstaZivotinje){
        List<VrstaZivotinje> VrstaZivotinje = this.vrstaZivotinjeService.findAll();
        model.addAttribute("vrstaZivotinje",VrstaZivotinje);
        return "VrstaZivotinje/listVrstaZivotinje";
    }

    @GetMapping("/listVrstaZivotinje/delete/{id}")
    public String deleteSpecies(@PathVariable("id") Long id) {
        vrstaZivotinjeService.deleteById(id);
        return "redirect:/listVrstaZivotinje";
    }

}
