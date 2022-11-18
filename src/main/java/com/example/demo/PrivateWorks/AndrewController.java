package com.example.demo.PrivateWorks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="api/v1/Andrew")
public class AndrewController {

    private final AndrewService andrewService;

   @Autowired
    public AndrewController(AndrewService andrewService) {
        this.andrewService = andrewService;
    }

    @GetMapping
    public List<Andrew> getAndrew() {
        return andrewService.getAndrew();
    }
    @PostMapping
    public void registerNewFriend(@RequestBody Andrew andrew) {
       andrewService.addNewFriend(andrew);
    }
    @DeleteMapping(path = "{andrewId}")
    public void deleteAndrew(@PathVariable("andrewId") Long andrewId) {
       andrewService.deleteAndrew(andrewId);
    }
}
