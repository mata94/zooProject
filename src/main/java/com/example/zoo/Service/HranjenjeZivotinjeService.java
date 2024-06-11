package com.example.zoo.Service;

import com.example.zoo.models.HranjenjeZivotinje;
import com.example.zoo.models.RadnikZaZivoitnju;
import com.example.zoo.repository.HranjenjeZivotinjeRepository;
import com.example.zoo.repository.RadnikZaZivotinjuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class HranjenjeZivotinjeService {

    @Autowired
    HranjenjeZivotinjeRepository hranjenjeZivotinjeRepository;

    @Autowired
    RadnikZaZivotinjuRepository radnikZaZivotinjuRepository;
    public void create(HranjenjeZivotinje hranjenjeZivotinje){
        this.hranjenjeZivotinjeRepository.save(hranjenjeZivotinje);
    }

    @Scheduled(cron = "0 03 19 * * *")
    public void scheduleHranjenje() {
        LocalDate today = LocalDate.now();
        List<RadnikZaZivoitnju> radnikZaZivoitnje = this.radnikZaZivotinjuRepository.findAll();

        for (RadnikZaZivoitnju radnikZivotinja : radnikZaZivoitnje) {
            HranjenjeZivotinje hranjenjeZivotinje = new HranjenjeZivotinje(
                    radnikZivotinja.getZivotinja(),
                    radnikZivotinja.getRadnik()
                    ,today);

            hranjenjeZivotinjeRepository.save(hranjenjeZivotinje);
        }
    }

    public List<HranjenjeZivotinje> findAll(){
        return this.hranjenjeZivotinjeRepository.findAll();
    }

    public HranjenjeZivotinje findById(Long id){
        Optional<HranjenjeZivotinje> hranjenjeZivotinjeOpt= this.hranjenjeZivotinjeRepository.findById(id);

        if(hranjenjeZivotinjeOpt.isPresent()){
            return hranjenjeZivotinjeOpt.get();
        }else{
         throw new RuntimeException("Hranjenje zivotnje ne postoji");
        }
    }
}
