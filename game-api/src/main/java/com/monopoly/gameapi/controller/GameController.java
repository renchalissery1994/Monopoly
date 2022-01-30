package com.monopoly.gameapi.controller;

import com.monopoly.gameapi.model.Game;
import com.monopoly.gameapi.model.Move;
import com.monopoly.gameapi.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class GameController {

    @Autowired
    GameService gameService;

    @GetMapping("/game/{id}")
    public @ResponseBody
    Game getGame(@PathVariable("id") Long id) {
        Game game = gameService.getGame(id);
        return game;
    }

    @GetMapping("/games")
    public @ResponseBody
    List<Game> getAllGames() {
        return gameService.getAllGames();
    }

    @PutMapping("/game")
    public @ResponseBody
    Game createOrSaveGame(@RequestBody Game game) {
        return gameService.createOrSaveGame(game);
    }

    @PostMapping("/move")
    public ResponseEntity<Object> submitMove(@RequestBody Move move) throws ResponseStatusException {
        try {
            return new ResponseEntity<>(gameService.submitMove(move), new HttpHeaders(), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/move-revert")
    public Move submitMoveRevert(@RequestBody Move move) {
        return gameService.submitMoveRevert(move);
    }
}
