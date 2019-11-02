package com.example.AbrahamLealU12M3Summative.controllers;

import com.example.AbrahamLealU12M3Summative.model.Game;
import com.example.AbrahamLealU12M3Summative.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GameController {

    @Autowired
    ServiceLayer serviceLayer;

    /**************************************************************
     Game API
     **************************************************************/
    @RequestMapping(value = "/games", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Game createGame(@RequestBody @Valid Game game) {
        game = serviceLayer.saveGame(game);
        return game;
    }

    @RequestMapping(value = "/games", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getAllGames(){
        return serviceLayer.findAllGames();
    }

    @RequestMapping(value = "/games", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateGame(@RequestBody @Valid Game game){
        serviceLayer.updateGame(game);
    }

    @RequestMapping(value = "/games/{gameId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Game getGame(@PathVariable int gameId){
        return serviceLayer.findGame(gameId);
    }

    @RequestMapping(value = "/games/{gameId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable int gameId){
        serviceLayer.deleteGame(gameId);
    }

    @RequestMapping(value = "/gamesByStudio/{studio}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Game> searchGamesByStudio(@PathVariable String studio) {return serviceLayer.findGameByStudio(studio); }

    @RequestMapping(value = "/gamesByRating/{esrbRating}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Game> searchGameByRating(@PathVariable String esrbRating) {return serviceLayer.findGameByRating(esrbRating); }

    @RequestMapping(value = "/gamesByTitle/{title}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Game> searchGamesByTitle(@PathVariable String title) { return serviceLayer.findGameByTitle(title); }

}
