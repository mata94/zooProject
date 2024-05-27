package com.example.zoo.repository;

import com.example.zoo.models.OblikNastanbe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OblikNastanbeRepository extends JpaRepository<OblikNastanbe,Long> {
}
