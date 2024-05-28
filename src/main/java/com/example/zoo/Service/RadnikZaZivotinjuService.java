package com.example.zoo.Service;

import com.example.zoo.models.RadnikZaZivoitnju;
import com.example.zoo.repository.RadnikZaZivotinjuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RadnikZaZivotinjuService {

    @Autowired
    RadnikZaZivotinjuRepository radnikZaZivotinjuRepository;

    public void create(RadnikZaZivoitnju radnikZaZivoitnju){
        this.radnikZaZivotinjuRepository.save(radnikZaZivoitnju);
    }
}
