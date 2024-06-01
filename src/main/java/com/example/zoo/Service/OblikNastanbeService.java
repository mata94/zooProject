package com.example.zoo.Service;

import com.example.zoo.models.OblikNastanbe;
import com.example.zoo.repository.OblikNastanbeRepository;
import jakarta.persistence.EntityNotFoundException;
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

    public void deleteOblikNastanbe(Long id){ oblikNastanbeRepository.deleteById(id);}

    public OblikNastanbe updateOblikNastanbe(Long id , OblikNastanbe noviOblik){
        OblikNastanbe oblikNastanbe = oblikNastanbeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Oblik nastanbe sa ID-om" + id + "nije pronađen"));

        oblikNastanbe.setNaziv(noviOblik.getNaziv());

        return oblikNastanbeRepository.save(oblikNastanbe);

    }

}
