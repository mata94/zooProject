package com.example.zoo.Controllers;

import com.example.zoo.Service.PorijekloZivotinjeService;
import com.example.zoo.models.PorijekloZivotinje;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PorijekloZivotinjeController {

    @Autowired
    PorijekloZivotinjeService porijekloZivotinjeService;

    @GetMapping("/porijekloZivotinje")
    public String createPorijekloZivotinjeForm(Model model){
        PorijekloZivotinje porijeklo = new PorijekloZivotinje();
        model.addAttribute("porijeklo",porijeklo);

        return "PorijekloZivotinje/createPorijeklo";
    }

    @PostMapping("/porijekloZivotinje")
    public String createTip(Model model, PorijekloZivotinje porijekloZivotinje){
        this.porijekloZivotinjeService.createPorijeklo(porijekloZivotinje);

        return "redirect:/porijekloZivotinje";
    }
}
