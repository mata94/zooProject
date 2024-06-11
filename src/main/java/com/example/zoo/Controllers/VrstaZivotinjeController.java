package com.example.zoo.Controllers;

import com.example.zoo.Service.VrstaZivotinjeService;
import com.example.zoo.models.VrstaZivotinje;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

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
    @GetMapping("/listVrstaZivotinje/edit/{id}")
    public String editVrstaForm(@PathVariable Long id, Model model) {
        Optional<VrstaZivotinje> optionalVrsta = vrstaZivotinjeService.findById(id);
        if (optionalVrsta.isEmpty()) {
            throw new EntityNotFoundException("Vrsta Zivotinje sa ID-om " + id + " nije pronađena");
        }
        VrstaZivotinje vrsta = optionalVrsta.get();
        model.addAttribute("vrsta", vrsta);
        return "VrstaZivotinje/editVrsta";
    }

    @PostMapping("/listVrstaZivotinje/edit/{id}")
    public String updateVrsta(@PathVariable Long id, VrstaZivotinje vrstaZivotinje) {
        vrstaZivotinjeService.updateVrsta(id, vrstaZivotinje);
        return "redirect:/listVrstaZivotinje";
    }
}

