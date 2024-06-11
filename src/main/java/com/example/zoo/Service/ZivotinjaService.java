package com.example.zoo.Service;

import com.example.zoo.models.Zivotinja;
import com.example.zoo.repository.ZivotinjaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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


    public Zivotinja updateZivotinja(Long id , Zivotinja novaZivotinja){
        Zivotinja zivotinja =zivotinjaRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Zivotinja sa ID-om " + id + "nije pronađena"));

        zivotinja.setNaziv(novaZivotinja.getNaziv());
        zivotinja.setIdentifikator(novaZivotinja.getIdentifikator());
        zivotinja.setSkupZivotinja(novaZivotinja.isSkupZivotinja());
        zivotinja.setBrojZivotinja(novaZivotinja.getBrojZivotinja());
        zivotinja.setNastanba(novaZivotinja.getNastanba());
        zivotinja.setPostojanjeZivotinje(novaZivotinja.isPostojanjeZivotinje());
        zivotinja.setDolazakZivotinje(novaZivotinja.getDolazakZivotinje());
        zivotinja.setPorijekloZivotinje(novaZivotinja.getPorijekloZivotinje());


        return zivotinjaRepository.save(zivotinja);
    }


    public Optional<Zivotinja> findById(Long id) { return zivotinjaRepository.findById(id);}

    public List<Zivotinja>findAll(String search){
        if(search == null){
            return this.zivotinjaRepository.findAll();
        }else{
            return this.zivotinjaRepository.findAllSearch(search);
        }
    }



}
