package com.example.zoo.repository;

import com.example.zoo.models.TipNastanbe;
import com.example.zoo.models.VrstaIncidenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VrstaIncidentaRepository extends JpaRepository<VrstaIncidenta,Long> {

}
