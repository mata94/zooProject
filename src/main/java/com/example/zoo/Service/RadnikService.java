package com.example.zoo.Service;

import com.example.zoo.models.Radnik;
import com.example.zoo.repository.RadnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RadnikService {

    @Autowired
    private RadnikRepository radnikRepository;

    public void save(Radnik radnik) {
        radnikRepository.save(radnik);
    }

    public Radnik findById(Long id) {
        return radnikRepository.findById(id).orElse(null);
    }
}
