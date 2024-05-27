package com.example.zoo.Service;

import com.example.zoo.models.Incident;
import com.example.zoo.repository.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IncidentService {
    @Autowired
    IncidentRepository incidentRepository;

    public void createIncident(Incident incident) {
        this.incidentRepository.save(incident);
    }
}
