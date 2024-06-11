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

    @Autowired
    TipNastanbeRepository TipNastanbeRepository;

    public void updateTipNastanbe(Long id, TipNastanbe updatedTip) {
        Optional<TipNastanbe> optionalTipNastanbe = TipNastanbeRepository.findById(id);
        if (optionalTipNastanbe.isPresent()) {
            TipNastanbe tipNastanbe = optionalTipNastanbe.get();
            tipNastanbe.setNaziv(updatedTip.getNaziv());
            // If there are more fields to update, add them here

            tipNastanbeRepository.save(tipNastanbe);
        } else {
            // Handle case where the entity with the provided id does not exist
            // You might throw an exception or handle it differently based on your application's logic
        }
    }
}
