package com.example.zoo.Controllers;

import com.example.zoo.Service.OblikNastanbeService;
import com.example.zoo.models.OblikNastanbe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OblikNastanbeController {

    @Autowired
    OblikNastanbeService oblikNastanbeService;

    @GetMapping("/oblikNastanbe")
    public String createOblikNastanbeForm(Model model){
        OblikNastanbe oblik = new OblikNastanbe();
        model.addAttribute("oblik", oblik);

        return "OblikNastanbe/createOblik";
    }


    @PostMapping("/oblikNastanbe")
    public String createOblikNastanbe(Model model, OblikNastanbe oblikNastanbe){
        this.oblikNastanbeService.createOblikNastanbe(oblikNastanbe);

        return "redirect:/oblikNastanbe";
    }
}
