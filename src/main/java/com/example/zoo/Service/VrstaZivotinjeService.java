package com.example.zoo.Service;

import com.example.zoo.models.VrstaZivotinje;
import com.example.zoo.repository.VrstaZivotinjeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VrstaZivotinjeService {

    @Autowired
    VrstaZivotinjeRepository vrstaZivotinjeRepository;

    public void createVrsta(VrstaZivotinje vrstaZivotinje){
        this.vrstaZivotinjeRepository.save(vrstaZivotinje);
    }

    public List<VrstaZivotinje> findAll(){
        return this.vrstaZivotinjeRepository.findAll();
    }

    public void deleteById(Long id) {vrstaZivotinjeRepository.deleteById(id);}

    public Optional<VrstaZivotinje> findById(Long id) {
        return vrstaZivotinjeRepository.findById(id);
    }
    public void updateVrsta(Long id, VrstaZivotinje updatedVrstaZivotinje) {
        VrstaZivotinje vrsta = vrstaZivotinjeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vrsta Zivotinje sa ID-om " + id + " nije pronađena"));
        vrsta.setImeHrv(updatedVrstaZivotinje.getImeHrv());
        vrsta.setImeEng(updatedVrstaZivotinje.getImeEng());
        vrsta.setImeLat(updatedVrstaZivotinje.getImeLat());
        vrstaZivotinjeRepository.save(vrsta);
    }
}

