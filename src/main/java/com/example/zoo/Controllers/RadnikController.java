package com.example.zoo.Controllers;


import com.example.zoo.Service.*;
import com.example.zoo.models.KalendarRadnik;
import com.example.zoo.models.Radnik;
import com.example.zoo.models.RadnikZaZivoitnju;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalTime;
import java.util.List;

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
        model.addAttribute("radnici",this.radnikService.findAll());
        model.addAttribute("zivotinje",this.zivotinjaService.findAll());

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

    @PostMapping("/radnik/kaldendarRada")
    public String createKalendarRadnik(KalendarRadnik kalendarRadnik)
    {
        this.kalendarRadnikService.create(kalendarRadnik);
        return "redirect:/radnik/kalendarRada";
    }
}
