package com.example.zoo.repository;

import com.example.zoo.models.PorijekloZivotinje;
import com.example.zoo.models.Radnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Repository
public interface RadnikRepository extends JpaRepository<Radnik,Long> {

    @Query("SELECT r FROM Radnik r INNER JOIN KalendarRadnik kr ON r.id = kr.radnik.id " +
            "WHERE (kr.godisnjiOd IS NULL OR :zadnjiDatum < kr.godisnjiOd OR :trenutniDatum > kr.godisnjiDo) " +
            "AND (kr.nedostupnostOd IS NULL OR :zadnjiDatum < kr.nedostupnostOd OR :trenutniDatum > kr.nedostupnostDo)")
    public List<Radnik> pronadjiSlobodneRadnike(@Param("trenutniDatum") Date trenutniDatum,
                                                @Param("zadnjiDatum") Date zadnjiDatum);


    @Query("SELECT r FROM Radnik r INNER JOIN r.kvalifikacija k " +
            "WHERE LOWER(k.naziv) = 'vodic' OR LOWER(k.naziv) = 'vodič'")
    List<Radnik> pronađiVodica();
}


