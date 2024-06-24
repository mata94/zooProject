package com.example.zoo.Service;

import com.example.zoo.models.Incident;
import com.example.zoo.repository.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IncidentService {
    @Autowired
    IncidentRepository incidentRepository;

    public void createIncident(Incident incident) {
        this.incidentRepository.save(incident);
    }

    public List<Incident> findAll() {
        return incidentRepository.findAll();
    }

    public void deleteIncident(Long id) {incidentRepository.deleteById(id);}
    public Incident findById(Long id) {
        return incidentRepository.findById(id).orElse(null);
    }

}
