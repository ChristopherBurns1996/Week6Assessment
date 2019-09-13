package com.qa.steamwishlistbackend.controllers;

import com.google.gson.JsonObject;
import com.qa.steamwishlistbackend.entities.SteamGame;
import com.qa.steamwishlistbackend.repositories.SteamGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@CrossOrigin
@RestController
public class SteamController {
    SteamGameRepository steamGameRepository;


    @GetMapping("/read/all")
    public String readAll() {
        JsonObject json = new JsonObject();
        List<SteamGame> games = new ArrayList<>();
        steamGameRepository.findAll().forEach(games::add);
        AtomicInteger i = new AtomicInteger();
        games.forEach(game -> json.add("" + i.getAndIncrement(), game.toJson()));
        return json.toString();
    }

    @RequestMapping(value = "delete/{name}", method = RequestMethod.DELETE)
    public String deleteGame(@PathVariable String name) {
        SteamGame gameToDelete = steamGameRepository.findByName(name).get();
        steamGameRepository.delete(gameToDelete);
        return "Deleted: " + gameToDelete.toJson();
    }

    @PostMapping("/update/cost")
    public String readAll(@RequestBody SteamGame game) {
        SteamGame savedGame = steamGameRepository.findByName(game.getName()).get();
        savedGame.setCost(game.getCost());
        steamGameRepository.save(savedGame);
        return "done";
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
