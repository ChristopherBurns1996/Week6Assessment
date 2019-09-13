package com.qa.steamwishlistbackend.repositories;

import com.qa.steamwishlistbackend.entities.SteamGame;
import org.springframework.data.repository.CrudRepository;

public interface SteamGameRepository extends CrudRepository<SteamGame, Integer> {
}
