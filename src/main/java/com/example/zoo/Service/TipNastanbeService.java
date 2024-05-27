package com.example.zoo.Service;

import com.example.zoo.models.TipNastanbe;
import com.example.zoo.repository.TipNastanbeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipNastanbeService {

    @Autowired
    TipNastanbeRepository tipNastanbeRepository;

    public void createTip(TipNastanbe tipNastanbe){
        this.tipNastanbeRepository.save(tipNastanbe);
    }

    public List<TipNastanbe> findAll(){
        return tipNastanbeRepository.findAll();
    }

}
