package com.example.zoo.Controllers;

import com.example.zoo.Service.NastanbaService;
import com.example.zoo.Service.OblikNastanbeService;
import com.example.zoo.Service.TipNastanbeService;
import com.example.zoo.models.Nastanba;
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
public class NastanbaController {

    @Autowired
    NastanbaService nastanbaService;

    @Autowired
    TipNastanbeService tipNastanbeService;

    @Autowired
    OblikNastanbeService oblikNastanbeService;

    @GetMapping("/Nastanba")
    public String createNastanbaForm(Model model){
        Nastanba nastanba = new Nastanba();
        model.addAttribute("nastanba", nastanba);
        model.addAttribute("tipNastanbeList", tipNastanbeService.findAll());
        model.addAttribute("oblikNastanbeList", oblikNastanbeService.findAll());

        return "Nastanba/createNastanba";
    }

    @PostMapping("/Nastanba")
    public String createNastanba(Model model, Nastanba nastanba){
        this.nastanbaService.createNastanba(nastanba);

        return "redirect:/Nastanba";
    }

    @GetMapping("/listNastanba")
    public String getAllNastambe(Model model) {
        List<Nastanba> nastambe = nastanbaService.findAll();
        model.addAttribute("nastambe", nastambe);
        return "Nastanba/ListNastanba";
    }

    @GetMapping("/listNastanba/delete/{id}")
    public String deleteNastanba(@PathVariable Long id) {
        nastanbaService.deleteNastanba(id);
        return "redirect:/listNastanba";
    }

    @GetMapping("/listNastanba/edit/{id}")
    public String editNastanbaForm(@PathVariable Long id, Model model) {
        Optional<Nastanba> optionalNastanba = nastanbaService.findById(id);
        if (optionalNastanba.isEmpty()) {
            throw new EntityNotFoundException("Nastanba sa ID-om " + id + " nije pronađena");
        }
        Nastanba nastanba = optionalNastanba.get();
        model.addAttribute("nastanba", nastanba);
        model.addAttribute("tipNastanbeList", tipNastanbeService.findAll());
        model.addAttribute("oblikNastanbeList", oblikNastanbeService.findAll());
        return "Nastanba/EditNastanba";
    }

    @PostMapping("/listNastanba/edit/{id}")
    public String updateNastanba(@PathVariable Long id, Nastanba nastanba) {
        nastanbaService.updateNastanba(id, nastanba);
        return "redirect:/listNastanba";
    }

}
