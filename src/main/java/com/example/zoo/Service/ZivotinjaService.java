package com.example.zoo.Service;

import com.example.zoo.models.Zivotinja;
import com.example.zoo.repository.ZivotinjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ZivotinjaService {
    @Autowired
    ZivotinjaRepository zivotinjaRepository;

    public void create(Zivotinja zivotinja){
        this.zivotinjaRepository.save(zivotinja);
    }



    public List<Zivotinja> findAll() {return zivotinjaRepository.findAll();}
}
