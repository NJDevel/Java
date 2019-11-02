package com.example.AbrahamLealU1Capstone.dao;

import com.example.AbrahamLealU1Capstone.model.Game;

import java.util.List;

public interface GameDao {

    Game addGame(Game game);

    Game getGame(int id);

    List<Game> getAllGames();

    void updateGame(Game game);

    void deleteGame(int id);

    List<Game> searchGameByStudio(String studio);

    List<Game> searchGameByRating(String esrbRating);

    List<Game> searchGameByTitle(String title);

    int getInventoryQuantity(int id);
}
