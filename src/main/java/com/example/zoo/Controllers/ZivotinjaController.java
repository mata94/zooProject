package com.example.zoo.Controllers;

import com.example.zoo.Service.NastanbaService;
import com.example.zoo.Service.PorijekloZivotinjeService;
import com.example.zoo.Service.VrstaZivotinjeService;
import com.example.zoo.Service.ZivotinjaService;
import com.example.zoo.models.Zivotinja;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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

}
