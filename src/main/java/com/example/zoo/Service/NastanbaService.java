package com.example.zoo.Service;

import com.example.zoo.models.Nastanba;
import com.example.zoo.repository.NastanbaRepository;
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


}
