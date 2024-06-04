package com.example.zoo.repository;

import com.example.zoo.models.KalendarRadnik;
import com.example.zoo.models.Radnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalTime;
import java.util.Date;

public interface KalendarRadnikRepository extends JpaRepository<KalendarRadnik,Long> {

    @Query("SELECT kr FROM KalendarRadnik kr WHERE kr.radnik = :radnik " +
            "OR :trenutnoVrijeme BETWEEN kr.radnoVrijemeOd AND kr.radnoVrijemeDo " +
            "AND (kr.godisnjiOd IS NULL OR :trenutniDatum NOT BETWEEN kr.godisnjiOd AND kr.godisnjiDo) " +
            "OR (kr.nedostupnostOd IS NULL OR :trenutniDatum NOT BETWEEN kr.nedostupnostOd AND kr.nedostupnostDo)")
    public KalendarRadnik provjeraSlobodnogRadnika(@Param("radnik") Radnik radnik,
                                                   @Param("trenutnoVrijeme") LocalTime trenutnoVrijeme,
                                                   @Param("trenutniDatum") Date trenutniDatum);
}
