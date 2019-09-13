package com.qa.steamwishlistbackend.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class SteamGame {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY) private int id;
    @NotBlank private String name;
    private int cost;

    public SteamGame() {}
    public SteamGame(String name, int cost) {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }
}
