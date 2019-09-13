package com.qa.steamwishlistbackend.controllers;

import com.qa.steamwishlistbackend.entities.SteamGame;
import com.qa.steamwishlistbackend.repositories.SteamGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class SteamController {
    SteamGameRepository steamGameRepository;

    @PostMapping("/create/game")
    public SteamGame addGame(@RequestBody SteamGame game){
        return steamGameRepository.save(game);
    }

    @GetMapping("/read/all")
    public List<SteamGame> readAll() {
        List<SteamGame> games = new ArrayList<>();
        steamGameRepository.findAll().forEach(games::add);
        return games;
    }

    @DeleteMapping("delete/{name}")
    public SteamGame deleteGame(@PathVariable String name) {
        SteamGame gameToDelete = steamGameRepository.findByName(name).get();
        steamGameRepository.delete(gameToDelete);
        return gameToDelete;
    }

    @PostMapping("/update/cost")
    public SteamGame readAll(@RequestBody SteamGame game) {
        SteamGame savedGame = steamGameRepository.findByName(game.getName()).get();
        savedGame.setCost(game.getCost());
        steamGameRepository.save(savedGame);
        return savedGame;
    }


    @Autowired
    void getSteamGameRepository(SteamGameRepository steamGameRepository) {
        this.steamGameRepository = steamGameRepository;
    }
}
