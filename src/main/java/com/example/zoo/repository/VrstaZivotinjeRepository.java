package com.example.zoo.repository;

import com.example.zoo.models.VrstaZivotinje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VrstaZivotinjeRepository extends JpaRepository<VrstaZivotinje,Long> {
}
