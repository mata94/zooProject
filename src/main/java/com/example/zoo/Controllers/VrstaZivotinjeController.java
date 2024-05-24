package com.example.zoo.Controllers;

import com.example.zoo.Service.VrstaZivotinjeService;
import com.example.zoo.models.VrstaZivotinje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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

}
