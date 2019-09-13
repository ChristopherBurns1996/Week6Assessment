package com.qa.steamwishlistbackend;


import com.qa.steamwishlistbackend.controllers.SteamController;
import com.qa.steamwishlistbackend.entities.SteamGame;
import com.qa.steamwishlistbackend.repositories.SteamGameRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CreateFunctionalityTest {

    @InjectMocks
    private SteamController steamController;

    @Mock
    private SteamGameRepository steamGameRepository;

    @Test
    public void addGameTest(){
        SteamGame steamGame = new SteamGame();
        steamGame.setName("Halo 3");
        steamGame.setCost(30);
        when(steamGameRepository.save(steamGame)).thenReturn(steamGame);

        assertEquals(steamController.addGame(steamGame).getName(), "Halo 3");
    }

    @Test
    public void readAllTest(){
        List<SteamGame> gameList = new ArrayList<>();
        SteamGame game = new SteamGame();
        game.setName("cod");
        game.setCost(50);
        gameList.add(game);
        when(steamGameRepository.findAll()).thenReturn(gameList);

        assertEquals(steamController.readAll().get(0).getName(), "cod");
    }

}
