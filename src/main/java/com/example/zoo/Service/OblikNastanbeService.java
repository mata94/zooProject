package com.example.zoo.Service;

import com.example.zoo.models.OblikNastanbe;
import com.example.zoo.models.PorijekloZivotinje;
import com.example.zoo.repository.OblikNastanbeRepository;
import com.example.zoo.repository.PorijekloZivotinjeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OblikNastanbeService {

    @Autowired
    OblikNastanbeRepository oblikNastanbeRepository;

    public void createOblikNastanbe(OblikNastanbe oblikNastanbe){
        this.oblikNastanbeRepository.save(oblikNastanbe);
    }
}
