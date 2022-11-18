package com.example.demo.PrivateWorks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

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

    public void addNewFriend(Andrew andrew) {
        Optional<Andrew> andrewOptional = andrewRepository.
                findFriendsByEmail(andrew.getEmail());
        if (andrewOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        andrewRepository.save(andrew);
    }
    public void deleteAndrew(Long andrewId) {
        boolean exists = andrewRepository.existsById(andrewId);
        if(!exists) {
            throw new IllegalStateException("friends with id" + andrewId
                    + "does not exists");

        }
        andrewRepository.deleteById(andrewId);
    }
}
