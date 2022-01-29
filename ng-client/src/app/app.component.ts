import { Component } from '@angular/core';
import * as cards from './cards.json';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  allCards: any[] = [];
  myCards: any[] = [];
  myCardWidth:number;
  myCardHeight:number;

  players:any[] = [];
  playerWidth:number;
  playerHeight:number;

  constructor() {
    // Set players
    this.players = ['1', '2', '3'];
    
    // Allocate cards
    this.allCards = JSON.parse(JSON.stringify(cards));
    for (let i = 0; i < this.allCards.length; i++) {
      if (this.allCards[i].id % 2 == 0) this.myCards.push(this.allCards[i]);
      if(this.myCards.length>=7) break;
    }

    // Set card size
    this.myCardWidth = window.innerWidth / this.myCards.length;
    this.myCardHeight = window.innerHeight / 3;
    this.playerWidth = window.innerWidth / this.players.length;
    this.playerHeight = (window.innerHeight * 1 / 3);
  }

}
