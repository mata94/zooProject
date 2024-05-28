package com.example.zoo.Controllers;

import com.example.zoo.Service.*;
import com.example.zoo.models.HranjenjeZivotinje;
import com.example.zoo.models.Zivotinja;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalTime;

@Controller
public class ZivotinjaController {

    @Autowired
    ZivotinjaService zivotinjaService;

    @Autowired
    NastanbaService nastanbaService;

    @Autowired
    VrstaZivotinjeService vrstaZivotinjeService;

    @Autowired
    PorijekloZivotinjeService porijekloZivotinjeService;

    @Autowired
    RadnikService radnikService;

    @Autowired
    HranjenjeZivotinjeService hranjenjeZivotinjeService;


    @GetMapping("/zivotinja")
    public String createZivotinjaForm(Model model){
        Zivotinja zivotinja = new Zivotinja();
        model.addAttribute("zivotinja",zivotinja);
        model.addAttribute("nastanbe",this.nastanbaService.findAll());
        model.addAttribute("vrsteZivotinje",this.vrstaZivotinjeService.findAll());
        model.addAttribute("porijekloZivotinje",this.porijekloZivotinjeService.findAll());

        return "Zivotinja/createZivotinja";
    }

    @PostMapping("/zivotinja")
    public String createZivotinja(Zivotinja zivotinja)
    {
        this.zivotinjaService.create(zivotinja);

        return "redirect:/zivotinja";
    }

    @GetMapping("/hranjenjeZivotinje")
    public String hranjenjeZivotinje(Model model){
        model.addAttribute("hranjenja",this.hranjenjeZivotinjeService.findAll());
        return "Zivotinja/listHranjenjeZivotinje";
    }
    @PostMapping("/hranjenje/{id}/nahrani")
    public String createHranjenjeZivotinje(@PathVariable Long id){

        HranjenjeZivotinje hranjenjeZivotinje = this.hranjenjeZivotinjeService.findById(id);
        hranjenjeZivotinje.setNahranjena(true);
        hranjenjeZivotinje.setVrijemeHranjenja(LocalTime.now());

        this.hranjenjeZivotinjeService.create(hranjenjeZivotinje);

        return "redirect:/hranjenjeZivotinje";
    }

}
