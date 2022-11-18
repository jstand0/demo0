package com.example.demo.PrivateWorks;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class AndrewConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            AndrewRepository repository) {
        return args -> {
            Andrew andrew = new Andrew(
                    "Andrew",
                    "akiricuk37@gmail.com",
                    LocalDate.of(2007, Month.FEBRUARY, 18),
                    15
                    );
                Andrew friend  = new Andrew(
                    "Michael",
                    "michael21@gmail.com",
                    LocalDate.of(2000, Month.NOVEMBER, 25),
                    18
            );

                repository.saveAll(
                        List.of(andrew,friend)
                );
            };
        };
    }