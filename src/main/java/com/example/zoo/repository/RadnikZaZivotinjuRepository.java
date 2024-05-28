package com.example.zoo.repository;

import com.example.zoo.models.RadnikZaZivoitnju;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RadnikZaZivotinjuRepository extends JpaRepository<RadnikZaZivoitnju,Long> {
}
