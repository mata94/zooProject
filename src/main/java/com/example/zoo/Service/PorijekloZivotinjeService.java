package com.example.zoo.Service;

import com.example.zoo.models.PorijekloZivotinje;
import com.example.zoo.models.TipNastanbe;
import com.example.zoo.repository.PorijekloZivotinjeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PorijekloZivotinjeService {

    @Autowired
    PorijekloZivotinjeRepository porijekloZivotinjeRepository;

    public void createPorijeklo(PorijekloZivotinje porijekloZivotinje){
        this.porijekloZivotinjeRepository.save(porijekloZivotinje);
    }

    public List<PorijekloZivotinje>findAll(){
        return this.porijekloZivotinjeRepository.findAll();
    }

    public void deleteById(Long id) {porijekloZivotinjeRepository.deleteById(id);}

    public PorijekloZivotinje findById(Long id) {
        return porijekloZivotinjeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Porijeklo Zivotinje with ID: " + id + " not found"));
    }

    public PorijekloZivotinje updatePorijeklo(Long id, PorijekloZivotinje updatedPorijeklo) {
        PorijekloZivotinje porijekloZivotinje = findById(id);
        porijekloZivotinje.setNaziv(updatedPorijeklo.getNaziv());
        // Update other fields as needed
        return porijekloZivotinjeRepository.save(porijekloZivotinje);
    }
}
