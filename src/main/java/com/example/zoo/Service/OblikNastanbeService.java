package com.example.zoo.Service;

import com.example.zoo.models.OblikNastanbe;
import com.example.zoo.repository.OblikNastanbeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public OblikNastanbe findById(Long id){
        Optional<OblikNastanbe> optionalOblikNastanbe = oblikNastanbeRepository.findById(id);
        return optionalOblikNastanbe.orElseThrow(() -> new EntityNotFoundException("OblikNastanbe with id " + id + " not found"));
    }

    public OblikNastanbe updateOblikNastanbe(Long id, OblikNastanbe updatedOblik){
        OblikNastanbe existingOblik = findById(id);
        existingOblik.setNaziv(updatedOblik.getNaziv());
        return oblikNastanbeRepository.save(existingOblik);
    }

}
