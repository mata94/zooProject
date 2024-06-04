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
            "WHERE :trenutnoVrijeme BETWEEN kr.radnoVrijemeOd AND kr.radnoVrijemeDo " +
            "AND ((kr.godisnjiOd IS NULL OR :trenutniDatum NOT BETWEEN kr.godisnjiOd AND kr.godisnjiDo) " +
            "OR (kr.nedostupnostOd IS NULL OR :trenutniDatum NOT BETWEEN kr.nedostupnostOd AND kr.nedostupnostDo))")
    public List<Radnik> pronadjiSlobodneRadnike(@Param("trenutnoVrijeme") LocalTime trenutnoVrijeme,
                                                @Param("trenutniDatum") Date trenutniDatum);
}
