package com.monopoly.gameapi.model;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "CARD")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CARD_ID", nullable = false)
    private Long id;

    @Column(name = "CARD_NAME", nullable = false)
    private String cardName;

    @Column(name = "CARD_CODE", nullable = false)
    private String cardCode;

    @Column(name = "CARD_VALUE", nullable = false)
    private String cardValue;

    @Column(name = "SET_COUNT_A", nullable = false)
    private String setCountA;

    @Column(name = "SET_COUNT_B")
    private String setCountB;

    @Column(name = "CARD_CREATED", nullable = false)
    private OffsetDateTime cardCreated;

    @Column(name = "CARD_UPDATED")
    private OffsetDateTime cardUpdated;

    @ManyToOne
    @JoinColumn(name = "CARD_CREATED_BY")
    private User cardCreatedBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public String getCardValue() {
        return cardValue;
    }

    public void setCardValue(String cardValue) {
        this.cardValue = cardValue;
    }

    public String getSetCountA() {
        return setCountA;
    }

    public void setSetCountA(String setCountA) {
        this.setCountA = setCountA;
    }

    public String getSetCountB() {
        return setCountB;
    }

    public void setSetCountB(String setCountB) {
        this.setCountB = setCountB;
    }

    public OffsetDateTime getCardCreated() {
        return cardCreated;
    }

    public void setCardCreated(OffsetDateTime cardCreated) {
        this.cardCreated = cardCreated;
    }

    public OffsetDateTime getCardUpdated() {
        return cardUpdated;
    }

    public void setCardUpdated(OffsetDateTime cardUpdated) {
        this.cardUpdated = cardUpdated;
    }

    public User getCardCreatedBy() {
        return cardCreatedBy;
    }

    public void setCardCreatedBy(User cardCreatedBy) {
        this.cardCreatedBy = cardCreatedBy;
    }
}
