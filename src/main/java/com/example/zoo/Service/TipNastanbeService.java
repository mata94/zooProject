package com.example.zoo.Service;

import com.example.zoo.models.Nastanba;
import com.example.zoo.models.OblikNastanbe;
import com.example.zoo.models.TipNastanbe;
import com.example.zoo.repository.TipNastanbeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public TipNastanbe findById(Long id){
        Optional<TipNastanbe> tipOptional = tipNastanbeRepository.findById(id);
        return tipOptional.orElseThrow(() -> new EntityNotFoundException("TipNastanbe with ID " + id + " not found"));
    }

    public TipNastanbe updateTipNastanbe(Long id, TipNastanbe updatedTip){
        TipNastanbe tipNastanbe = findById(id);
        tipNastanbe.setNaziv(updatedTip.getNaziv());
        // If there are more fields to update, add them here

        return tipNastanbeRepository.save(tipNastanbe);
    }
}
