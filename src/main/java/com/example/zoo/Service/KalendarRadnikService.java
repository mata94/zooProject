package com.example.zoo.Service;

import com.example.zoo.models.KalendarRadnik;
import com.example.zoo.repository.KalendarRadnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KalendarRadnikService {

    @Autowired
    KalendarRadnikRepository kalendarRadnikRepository;
    public void create(KalendarRadnik kalendarRadnik){
        this.kalendarRadnikRepository.save(kalendarRadnik);
    }

}
