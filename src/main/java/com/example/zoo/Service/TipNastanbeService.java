package com.example.zoo.Service;

import com.example.zoo.models.TipNastanbe;
import com.example.zoo.repository.TipNastanbeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipNastanbeService {


    @Autowired
    TipNastanbeRepository tipNastanbeRepository;

    public void createTip(TipNastanbe tipNastanbe){
        this.tipNastanbeRepository.save(tipNastanbe);
    }
}
