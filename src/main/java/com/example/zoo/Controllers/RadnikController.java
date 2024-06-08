package com.example.zoo.Controllers;


import com.example.zoo.Service.*;
import com.example.zoo.models.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Controller
public class RadnikController {

    @Autowired
    RadnikService radnikService;

    @Autowired
    ZivotinjaService zivotinjaService;

    @Autowired
    RadnikZaZivotinjuService radnikZaZivotinjuService;

    @Autowired
    KalendarRadnikService kalendarRadnikService;

    @Autowired
    private KvalifikacijaService kvalifikacijaService;
    @GetMapping("/unosRadnika")
    public String showCreateRadnikForm(Model model) {
        Radnik radnik = new Radnik();
        model.addAttribute("radnik", radnik);
        model.addAttribute("kvalifikacijaList", kvalifikacijaService.findAll());

        return "Radnik/createRadnik";
    }


    @PostMapping("/unosRadnika")
    public String createRadnik(@ModelAttribute Radnik radnik) {
        radnikService.save(radnik);
        return "redirect:/unosRadnika";
    }

    @GetMapping("/radnikZaZivotinju")
    public String createRadnikZaZivoitnjuForm(Model model){

        model.addAttribute("radnikZaZivotinju",new RadnikZaZivoitnju());
        model.addAttribute("radnici",this.radnikService.pronadjiSlobodneRadnike());
        model.addAttribute("zivotinje",this.zivotinjaService.findAllCurrentAnimals());

        return "Radnik/radnikZaZivotinjuCreate";
    }

    @PostMapping("/radnikZaZivotinju")
    public String createRadnikZaZivotnju(RadnikZaZivoitnju radnikZaZivoitnju){

        this.radnikZaZivotinjuService.create(radnikZaZivoitnju);
        return "redirect:/radnikZaZivotinju";
    }

    @GetMapping("/radnik/kalendarRada")
    public String createKalendarForm(Model model){
        model.addAttribute("kalendarRada",new KalendarRadnik());
        model.addAttribute("radnici",this.radnikService.findAll());

        return "Radnik/createKalendarRada";
    }

    @GetMapping("/radnikZaZivotinju/deleteAll")
    public String deleteAllRadnikZaZivotinju(){
        this.radnikZaZivotinjuService.deleteAll();
        return "redirect:/radnikZaZivotinju";
    }

    @PostMapping("/radnik/kaldendarRada")
    public String createKalendarRadnik(KalendarRadnik kalendarRadnik)
    {
        this.kalendarRadnikService.create(kalendarRadnik);
        return "redirect:/radnik/kalendarRada";
    }
    @GetMapping("/listRadnik")
    public String getAllRadnik(Model model){
        List<Radnik> Radnik = radnikService.findAll();
        model.addAttribute("radnik", Radnik);
        return "Radnik/ListRadnik";
    }

    @GetMapping("/listRadnik/delete/{id}")
    public String deleteRadnik(@PathVariable Long id){
        radnikService.deleteRadnik(id);
        return "redirect:/listRadnik";
    }
    @GetMapping("/listRadnik/edit/{id}")
    public String editRadnikForm(@PathVariable Long id, Model model) {
        Optional <Radnik> optionalRadnik = radnikService.findById(id);
        if (optionalRadnik.isEmpty()) {
            throw new EntityNotFoundException("Radnik sa ID-om " + id + " nije pronađen");
        }
        Radnik radnik = optionalRadnik.get();
        model.addAttribute("radnik", radnik);
        model.addAttribute("kvalifikacijaList", kvalifikacijaService.findAll());

        return "Radnik/EditRadnik";
    }

    @PostMapping("/listRadnik/edit/{id}")
    public String updateRadnik(@PathVariable Long id, Radnik radnik) {
        radnikService.updateRadnik(id, radnik);
        return "redirect:/listRadnik";
    }
}
