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

    @Transactional
    public void updateIncident(Long id, Incident updatedIncident) {
        Incident existingIncident = incidentRepository.findById(id).orElse(null);
        if (existingIncident != null) {
            existingIncident.setVrstaIncidenta(updatedIncident.getVrstaIncidenta());
            existingIncident.setZivotinja(updatedIncident.getZivotinja());
            existingIncident.setNastanba(updatedIncident.getNastanba());
            existingIncident.setKomentar(updatedIncident.getKomentar());
            existingIncident.setPopravak(updatedIncident.getPopravak());
            existingIncident.setDatum(updatedIncident.getDatum());
            incidentRepository.save(existingIncident);
        }
    }
}
