package com.example.zoo.Service;

import com.example.zoo.models.Nastanba;
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

    public boolean provjeriNastanbu(Zivotinja zivotinja){
        Zivotinja provjeraNastanbe = this.zivotinjaRepository.provjeraNastanbe(zivotinja.getNastanba());
        if(provjeraNastanbe == null){
            return true;
        }else{
            Zivotinja rezultat = this.zivotinjaRepository.provjeraPostojanjaZivotinje(zivotinja.getVrstaZivotinje(),zivotinja.getNastanba());
            if(rezultat == null){
                return false;
            }else {
                return true;
            }
        }

    }

    public void deleteZivotinja(Long id) {
        zivotinjaRepository.deleteById(id);
    }

    public List<Zivotinja>findAllCurrentAnimals(){
        return this.zivotinjaRepository.findAllCurrentAnimals(true);
    }
}
