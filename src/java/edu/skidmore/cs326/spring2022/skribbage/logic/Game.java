// /**
// Game class has a deck and a list of players. It initializes the deck and list of players.
// In the future, it may function as a starting point for each phase of the game.
// @author Michael Shriner
// */
// public class Game{
//
//   /** the deck of cards used to play Cribbage */
//   private Deck theDeck;
//
//   /**The list of players who are playing this game of Cribbage */
//   private ArrayList <Player> playerList = new ArrayList <Player> ();
//
//   /**The total score among the players during the pegging phase of the game ( 0 <= peggingTotal <= 31)*/
//   private int peggingTotal;
//
//   /** the crib for the game */
//   private ArrayList<Card> crib = new ArrayList <Card> ();
//
//   /**
//   Constructor creates a Game, initializes the deck, and initializes the list of players
//   for this game.
//   @param numPlayers is the number of players
//   */
//   public Game(int numPlayers){
//     //initialize theDeck
//     this.theDeck = new Deck();
//
//     //initialize list of players, given umPlayers
//     initPlayers(numPlayers);
//
//   }
//
//   /**
//   Initializes the ArrayList of Player objects given the number of players for this game.
//   @param numPlayers is the number of players
//   */
//   private void initPlayers(int numPlayers){
//
//     for (int i = 0; i < numPlayers; i++){
//       Player p = new Player();
//       playerList.add(p);
//     }
//
//   }//end of initPlayers
//
//   /**
//   Takes a card and adds the card's point value to the total value during pegging play
//   unless 31 < peggingTotal + the value of the card to add
//   @param cardToAdd is the card whose point value should be tried to add to the total
//   */
//   private void addCardToPeggingTotal(Card cardToAdd){
//     //get the value of the card
//     int theCardValue = cardToAdd.getPointValue();
//
//     if (peggingTotal + theCardValue > 31){
//       //indicate to the user that the card cannot be played
//     }
//     else{
//       //if here, the card does not bring the total to over 31
//       //add it to the total
//       peggingTotal += theCardValue;
//
//       //remove the card from the player's hand?
//     }
//
//   }//end of addCardToPeggingTotal
//
//
//   /**
//   This method enacts the dealing phase of the game.
//   */
//   private void deal(){
//
//     //shuffle the deck
//     theDeck.shuffle();
//
//     //select the dealer
//     //1) each player cuts the deck
//     //2) the player with the lowest card value on the bottom of the cut is the dealer
//
//     //shuffle the deck again
//     theDeck.shuffle();
//
//     //deal cards
//     //if there are two players, each player gets 6 cards
//     //alternate the deal, starting with the pone
//
//     int idxOfDealer = getDealerIdx();
//
//     if (playerList.size() == 2){
//
//       ArrayList <Card> dealerHand = new ArrayList <Card> ();
//       ArrayList <Card> poneHand = new ArrayList <Card> ();
//
//       for (int i = 0; i < 6; i++){
//         poneHand.add(theDeck.removeTopCard());
//         dealerHand.add(theDeck.removeTopCard());
//       }
//
//       playerList.get(idxOfDealer).setHand(dealerHand);
//
//       if (idxOfDealer == 1){
//         playerList.get(0).setHand(poneHand);
//       }
//       else{
//         playerList.get(1).setHand(poneHand);
//       }
//
//       //discard to crib
//       //when there are two players, each player discards two cards to the crib
//       //I need to figure out how we will get that information, but I am envisoning a method
//       // that takes two cards from the front end from each player and adds them to the crib
//       //(also removing those cards from their hands)
//       //how do we get that information from front end?
//
//     }
//
//     //flip top card
//     //1) the pone cuts the deck
//     //2) the dealer flips the top card on the remaining deck up (call it Card A)
//     //3) the pone places the cut back on the deck
//     //4) the dealer places Card A on top of the deck

      //event lisenter
      //get  event
      //send response event 
//
//   }
//
//   //gets the index in playerList where the dealer is
//   private int getDealerIdx(){
//     for (int i = 0; i < playerList.size(); i++){
//       if (playerList.get(i).isDealer){
//         return i;
//       }
//     }
//     return 0;
//   }
//
//
//   //write method for count hand phase
//
//   //write method for pegging play
//
//
//
// }
