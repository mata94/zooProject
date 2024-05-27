package com.example.zoo.Service;

import com.example.zoo.models.PorijekloZivotinje;
import com.example.zoo.models.TipNastanbe;
import com.example.zoo.repository.PorijekloZivotinjeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PorijekloZivotinjeService {

    @Autowired
    PorijekloZivotinjeRepository porijekloZivotinjeRepository;

    public void createPorijeklo(PorijekloZivotinje porijekloZivotinje){
        this.porijekloZivotinjeRepository.save(porijekloZivotinje);
    }

    public List<PorijekloZivotinje>findAll(){
        return this.porijekloZivotinjeRepository.findAll();
    }
}
