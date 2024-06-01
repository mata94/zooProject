package com.example.zoo.Service;

import com.example.zoo.models.OblikNastanbe;
import com.example.zoo.models.TipNastanbe;
import com.example.zoo.repository.TipNastanbeRepository;
import jakarta.persistence.EntityNotFoundException;
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

    public void deleteTipNastanbe(Long id){ tipNastanbeRepository.deleteById(id);}

    public TipNastanbe updateTipNastanbe(Long id , TipNastanbe noviTip){
        TipNastanbe tipNastanbe = tipNastanbeRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Tip nastanbe sa ID-om" + id + "nije pronađen"));

        tipNastanbe.setNaziv(noviTip.getNaziv());

        return tipNastanbeRepository.save(tipNastanbe);

    }

}
