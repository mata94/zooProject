package com.example.zoo.Service;

import com.example.zoo.models.Nastanba;
import com.example.zoo.models.Posjete;
import com.example.zoo.repository.PosjetaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PosjeteService {

    @Autowired
    private PosjetaRepository posjeteRepository;

    public void save(Posjete posjete) {
        posjeteRepository.save(posjete);
    }

    public List<Posjete> findAll() { return this.posjeteRepository.findAll(); }


    public void deletePosjeta(Long id) { posjeteRepository.deleteById(id);}

    public Posjete updatePosjeta(Long id , Posjete novaPosjeta){
        Posjete posjeta = posjeteRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Posjeta sa ID-om " + id + "nije pronađena"));

        posjeta.setRadnik(novaPosjeta.getRadnik());
        posjeta.setNazivGrupe(novaPosjeta.getNazivGrupe());

        return posjeteRepository.save(posjeta);
    }


    public Optional<Posjete> findById(Long id) { return posjeteRepository.findById(id);}
}

