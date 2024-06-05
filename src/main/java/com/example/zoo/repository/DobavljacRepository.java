package com.example.zoo.repository;

import com.example.zoo.models.Dobavljac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface DobavljacRepository extends JpaRepository<Dobavljac,Long> {
}
