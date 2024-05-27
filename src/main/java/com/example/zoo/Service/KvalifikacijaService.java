package com.example.zoo.Service;

import com.example.zoo.models.Kvalifikacija;
import com.example.zoo.repository.KvalifikacijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KvalifikacijaService {
    @Autowired
    KvalifikacijaRepository kvalifikacijaRepository;

    public void create(Kvalifikacija kvalifikacija){
        this.kvalifikacijaRepository.save(kvalifikacija);
    }
}
