package com.example.zoo.Controllers;

import com.example.zoo.Service.TipNastanbeService;

import com.example.zoo.models.TipNastanbe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TipNastanbeController {

    @Autowired
    TipNastanbeService tipNastanbeService;

    @GetMapping("/tipNastanbe")
    public String createTipForm(Model model){
        TipNastanbe tip = new TipNastanbe();
        model.addAttribute("tip",tip);

        return "TipNastanbe/createTip";
    }

    @PostMapping("/tipNastanbe")
    public String createTip(TipNastanbe tipNastanbe){
        this.tipNastanbeService.createTip(tipNastanbe);
        return "redirect:/tipNastanbe";
    }

    @GetMapping("/listTipNastanbe")
    public String getAllTipNastanbe(Model model){
        List<TipNastanbe> tipNastanbe = tipNastanbeService.findAll();
        model.addAttribute("tipNastanbe", tipNastanbe);
        return "TipNastanbe/listTipNastanbe";
    }

    @GetMapping("/listTipNastanbe/delete/{id}")
    public String deleteTipNastanbe(@PathVariable Long id){
        tipNastanbeService.deleteTipNastanbe(id);
        return "redirect:/listTipNastanbe";

    }

}
