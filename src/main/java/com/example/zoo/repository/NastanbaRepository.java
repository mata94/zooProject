package com.example.zoo.repository;

import com.example.zoo.models.Nastanba;

import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NastanbaRepository extends JpaRepository<Nastanba,Long> {
}
