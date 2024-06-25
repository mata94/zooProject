package com.example.zoo.Controllers;

import com.example.zoo.models.Posjete;
import com.example.zoo.models.Radnik;
import com.example.zoo.Service.PosjeteService;
import com.example.zoo.Service.RadnikService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PosjeteController {

    @Autowired
    private PosjeteService posjeteService;

    @Autowired
    private RadnikService radnikService;

    @GetMapping("/unosPosjete")
    public String showCreatePosjeteForm(Model model) {
        Posjete posjete = new Posjete();
        model.addAttribute("posjete", posjete);
        List<Radnik> radnici = radnikService.pronadjiVodica();
        model.addAttribute("radnici", radnici);
        return "Posjeta/createPosjeta";
    }

    @PostMapping("/unosPosjete")
    public String createPosjete(@ModelAttribute Posjete posjete) {
        posjeteService.save(posjete);
        return "redirect:/unosPosjete";
    }

    @GetMapping("/listPosjeta")
    public String getAllPosjeta(Model model){
        List<Posjete> posjete = posjeteService.findAll();
        model.addAttribute("posjete", posjete);
        return "Posjeta/ListPosjeta";
    }

    @GetMapping("/listPosjeta/delete/{id}")
    public String deletePosjeta(@PathVariable Long id){
        posjeteService.deletePosjeta(id);
        return "redirect:/listPosjeta";
    }

    @GetMapping("/listPosjeta/edit/{id}")
    public String showUpdatePosjetaForm(@PathVariable Long id, Model model) {
        Posjete posjeta = posjeteService.findById(id).orElseThrow(() -> new EntityNotFoundException("Posjeta sa ID-om " + id + " nije pronađena"));
        model.addAttribute("posjeta", posjeta);
        List<Radnik> radnici = radnikService.pronadjiVodica();
        model.addAttribute("radnici", radnici);
        return "Posjeta/EditPosjeta";
    }

    @PostMapping("/listPosjeta/edit/{id}")
    public String updatePosjeta(@PathVariable Long id, @ModelAttribute Posjete posjeta) {
        posjeteService.updatePosjeta(id, posjeta);
        return "redirect:/listPosjeta";
    }
}
