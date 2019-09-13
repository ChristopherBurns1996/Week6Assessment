package com.qa.steamwishlistbackend.controllers;

import com.qa.steamwishlistbackend.entities.SteamGame;
import com.qa.steamwishlistbackend.repositories.SteamGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class SteamController {
    SteamGameRepository steamGameRepository;

    @GetMapping("/read/all")
    public String readAll() {
        return "";
    }




    @PostMapping("/update/cost")
    public String readAll(@RequestBody SteamGame game) {
        steamGameRepository.save(steamGameRepository.findByName(game.getName()).get());
        return "done";
    }


    @Autowired
    void getSteamGameRepository(SteamGameRepository steamGameRepository) {
        this.steamGameRepository = steamGameRepository;
    }
}
