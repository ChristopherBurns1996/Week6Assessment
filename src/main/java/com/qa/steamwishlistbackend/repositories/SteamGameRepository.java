package com.qa.steamwishlistbackend.repositories;

import com.qa.steamwishlistbackend.entities.SteamGame;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SteamGameRepository extends CrudRepository<SteamGame, Integer> {
    Optional<SteamGame> findByName(String name);
}
