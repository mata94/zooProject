package com.example.zoo.repository;

import com.example.zoo.models.HranaZaZivotinje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface HranaZaZivotinjeRepository extends JpaRepository<HranaZaZivotinje,Long> {
}
