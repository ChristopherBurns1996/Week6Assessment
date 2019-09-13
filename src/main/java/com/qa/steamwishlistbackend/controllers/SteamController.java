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

    @RequestMapping(value = "delete/{name}", method = RequestMethod.DELETE)
    public String deleteGame(@PathVariable String name) {
        SteamGame gameToDelete = steamGameRepository.findByName(name).get();
        steamGameRepository.delete(gameToDelete);
        return "Deleted: " + gameToDelete;
    }

    @PostMapping("/update/cost")
    public String readAll(@RequestBody SteamGame game) {
        return "done";
    }


    @Autowired
    void getSteamGameRepository(SteamGameRepository steamGameRepository) {
        this.steamGameRepository = steamGameRepository;
    }
}
