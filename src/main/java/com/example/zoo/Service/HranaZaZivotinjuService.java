package com.example.zoo.Service;

import com.example.zoo.models.Dobavljac;
import com.example.zoo.models.HranaZaZivotinje;
import com.example.zoo.repository.DobavljacRepository;
import com.example.zoo.repository.HranaZaZivotinjeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HranaZaZivotinjuService {

    @Autowired
    private HranaZaZivotinjeRepository hranaZaZivotinjeRepository;

    @Autowired
    private DobavljacRepository dobavljacRepository;

    public void save(HranaZaZivotinje hranaZaZivotinje){
        this.hranaZaZivotinjeRepository.save(hranaZaZivotinje);
    }

    public void createDobavljac(Dobavljac dobavljac){
        this.dobavljacRepository.save(dobavljac);
    }

    public List<Dobavljac>pronadjiSveDobavljace(){
        return this.dobavljacRepository.findAll();
    }
}
