package com.monopoly.gameapi.controller;

import com.monopoly.gameapi.model.Card;
import com.monopoly.gameapi.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CardController {

    @Autowired
    CardService cardService;

    @GetMapping("/cards")
    public @ResponseBody
    List<Card> getAllCard() {
        return cardService.getAllCard();
    }

    @PostMapping("/card")
    public List<Card> creatCards(@RequestParam Long createdBy, @RequestBody List<Card> cards) {
        return cardService.creatCards(cards, createdBy);
    }

    @PutMapping("/card")
    public Card updateCard(@RequestBody Card card) {
        return cardService.updateCard(card);
    }

    @DeleteMapping("/card/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        return cardService.deleteCard(id);
    }
}
