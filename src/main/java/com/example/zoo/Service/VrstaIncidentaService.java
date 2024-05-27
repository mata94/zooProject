package com.example.zoo.Service;

import com.example.zoo.models.VrstaIncidenta;
import com.example.zoo.repository.VrstaIncidentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VrstaIncidentaService {
    @Autowired
    VrstaIncidentaRepository vrstaIncidentaRepository;

    public void createVrstaIncidenta(VrstaIncidenta vrstaIncidenta){
        this.vrstaIncidentaRepository.save(vrstaIncidenta);
    }


    public List<VrstaIncidenta> findAll() {return vrstaIncidentaRepository.findAll();}

}
