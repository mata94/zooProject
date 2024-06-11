package com.example.zoo.Service;

import com.example.zoo.models.Kvalifikacija;
import com.example.zoo.repository.KvalifikacijaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class KvalifikacijaService {
    @Autowired
    KvalifikacijaRepository kvalifikacijaRepository;

    public void create(Kvalifikacija kvalifikacija){
        this.kvalifikacijaRepository.save(kvalifikacija);
    }

    public List<Kvalifikacija> findAll() {return kvalifikacijaRepository.findAll();}

    public void deleteKvalifikacija(Long id) {kvalifikacijaRepository.deleteById(id);}

    public Optional<Kvalifikacija> findById(Long id) {
        return kvalifikacijaRepository.findById(id);
    }

    public void updateKvalifikacija(Long id, Kvalifikacija updatedKvalifikacija) {
        Kvalifikacija existingKvalifikacija = kvalifikacijaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Kvalifikacija with id " + id + " not found"));
        // Update existing Kvalifikacija with properties of updated Kvalifikacija
        existingKvalifikacija.setNaziv(updatedKvalifikacija.getNaziv());
        // Update other properties as needed
        kvalifikacijaRepository.save(existingKvalifikacija);
    }
}
