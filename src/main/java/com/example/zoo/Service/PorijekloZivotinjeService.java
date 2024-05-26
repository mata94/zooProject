package com.example.zoo.Service;

import com.example.zoo.models.PorijekloZivotinje;
import com.example.zoo.models.TipNastanbe;
import com.example.zoo.repository.PorijekloZivotinjeRepository;
import org.springframework.stereotype.Service;

@Service
public class PorijekloZivotinjeService {

    PorijekloZivotinjeRepository porijekloZivotinjeRepository;

    public void createPorijeklo(PorijekloZivotinje porijekloZivotinje){
        this.porijekloZivotinjeRepository.save(porijekloZivotinje);
    }
}
