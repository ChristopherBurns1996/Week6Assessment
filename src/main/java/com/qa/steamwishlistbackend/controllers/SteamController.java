package com.qa.steamwishlistbackend.controllers;

import com.qa.steamwishlistbackend.repositories.SteamGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
