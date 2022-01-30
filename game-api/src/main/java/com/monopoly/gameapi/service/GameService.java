package com.monopoly.gameapi.service;

import com.monopoly.gameapi.model.Card;
import com.monopoly.gameapi.model.Game;
import com.monopoly.gameapi.model.Move;
import com.monopoly.gameapi.model.User;
import com.monopoly.gameapi.repository.GameRepository;
import com.monopoly.gameapi.repository.MoveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    private static final int CREATE_GAME = -2;
    private static final int WAITING_FOR_PLAYERS = -1;
    private static final int START_GAME = 0;
    private static final int END_GAME = -3;

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    GameRepository gameRepository;

    @Autowired
    MoveRepository moveRepository;

    @Autowired
    UserService userService;

    @Autowired
    CardService cardService;

    @Transactional
    public Game getGame(Long id) {
        return gameRepository.findById(id).get();
    }

    @Transactional
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    @Transactional
    public Game createOrSaveGame(Game gameRequest) {
        entityManager.detach(gameRequest);
        Game game = null;
        switch (gameRequest.getStateNumber()) {
            case CREATE_GAME:
                // Create game
                game = new Game();
                game.setGameName(gameRequest.getGameName());
                game.setStateNumber(gameRequest.getStateNumber());
                break;
            case WAITING_FOR_PLAYERS:
                game = getGame(gameRequest.getId());
                game.setStateNumber(gameRequest.getStateNumber());
                // Update players
                if (gameRequest.getPlayerOne() != null)
                    game.setPlayerOne(gameRequest.getPlayerOne());
                if (gameRequest.getPlayerTwo() != null)
                    game.setPlayerTwo(gameRequest.getPlayerTwo());
                if (gameRequest.getPlayerThree() != null)
                    game.setPlayerThree(gameRequest.getPlayerThree());
                if (gameRequest.getPlayerFour() != null)
                    game.setPlayerFour(gameRequest.getPlayerFour());
                if (gameRequest.getPlayerFive() != null)
                    game.setPlayerFive(gameRequest.getPlayerFive());
                if (gameRequest.getPlayerSix() != null)
                    game.setPlayerSix(gameRequest.getPlayerSix());
                if (gameRequest.getPlayerSeven() != null)
                    game.setPlayerSeven(gameRequest.getPlayerSeven());
                if (gameRequest.getPlayerEight() != null)
                    game.setPlayerEight(gameRequest.getPlayerEight());
                break;
            case START_GAME:
                game = getGame(gameRequest.getId());
                game.setStateNumber(gameRequest.getStateNumber());
                // Select the first player and start
                if (game.getPlayerOne() != null)
                    game.setCurrentPlayer(userService.getUser(game.getPlayerOne()));
                else if (game.getPlayerTwo() != null)
                    game.setCurrentPlayer(userService.getUser(game.getPlayerTwo()));
                else if (game.getPlayerThree() != null)
                    game.setCurrentPlayer(userService.getUser(game.getPlayerThree()));
                else if (game.getPlayerFour() != null)
                    game.setCurrentPlayer(userService.getUser(game.getPlayerFour()));
                else if (game.getPlayerFive() != null)
                    game.setCurrentPlayer(userService.getUser(game.getPlayerFive()));
                else if (game.getPlayerSix() != null)
                    game.setCurrentPlayer(userService.getUser(game.getPlayerSix()));
                else if (game.getPlayerSeven() != null)
                    game.setCurrentPlayer(userService.getUser(game.getPlayerSeven()));
                else if (game.getPlayerEight() != null)
                    game.setCurrentPlayer(userService.getUser(game.getPlayerEight()));
                game.setStartDate(OffsetDateTime.now());
                break;
            case END_GAME:
                game = getGame(gameRequest.getId());
                game.setStateNumber(gameRequest.getStateNumber());
                game.setEndDate(OffsetDateTime.now());
            default:
                // Create game

                break;
        }
        return gameRepository.save(game);
    }


    @Transactional
    public Move submitMove(Move move) throws Exception {
        Game game = getGame(move.getGame().getId());
        // Validate Game Start
        if (game.getStartDate() == null || game.getStateNumber() == WAITING_FOR_PLAYERS || game.getStateNumber() == CREATE_GAME) {
            throw new Exception("Please start the game");
        }
        // Validate Game End
        if (game.getEndDate() != null || game.getStateNumber() == END_GAME) {
            throw new Exception("Game already ended. " + game.getCurrentPlayer().getFirstName() + " " + game.getCurrentPlayer().getLastName() + " won the game.");
        }
        // Validate current player
        if (!game.getCurrentPlayer().getId().equals(move.getUser().getId())) {
            throw new Exception("Please ask " + game.getCurrentPlayer().getFirstName() + " " + game.getCurrentPlayer().getLastName() + " to play");
        }
        User user = userService.getUser(move.getUser().getId());
        Card card = cardService.getAllCard().stream().filter(c -> c.getId().equals(move.getCard().getId())).collect(Collectors.toList()).get(0);
        User userAffected = null;
        Card cardAffected = null;
        if (move.getUserAffected() != null) {
            userAffected = userService.getUser(move.getUserAffected());
            move.setUserAffected(userAffected.getId());
        }
        if (move.getCardAffected() != null) {
            cardAffected = cardService.getAllCard().stream().filter(c -> c.getId().equals(move.getCardAffected())).collect(Collectors.toList()).get(0);
            move.setCardAffected(cardAffected.getId());
        }
        move.setGame(game);
        move.setCard(card);
        move.setUser(user);
        move.setPlayedAt(OffsetDateTime.now());
        moveRepository.save(move);
        // TODO Evaluate player card
        
        // TODO Update the current player to the next player

        return move;
    }

    @Transactional
    public Move submitMoveRevert(Move move) {
        // To be implemented in the future
        return null;
    }
}
