package com.example.zoo.Service;

import com.example.zoo.models.KalendarRadnik;
import com.example.zoo.models.Radnik;
import com.example.zoo.repository.KalendarRadnikRepository;
import com.example.zoo.repository.RadnikRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;


@Service
public class RadnikService {

    @Autowired
    private RadnikRepository radnikRepository;

    @Autowired
    private KalendarRadnikRepository kalendarRadnikRepository;

    public void save(Radnik radnik) {
        radnikRepository.save(radnik);
    }

    public Optional<Radnik> findById(Long id) {
        return Optional.ofNullable(radnikRepository.findById(id).orElse(null));
    }

    public List<Radnik> findAll() {
        return radnikRepository.findAll();
    }

    public boolean provjeraSlobodnogRadnika(Radnik radnik) {

        LocalTime currentTime = LocalTime.now();
        Date currentDate = new Date();
        KalendarRadnik kalendarRadnik = this.kalendarRadnikRepository.provjeraSlobodnogRadnika(radnik, currentTime, currentDate);

        if (kalendarRadnik == null) {
            return true;
        } else {
            return false;
        }
    }

    public List<Radnik> pronadjiSlobodneRadnike() {
        LocalTime currentTime = LocalTime.now();
        Date currentDate = new Date();
        return this.radnikRepository.pronadjiSlobodneRadnike(currentTime, currentDate);
    }

    public void deleteRadnik(Long id) {
        radnikRepository.deleteById(id);
    }

    public Radnik updateRadnik(Long id, Radnik noviRadnik) {
        Radnik radnik = radnikRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Radnik sa ID-om " + id + "nije pronađen"));

        radnik.setIme(noviRadnik.getIme());
        radnik.setPrezime(noviRadnik.getPrezime());
        radnik.setKvalifikacija(noviRadnik.getKvalifikacija());
        return radnikRepository.save(radnik);
    }
}