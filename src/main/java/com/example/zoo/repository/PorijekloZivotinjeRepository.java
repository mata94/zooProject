package com.example.zoo.repository;

import com.example.zoo.models.PorijekloZivotinje;
import com.example.zoo.models.TipNastanbe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PorijekloZivotinjeRepository extends JpaRepository<PorijekloZivotinje,Long> {


}
