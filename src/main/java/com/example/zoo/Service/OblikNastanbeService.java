package com.example.zoo.Service;

import com.example.zoo.models.OblikNastanbe;
import com.example.zoo.models.PorijekloZivotinje;
import com.example.zoo.repository.OblikNastanbeRepository;
import com.example.zoo.repository.PorijekloZivotinjeRepository;
import org.springframework.stereotype.Service;

@Service
public class OblikNastanbeService {

    OblikNastanbeRepository oblikNastanbeRepository;

    public void createOblikNastanbe(OblikNastanbe oblikNastanbe){
        this.oblikNastanbeRepository.save(oblikNastanbe);
    }
}
