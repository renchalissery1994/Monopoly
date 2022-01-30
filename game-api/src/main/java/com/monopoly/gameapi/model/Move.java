package com.monopoly.gameapi.model;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "MOVE")
public class Move {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MOVE_ID", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CARD_ID", nullable = false)
    private Card card;

    @Column(name = "CARD_AFFECTED_ID")
    private Long cardAffected;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    @Column(name = "USER_AFFECTED_ID")
    private Long userAffected;

    @Column(name = "PLAYED_AT", nullable = false)
    private OffsetDateTime playedAt;

    @ManyToOne
    @JoinColumn(name = "GAME_ID", nullable = false)
    private Game game;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Long getCardAffected() {
        return cardAffected;
    }

    public void setCardAffected(Long cardAffected) {
        this.cardAffected = cardAffected;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getUserAffected() {
        return userAffected;
    }

    public void setUserAffected(Long userAffected) {
        this.userAffected = userAffected;
    }

    public OffsetDateTime getPlayedAt() {
        return playedAt;
    }

    public void setPlayedAt(OffsetDateTime playedAt) {
        this.playedAt = playedAt;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
