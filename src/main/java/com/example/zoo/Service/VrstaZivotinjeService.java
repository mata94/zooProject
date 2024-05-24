package com.example.zoo.Service;

import com.example.zoo.models.VrstaZivotinje;
import com.example.zoo.repository.VrstaZivotinjeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VrstaZivotinjeService {

    @Autowired
    VrstaZivotinjeRepository vrstaZivotinjeRepository;

    public void createVrsta(VrstaZivotinje vrstaZivotinje){
        this.vrstaZivotinjeRepository.save(vrstaZivotinje);
    }
}
