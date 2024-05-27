package com.example.zoo.Service;

import com.example.zoo.models.TipNastanbe;
import com.example.zoo.models.VrstaIncidenta;
import com.example.zoo.repository.VrstaIncidentaRepository;
import org.springframework.stereotype.Service;

@Service
public class VrstaIncidentaService {
    VrstaIncidentaRepository vrstaIncidentaRepository;

    public void createVrstaIncidenta(VrstaIncidenta vrstaIncidenta){
        this.vrstaIncidentaRepository.save(vrstaIncidenta);
    }
}
