package com.example.zoo.Service;

import com.example.zoo.models.VrstaIncidenta;
import com.example.zoo.repository.VrstaIncidentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VrstaIncidentaService {
    @Autowired
    VrstaIncidentaRepository vrstaIncidentaRepository;

    public void createVrstaIncidenta(VrstaIncidenta vrstaIncidenta){
        this.vrstaIncidentaRepository.save(vrstaIncidenta);
    }


    public List<VrstaIncidenta> findAll() {return vrstaIncidentaRepository.findAll();}

    public void deleteById(long id) {vrstaIncidentaRepository.deleteById(id);}

    public Optional<VrstaIncidenta> findById(long id) {
        return vrstaIncidentaRepository.findById(id);
    }

    public void updateVrstaIncidenta(long id, VrstaIncidenta updatedVrstaIncidenta) {
        Optional<VrstaIncidenta> optionalVrstaIncidenta = vrstaIncidentaRepository.findById(id);
        if (optionalVrstaIncidenta.isPresent()) {
            updatedVrstaIncidenta.setId(id);
            vrstaIncidentaRepository.save(updatedVrstaIncidenta);
        } else {
            // Handle case where the entity with the provided id does not exist
            // You might throw an exception or handle it differently based on your application's logic
        }
    }
}
