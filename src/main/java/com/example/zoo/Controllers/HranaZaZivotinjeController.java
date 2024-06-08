package com.example.zoo.Controllers;

import com.example.zoo.Service.HranaZaZivotinjuService;
import com.example.zoo.Service.ZivotinjaService;
import com.example.zoo.models.Dobavljac;
import com.example.zoo.models.HranaZaZivotinje;


import com.example.zoo.repository.DobavljacRepository;
import com.example.zoo.repository.HranaZaZivotinjeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HranaZaZivotinjeController {

    @Autowired
    private HranaZaZivotinjuService hranaZaZivotinjuService;

    @Autowired
    private ZivotinjaService zivotinjaService;

    @GetMapping("/dobavljac")
    public String createDobavljacForm(Model model){
        model.addAttribute("dobavljac",new Dobavljac());
        return "HranaZaZivotinje/createDobavljac";
    }

    @PostMapping("/dobavljac")
    public String createDobavljac(Dobavljac dobavljac){
        this.hranaZaZivotinjuService.createDobavljac(dobavljac);
        return "redirect:/dobavljac";
    }

    @GetMapping("/hranaZaZivotinje")
    public String createHranaZaZivotinjeForm(Model model){
        model.addAttribute("hranaZaZivotinje",new HranaZaZivotinje());
        model.addAttribute("dobavljaci",this.hranaZaZivotinjuService.pronadjiSveDobavljace());
        model.addAttribute("zivotinje",this.zivotinjaService.findAll());

        return "HranaZaZivotinje/createHranaZaZivotinje";
    }

    @PostMapping("/hranaZaZivotinje")
    public String createHranaZaZivotinje(HranaZaZivotinje hranaZaZivotinje){
        this.hranaZaZivotinjuService.save(hranaZaZivotinje);
        return "redirect:/hranaZaZivotinje";
    }


    @GetMapping("/listHranaZaZivotinje")
    public String getAllHranaZaZivotinje(Model model){
        List<HranaZaZivotinje> hranaZaZivotinje = this.hranaZaZivotinjuService.findAll();
        model.addAttribute("hranaZaZivotinje", hranaZaZivotinje);
        return "HranaZaZivotinje/ListHranaZaZivotinje";
    }

    @GetMapping("/hranaZaZivotinje/delete/{id}")
    public String deleteHranaZaZivotinje(@PathVariable Long id){
        hranaZaZivotinjuService.deleteHrana(id);
        return "redirect:/listHranaZaZivotinje";
    }


    @GetMapping("/troskoviHrane")
    public String sviTroskoviHrane(Model model){
        model.addAttribute("troskovi",this.hranaZaZivotinjuService.mjesecniTroskovi());
        return"HranaZaZivotinje/mjesecniTroskovi";
    }
}
