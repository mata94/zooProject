package com.example.zoo.Controllers;

import com.example.zoo.Service.OblikNastanbeService;
import com.example.zoo.models.OblikNastanbe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class OblikNastanbeController {

    @Autowired
    OblikNastanbeService oblikNastanbeService;

    @GetMapping("/oblikNastanbe")
    public String createOblikNastanbeForm(Model model){
        OblikNastanbe oblik = new OblikNastanbe();
        model.addAttribute("oblik", oblik);

        return "OblikNastanbe/CreateOblik";
    }


    @PostMapping("/oblikNastanbe")
    public String createOblikNastanbe(Model model, OblikNastanbe oblikNastanbe){
        this.oblikNastanbeService.createOblikNastanbe(oblikNastanbe);

        return "redirect:/oblikNastanbe";
    }

    @GetMapping("/listOblikNastanbe")
    public String getAllOblikNastanbe(Model model){
        List<OblikNastanbe> oblikNastanbe = oblikNastanbeService.findAll();
        model.addAttribute("oblikNastanbe", oblikNastanbe);
        return "OblikNastanbe/ListOblikNastanbe";
    }

    @GetMapping("/listOblikNastanbe/delete/{id}")
    public String deleteOblikNastanbe(@PathVariable Long id){
        oblikNastanbeService.deleteOblikNastanbe(id);
        return "redirect:/listOblikNastanbe";
    }
    @GetMapping("/listOblikNastanbe/edit/{id}")
    public String editOblikNastanbeForm(@PathVariable Long id, Model model){
        OblikNastanbe oblikNastanbe = oblikNastanbeService.findById(id);
        model.addAttribute("oblik", oblikNastanbe);
        return "OblikNastanbe/editOblikNastanbe";
    }

    @PostMapping("/listOblikNastanbe/edit/{id}")
    public String editOblikNastanbe(@PathVariable Long id, @ModelAttribute("oblik") OblikNastanbe oblikNastanbe){
        oblikNastanbeService.updateOblikNastanbe(id, oblikNastanbe);
        return "redirect:/listOblikNastanbe";
    }

}
