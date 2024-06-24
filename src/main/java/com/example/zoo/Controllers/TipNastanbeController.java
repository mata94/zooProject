package com.example.zoo.Controllers;

import com.example.zoo.Service.TipNastanbeService;

import com.example.zoo.models.TipNastanbe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        return "TipNastanbe/ListTipNastanbe";
    }

    @GetMapping("/listTipNastanbe/delete/{id}")
    public String deleteTipNastanbe(@PathVariable Long id){
        tipNastanbeService.deleteTipNastanbe(id);
        return "redirect:/listTipNastanbe";

    }
    @GetMapping("/listTipNastanbe/edit/{id}")
    public String editTipNastanbeForm(@PathVariable Long id, Model model){
        TipNastanbe tipNastanbe = tipNastanbeService.findById(id);
        model.addAttribute("tip", tipNastanbe);
        return "TipNastanbe/editTipNastanbe";
    }

    @PostMapping("/listTipNastanbe/edit/{id}")
    public String editTipNastanbe(@PathVariable Long id, @ModelAttribute("tip") TipNastanbe tipNastanbe){
        tipNastanbeService.updateTipNastanbe(id, tipNastanbe);
        return "redirect:/listTipNastanbe";
    }



}
