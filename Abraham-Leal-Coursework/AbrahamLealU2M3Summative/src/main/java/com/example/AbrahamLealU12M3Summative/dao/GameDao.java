package com.example.AbrahamLealU12M3Summative.dao;

import com.example.AbrahamLealU12M3Summative.model.Game;

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
