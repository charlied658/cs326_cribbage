// package edu.skidmore.cs326.spring2022.skribbage.logic;
//
// import edu.skidmore.cs326.spring2022.skribbage.logic.Card;
// import edu.skidmore.cs326.spring2022.skribbage.logic.Suit;
// import edu.skidmore.cs326.spring2022.skribbage.logic.Game;
// import edu.skidmore.cs326.spring2022.skribbage.logic.Hand;
// import edu.skidmore.cs326.spring2022.skribbage.logic.Player;
//
// import java.util.ArrayList;
//
// public class Prototype {
//
// Game myGame = new Game(2); // Begins a new game with 2 new players
// ArrayList<Player> tempPlayerList = myGame.getPlayerList();
//
// myGame.getDeck().shuffle();
//
// //Each player cuts a card
// //Player 1 (John) cuts the deck first by 15
// Card firstDealerDeterminedCard = myGame.getDeck().cut(15);
// //Player 2 (Billy) cuts the deck by 23
// Card secondDealerDeterminedCard = myGame.getDeck().cut(23);
// //Compare cards, the lower card is dealer
// if (firstDealerDeterminedCard.getPointValue() <
// secondDealerDeterminedCard.getPointValue() ){
// //John is dealer
// int dealerIndex = 0;
// int nonDealerIndex = 1;
// }//end if
// else{
// //Billy is dealer
// int dealer Index = 1;
// int nonDealerIndex = 0;
// }//end else
//
// //Deal 6 number of cards
// //Deal to non dealer first
// for (int i = 0; i <= 6; i++){
// tempPlayerList.get(nonDealerIndex).getHand().addCardToHand(myGame.getDeck().
// removeTopCard());
// }//end for statement
//
// //Deal to Dealer
// for (int i = 0; i <= 6; i++){
// tempPlayerList.get(dealerIndex).getHand().addCardToHand(myGame
// .getDeck().removeTopCard());
// }//end for statement
//
// //Each player gives 2 cards to the crib
// myGame.getCrib().add(tempPlayerList.get(nonDealerIndex).getHand().get(0));
// myGame.getCrib().add(tempPlayerList.get(nonDealerIndex).getHand().get(1));
// myGame.getCrib().add(tempPlayerList.get(dealerIndex).getHand().get(0));
// myGame.getCrib().add(tempPlayerList.get(dealerIndex).getHand().get(1));
//
// //Get starter card
// //nondealer cuts the deck
// Card starterCard = myGame.getDeck().moveToTop(19);
// //if jack, dealer gets 2 points
// if (starterCard.getIdentifier() == 'J' ){
// tempPlayerList.get(dealerIndex).addPoints(2);
// }//end if statement
//
// //Play cards until 31
//
//
//
// } //end class Prototype
