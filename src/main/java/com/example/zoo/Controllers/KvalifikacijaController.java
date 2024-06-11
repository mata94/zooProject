package com.example.zoo.Controllers;

import com.example.zoo.Service.KvalifikacijaService;
import com.example.zoo.models.Kvalifikacija;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class KvalifikacijaController {

    @Autowired
    KvalifikacijaService kvalifikacijaService;

    @GetMapping("/kvalifikacija")
    public String createKvalifikacijaForm(Model model){
        Kvalifikacija kvalifikacija = new Kvalifikacija();
        model.addAttribute("kvalifikacija",kvalifikacija);

        return "Kvalifikacija/createKvalifikacija";
    }

    @PostMapping("/kvalifikacija")
    public String createKvalifikacija(Kvalifikacija kvalifikacija){
        this.kvalifikacijaService.create(kvalifikacija);
        return "redirect:/kvalifikacija";
    }

    @GetMapping("/listKvalifikacija")
    public String getAllKvalifications(Model model)
    {
        List<Kvalifikacija> Kvalifikacija = kvalifikacijaService.findAll();
        model.addAttribute("kvalifikacija",Kvalifikacija);
        return "Kvalifikacija/listKvalifikacija";
    }

    @GetMapping("/listKvalifikacija/delete/{id}")
    public String deleteKvalifikacija(@PathVariable Long id)
    {
        kvalifikacijaService.deleteKvalifikacija(id);
        return "redirect:/listKvalifikacija";
    }

    @GetMapping("/listKvalifikacija/edit/{id}")
    public String editKvalifikacijaForm(@PathVariable Long id, Model model) {
        Kvalifikacija kvalifikacija = kvalifikacijaService.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Kvalifikacija with id " + id + " not found"));
        model.addAttribute("kvalifikacija", kvalifikacija);
        return "Kvalifikacija/editKvalifikacija";
    }

    @PostMapping("/listKvalifikacija/edit/{id}")
    public String updateKvalifikacija(@PathVariable Long id, Kvalifikacija kvalifikacija) {
        kvalifikacijaService.updateKvalifikacija(id, kvalifikacija);
        return "redirect:/listKvalifikacija";
    }
}
