package com.example.zoo.Service;

import com.example.zoo.models.OblikNastanbe;
import com.example.zoo.repository.OblikNastanbeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OblikNastanbeService {

    @Autowired
    OblikNastanbeRepository oblikNastanbeRepository;

    public void createOblikNastanbe(OblikNastanbe oblikNastanbe){
        this.oblikNastanbeRepository.save(oblikNastanbe);
    }

    public List<OblikNastanbe> findAll(){
        return oblikNastanbeRepository.findAll();
    }
}
