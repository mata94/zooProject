package com.example.zoo.Controllers;


import com.example.zoo.Service.NastanbaService;
import com.example.zoo.Service.OblikNastanbeService;
import com.example.zoo.Service.TipNastanbeService;
import com.example.zoo.models.Nastanba;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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

}
