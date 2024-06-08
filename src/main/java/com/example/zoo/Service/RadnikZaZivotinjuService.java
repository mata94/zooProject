package com.example.zoo.Service;

import com.example.zoo.models.RadnikZaZivoitnju;
import com.example.zoo.repository.RadnikZaZivotinjuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class RadnikZaZivotinjuService {

    @Autowired
    RadnikZaZivotinjuRepository radnikZaZivotinjuRepository;

    public void create(RadnikZaZivoitnju radnikZaZivoitnju){

        Date currentDate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        cal.add(Calendar.DAY_OF_MONTH, 7);
        Date endDate = cal.getTime();

        radnikZaZivoitnju.setDatumOd(currentDate);
        radnikZaZivoitnju.setDatumDo(endDate);
        this.radnikZaZivotinjuRepository.save(radnikZaZivoitnju);
    }

    public void deleteAll(){
        this.radnikZaZivotinjuRepository.deleteAll();
    }
}
