package com.monopoly.gameapi.model;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "GAME")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GAME_ID", nullable = false)
    private Long id;

    @Column(name = "GAME_NAME", nullable = false)
    private String gameName;

    @Column(name = "START_DATE")
    private OffsetDateTime startDate;

    @Column(name = "END_DATE")
    private OffsetDateTime endDate;

    @Column(name = "DATA")
    private String data;

    @Column(name = "STATE_NUMBER")
    private Integer stateNumber;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User currentPlayer;

    @Column(name = "PLAYER_1_ID")
    private Long playerOne;

    @Column(name = "PLAYER_2_ID")
    private Long playerTwo;

    @Column(name = "PLAYER_3_ID")
    private Long playerThree;

    @Column(name = "PLAYER_4_ID")
    private Long playerFour;

    @Column(name = "PLAYER_5_ID")
    private Long playerFive;

    @Column(name = "PLAYER_6_ID")
    private Long playerSix;

    @Column(name = "PLAYER_7_ID")
    private Long playerSeven;

    @Column(name = "PLAYER_8_ID")
    private Long playerEight;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public OffsetDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(OffsetDateTime startDate) {
        this.startDate = startDate;
    }

    public OffsetDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(OffsetDateTime endDate) {
        this.endDate = endDate;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getStateNumber() {
        return stateNumber;
    }

    public void setStateNumber(Integer stateNumber) {
        this.stateNumber = stateNumber;
    }

    public User getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(User currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Long getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(Long playerOne) {
        this.playerOne = playerOne;
    }

    public Long getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(Long playerTwo) {
        this.playerTwo = playerTwo;
    }

    public Long getPlayerThree() {
        return playerThree;
    }

    public void setPlayerThree(Long playerThree) {
        this.playerThree = playerThree;
    }

    public Long getPlayerFour() {
        return playerFour;
    }

    public void setPlayerFour(Long playerFour) {
        this.playerFour = playerFour;
    }

    public Long getPlayerFive() {
        return playerFive;
    }

    public void setPlayerFive(Long playerFive) {
        this.playerFive = playerFive;
    }

    public Long getPlayerSix() {
        return playerSix;
    }

    public void setPlayerSix(Long playerSix) {
        this.playerSix = playerSix;
    }

    public Long getPlayerSeven() {
        return playerSeven;
    }

    public void setPlayerSeven(Long playerSeven) {
        this.playerSeven = playerSeven;
    }

    public Long getPlayerEight() {
        return playerEight;
    }

    public void setPlayerEight(Long playerEight) {
        this.playerEight = playerEight;
    }
}
