package com.monopoly.gameapi.service;

import com.monopoly.gameapi.model.Card;
import com.monopoly.gameapi.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CardService {

    @Autowired
    CardRepository cardRepository;

    @Autowired
    UserService userService;

    @Transactional
    public List<Card> getAllCard() {
        return cardRepository.findAll().stream().map(card -> {
            card.getCardCreatedBy().setPassword(null);
            return card;
        }).collect(Collectors.toList());
    }

    @Transactional
    public List<Card> creatCards(List<Card> cards, Long createdBy) {
        cards.forEach(card -> {
            card.setCardCreated(OffsetDateTime.now());
            card.setCardCreatedBy(userService.getUser(createdBy));
        });
        return cardRepository.saveAll(cards);
    }

    @Transactional
    public Card updateCard(Card card) {
        card.setCardUpdated(OffsetDateTime.now());
        return cardRepository.save(card);
    }

    @Transactional
    public String deleteCard(Long id) {
        Optional<Card> card = cardRepository.findById(id);
        String status = null;
        if (card.isPresent()) {
            cardRepository.delete(card.get());
            status = "Success";
        } else {
            status = "Failed";
        }
        return status;
    }
}
