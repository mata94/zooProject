package com.example.zoo.Service;

import com.example.zoo.models.Nastanba;
import com.example.zoo.repository.NastanbaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NastanbaService {
    @Autowired
    NastanbaRepository nastanbaRepository;

    public void createNastanba(Nastanba nastanba) {
        this.nastanbaRepository.save(nastanba);
    }

    public List<Nastanba> findAll(){
        return this.nastanbaRepository.findAll();
    }

    public void deleteNastanba(Long id){ nastanbaRepository.deleteById(id);}

    public Nastanba updateNastanba(Long id, Nastanba novaNastanba){
        Nastanba nastanba = nastanbaRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Nastamba sa ID-om " + id + "nije pronađena"));

        nastanba.setBrojcanaLokacija(novaNastanba.getBrojcanaLokacija());
        nastanba.setNaziv(novaNastanba.getNaziv());
        nastanba.setMjestoPromatranja(novaNastanba.getMjestoPromatranja());
        nastanba.setOblikNastanbe(novaNastanba.getOblikNastanbe());
        nastanba.setTipNastanbe(novaNastanba.getTipNastanbe());
        nastanba.setStrukturaNastanbe(novaNastanba.getStrukturaNastanbe());

        return nastanbaRepository.save(nastanba);

    }


}
