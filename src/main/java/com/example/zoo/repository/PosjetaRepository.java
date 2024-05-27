package com.example.zoo.repository;

import com.example.zoo.models.Posjete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PosjetaRepository extends JpaRepository<Posjete,Long> {
}
