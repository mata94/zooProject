package com.example.zoo.repository;

import com.example.zoo.modelBuilder.MjesecniTroskovi;
import com.example.zoo.models.HranaZaZivotinje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HranaZaZivotinjeRepository extends JpaRepository<HranaZaZivotinje,Long> {

    @Query("SELECT new com.example.zoo.modelBuilder.MjesecniTroskovi(d.naziv, SUM(hz.price), MONTH(hz.datum), YEAR(hz.datum)) " +
            "FROM HranaZaZivotinje hz " +
            "JOIN hz.dobavljac d " +
            "GROUP BY d.naziv, MONTH(hz.datum), YEAR(hz.datum)")
    public List<MjesecniTroskovi>mjesecniTroskovi();
}
