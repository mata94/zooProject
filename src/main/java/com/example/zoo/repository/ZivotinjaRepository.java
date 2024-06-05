package com.example.zoo.repository;

import com.example.zoo.models.Nastanba;
import com.example.zoo.models.VrstaZivotinje;
import com.example.zoo.models.Zivotinja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZivotinjaRepository extends JpaRepository<Zivotinja,Long> {

    @Query("SELECT z FROM Zivotinja z INNER JOIN z.vrstaZivotinje vr INNER JOIN z.nastanba n WHERE vr =:vrsta AND n =:nastanba")
    public Zivotinja provjeraPostojanjaZivotinje(@Param("vrsta")VrstaZivotinje vrstaZivotinje,
                                                 @Param("nastanba")Nastanba nastanba);

    @Query("SELECT z FROM Zivotinja z WHERE z.postojanjeZivotinje =:postojanje")
    public List<Zivotinja> findAllCurrentAnimals(boolean postojanje);

    @Query("SELECT z FROM Zivotinja z INNER JOIN z.nastanba n WHERE n =:nastanba")
    public Zivotinja provjeraNastanbe(@Param("nastanba")Nastanba nastanba);
}
