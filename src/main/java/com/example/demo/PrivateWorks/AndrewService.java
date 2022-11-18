package com.example.demo.PrivateWorks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class AndrewService {
    private final AndrewRepository andrewRepository;

    @Autowired
    public AndrewService(AndrewRepository andrewRepository){
        this.andrewRepository =andrewRepository;
}
    public  List<Andrew> getAndrew() {
        return andrewRepository.findAll();
    }
}
