package com.example.zoo.Controllers;

import com.example.zoo.Service.PorijekloZivotinjeService;
import com.example.zoo.models.PorijekloZivotinje;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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
    @GetMapping("/listPorijekloZivotinje")
    public String getAllPorijeklaZivotinje(Model model,PorijekloZivotinje porijekloZivotinje){
        List<PorijekloZivotinje> PorijekloZivotinje = this.porijekloZivotinjeService.findAll();
        model.addAttribute("porijekloZivotinje",PorijekloZivotinje);
        return "PorijekloZivotinje/listPorijekloZivotinje";
    }

    @GetMapping("listPorijekloZivotinje/delete/{id}")
    public String deleteOrigin(@PathVariable("id") Long id) {
        porijekloZivotinjeService.deleteById(id);
        return "redirect:/listPorijekloZivotinje";
    }
    @GetMapping("/listPorijekloZivotinje/edit/{id}")
    public String editOriginForm(@PathVariable Long id, Model model) {
        PorijekloZivotinje porijekloZivotinje = porijekloZivotinjeService.findById(id);
        model.addAttribute("porijeklo", porijekloZivotinje);
        return "PorijekloZivotinje/editPorijekloZivotinje";
    }

    @PostMapping("/listPorijekloZivotinje/edit/{id}")
    public String editOrigin(@PathVariable Long id, @ModelAttribute("porijeklo") PorijekloZivotinje porijekloZivotinje) {
        porijekloZivotinjeService.updatePorijeklo(id, porijekloZivotinje);
        return "redirect:/listPorijekloZivotinje";
    }
}
