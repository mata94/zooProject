package com.example.zoo.repository;

import com.example.zoo.Service.HranjenjeZivotinjeService;
import com.example.zoo.models.HranjenjeZivotinje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HranjenjeZivotinjeRepository extends JpaRepository<HranjenjeZivotinje,Long> {
}
