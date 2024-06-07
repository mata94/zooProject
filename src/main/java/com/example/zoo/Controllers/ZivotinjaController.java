package com.example.zoo.Controllers;

import com.example.zoo.Service.*;
import com.example.zoo.models.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalTime;
import java.util.List;

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
        if(this.zivotinjaService.provjeriNastanbu(zivotinja)){
            this.zivotinjaService.create(zivotinja);
            return "redirect:/zivotinja";
        }else{
            throw new RuntimeException("Zivotinja vec posotji u toj nastanbi.");
        }
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
    @GetMapping("/listZivotinja")
    public String getAllIncident(Model model){
        List<Zivotinja> Zivotinja = zivotinjaService.findAll();
        model.addAttribute("zivotinje", Zivotinja);
        return "Zivotinja/ListZivotinja";
    }

    @GetMapping("/listZivotinja/delete/{id}")
    public String deleteZivotinja(@PathVariable Long id){
        zivotinjaService.deleteZivotinja(id);
        return "redirect:/listZivotinja";
    }

    @GetMapping("/listaTrenutnihZivotinja")
    public String allCurrentAnimals(Model model){
        model.addAttribute("zivotinje",this.zivotinjaService.findAllCurrentAnimals());
        return "Zivotinja/ListZivotinja";
    }
    @GetMapping("/listZivotinja/edit/{id}")
    public String showUpdateZivotinjaForm(@PathVariable Long id, Model model) {
        Zivotinja zivotinja = zivotinjaService.findById(id).orElseThrow(() -> new EntityNotFoundException("Zivotinja sa ID-om " + id + " nije pronađena"));
        model.addAttribute("zivotinja", zivotinja);

        List<Nastanba> nastanba = nastanbaService.findAll();
        model.addAttribute("nastanba", nastanba);

        List<PorijekloZivotinje> porijeklo = porijekloZivotinjeService.findAll();
        model.addAttribute("porijeklo", porijeklo);

        List<VrstaZivotinje> vrsta = vrstaZivotinjeService.findAll();
        model.addAttribute("vrsta", vrsta);

        return "Zivotinja/EditZivotinja";
    }

    @PostMapping("/listZivotinja/edit/{id}")
    public String updateZivotinja(@PathVariable Long id, @ModelAttribute Zivotinja zivotinja) {
        zivotinjaService.updateZivotinja(id, zivotinja);
        return "redirect:/listZivotinja";
    }
}

