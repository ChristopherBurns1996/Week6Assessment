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



    @Autowired
    void getSteamGameRepository(SteamGameRepository steamGameRepository) {
        this.steamGameRepository = steamGameRepository;
    }

    @RequestMapping(value = "/create/game", method = RequestMethod.POST)
    public SteamGame addGame(@RequestBody SteamGame game){
        return steamGameRepository.save(game);
    }
}
