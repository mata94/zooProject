package com.example.zoo.Service;

import com.example.zoo.models.Posjete;
import com.example.zoo.repository.PosjetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PosjeteService {

    @Autowired
    private PosjetaRepository posjeteRepository;

    public void save(Posjete posjete) {
        posjeteRepository.save(posjete);
    }
}

