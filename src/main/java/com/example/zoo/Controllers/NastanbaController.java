package com.example.zoo.Controllers;


import com.example.zoo.Service.NastanbaService;
import com.example.zoo.Service.OblikNastanbeService;
import com.example.zoo.Service.TipNastanbeService;
import com.example.zoo.models.Nastanba;
import com.example.zoo.models.OblikNastanbe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NastanbaController {

    @Autowired
    NastanbaService nastanbaService;

    @Autowired
    private TipNastanbeService tipNastanbeService;

    @Autowired
    private OblikNastanbeService oblikNastanbeService;

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
}
