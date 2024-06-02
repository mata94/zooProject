package com.example.zoo.Service;

import com.example.zoo.models.Nastanba;
import com.example.zoo.models.Posjete;
import com.example.zoo.repository.PosjetaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PosjeteService {

    @Autowired
    private PosjetaRepository posjeteRepository;

    public void save(Posjete posjete) {
        posjeteRepository.save(posjete);
    }

    public List<Posjete> findAll() { return this.posjeteRepository.findAll(); }

    public void deletePosjeta(Long id) { posjeteRepository.deleteById(id);}

}

