package edu.skidmore.cs326.spring2022.skribbage.logic;
import java.util.ArrayList;
import org.apache.log4j.Logger;

/**
Game class has a deck and a list of players. It initializes the deck and list of players.
This class contains methods for the various phases of the game. However, at the moment,
it contains methods for the deal phase and a few for the pegging phase (this phase
is not complete)
Assumption: there are only two players in the game.
@author Michael Shriner
*/
public class Game{

  /** the deck of cards used to play Cribbage */
  private Deck theDeck;

  /**The list of players who are playing this game of Cribbage */
  private ArrayList <Player> playerList = new ArrayList <Player> ();

  /**The total score among the players during the pegging phase of the game ( 0 <= peggingTotal <= 31)*/
  private int peggingTotal;

  /** the crib for the game */
  private ArrayList<Card> crib = new ArrayList <Card> ();

  private ArrayList<Card> peggingCards = new ArrayList <Card>();

  /**
  Constructor creates a Game, initializes the deck, and initializes the list of players
  for this game.
  @param numPlayers is the number of players
  */
  public Game(int numPlayers){
    //initialize theDeck
    this.theDeck = new Deck();

    //initialize list of players, given numPlayers
    initPlayers(numPlayers);
  }

  /**
  Initializes the ArrayList of Player objects given the number of players for this game.
  @param numPlayers is the number of players
  */
  private void initPlayers(int numPlayers){

    for (int i = 0; i < numPlayers; i++){
      Player p = new Player();
      playerList.add(p);
    }

  }//end of initPlayers


  /**
  This method executes the dealing phase of the game. A dealer is determined,
  cards are dealt, and cards are discarded to the crib.
  */
  private void dealPhase(){

    theDeck.shuffle();

    //select the dealer

    //FRONT END INTERACTION
    //for now, assume you got information from front end
    //the information you need is the amount of cards to cut from the deck
    //also assume there are two players

    int amountToCutP1 = 8;
    int amountToCutP2 = 8;

    if (toCutP1 < 4 || toCutP1 > 26){
      //invalid number of cards to cut
      //send that information to front end
      //for now, print to console
      System.out.println("The amount of cards to cut must be at least 4 and less than 26 for the first cut.");
    }

    if (toCutP2 < 4 || toCutP2 > 22){
      //invalid number of cards to cut
      //send information to front end
      //for now, print to console
      System.out.println("The amount of cards to cut must be at least 4 and less than 22 for the second cut.");
    }


    determineDealer(toCutP1, toCutP2);

    theDeck.shuffle();

    dealCards();

    //FRONT END INTERACTION
    //assume you got the information from front end
    Card [] toDiscardP1 ={new Card (Suit.DIAMONDS , "10"), new Card(Suit.HEARTS,"8")};
    Card [] toDiscardP2 = {new Card(Suit.DIAMONDS, "4"), new Card(Suit.DIAMONDS , "7")};

    discardToCrib(toDiscardP1, toDiscardP2);

    //flip top card
    //FRONT END INTERACTION to cut cut amount
    //assume we have that information

    int amountToCut = 6;

    Card topCard = theDeck.moveToTop(amountToCut);

    //FRONT END INTERACTION: give information about the card on top of the deck

  }

  /**
  Given the assumption that there are only two players for now, this method
  discards two cards to the crib for each player.
  @param toDiscardP1 the array of cards to discard for player 1
  @param toDiscardP2 the array of cards to discard for player 2
  */
  private void discardToCrib(Card [] toDiscardP1, Card [] toDiscardP2){

    for (int i = 0; i < toDiscardP1.length; i++){
      //search the player's hand for the card to discard and remove it from the hand
      playerList.get(0).removeCardFromHand(toDiscardP1[i], playerList.get(0));

      //add the card to the crib
      crib.add(toDiscardP1[i]);
    }

    for (int j = 0; j < toDiscardP2.length; j++){
      //search the player's hand for the card and remove it
      playerList.get(1).removeCardFromHand(toDiscardP2[j], playerList.get(1));

      //add the card to the crib
      crib.add(toDiscardP2[j]);

    }

  }


  /**
  Searches for a given card in a specified player's hand and removes it.
  @param cardToRemove is the card to remove from the player's hand
  @param p is the player
  */
  private void removeCardFromHand(Card cardToRemove, Player p){

    ArrayList <Card> theHand = p.getHand();

    for(int i = 0; i < theHand.size(); i++){
      Card c = theHand.get(i);

      // if (c.getSuit() == cardToRemove.getSuit() && Character.compare(c.getCardIdentifier(), cardToRemove.getCardIdentifier())){
      //   theHand.remove(i);
      //   return;
      // }

      if (c.getSuit() == cardToRemove.getSuit() && c.getCardIdentifier() == cardToRemove.getCardIdentifier()){
        theHand.remove(i);
        return;
      }

    }
  }

  /**
  Deal cards to the players, assuming that there are two players.
  Each player will be dealt 6 cards.
  */
  private void dealCards(){

    int idxOfDealer = getDealerIdx();//the index in playerList that contains the dealer

    ArrayList <Card> dealerHand = new ArrayList <Card> ();
    ArrayList <Card> poneHand = new ArrayList <Card> ();

    for (int i = 0; i < 6; i++){
      poneHand.add(theDeck.removeTopCard());
      dealerHand.add(theDeck.removeTopCard());
    }

    playerList.get(idxOfDealer).setHand(dealerHand);

    if (idxOfDealer == 1){
      playerList.get(0).setHand(poneHand);
    }
    else{
      playerList.get(1).setHand(poneHand);
    }

  }


  /**
  Shuffles the deck, cuts the deck, and determines the dealer.
  @param amountToCutP1 is the amount that player 1 wants to cut
  @param amountToCutP2 is the amount that player 2 wants to cut
  */
  private void determineDealer(int amountToCutP1, int amountToCutP2){

    theDeck.shuffle();

    Card cardP1 = theDeck.cut(amountToCutP1);
    Card cardP2 = theDeck.cut(amountToCutP2);

    //assumption: player 2 is at index 1
    //assumption: player 1 is at index 0

    if (cardP1 < cardP2){
      playerList.get(0).isDealer = true;
    }
    else if (cardP2 < cardP1){
      playerList.get(1).isDealer = true;
    }
    else{
      //reshuffle and cut again because the bottom cards were the same
      determineDealer(amountToCutP1, amountToCutP2);
    }
  }

  //gets the index in playerList where the dealer is
  /**
  Returns the index in playerList where the dealer is or -1.
  @return the index in playerList where the dealer is or -1 if there is no dealer.
  */
  private int getDealerIdx(){
    for (int i = 0; i < playerList.size(); i++){
      if (playerList.get(i).isDealer){
        return i;
      }
    }
    return -1;
  }


  //write method for count hand phase

  //write methods for pegging play

  /**
  Takes a card and adds the card's point value to the total value during pegging play
  unless 31 < peggingTotal + the value of the card to add
  @param cardToAdd is the card whose point value will be added to the total if it meets the condition
  */
  private void addCardToPeggingTotal(Card cardToAdd){

    int theCardValue = cardToAdd.getPointValue();

    if (peggingTotal + theCardValue > 31){
      //indicate to the user that the card cannot be played
      //FRONT END INTERACTION HERE
      //for now, print to the console
      System.out.println("cannot add card to pegging total because the total cannot exceed 31");
    }
    else{
      //if here, the card does not bring the total to over 31
      peggingTotal += theCardValue;

      //remove the card from the player's hand?
    }

  }


  private void peggingPhase (){

    ArrayList<Card> ponePeggingCards = new ArrayList <Card>();
    ArrayList<Card> dealerPeggingCards = new ArrayList <Card>();

    //FRONT END INTERACTION NEEDED
    //assume you have information from front end

    //do the following steps while there is at least one card left in one of the player's hands

    //1) pone places a card
    //2) add the card to the total value if possible
    //3) add the card to peggingCards if possible
    //4) add the card to ponePeggingCards if possible
    //5) if the pone makes a claim for pegging points for that card and that card could be placed,
    //check that claim

    //4) dealer places a card
    //5) add the card to the total value if possible
    //6) add the card to peggingCards if possible
    //7) add the card to dealerPeggingCards if possible
    //8) add the card to the total value if possible
    //9) if the dealer makes a claim for pegging points for that card and that card could be placed,
    //check that claim

    //if the last card was played and all points were added, the pegging phase is over
    //reset peggingCards and add ponePeggingCards and dealerPeggingCards back to each player's hand

  }

  private void checkClaim (Card c, String claim, Player p){
    //claims include:
    //1) "15"
    //2) "31"
    //3) "pair"
    //4) "3 pair"
    //5) "4 pair"
    //6) "run of 3"
    //7) "run of 4"
    //8) "run of 5"
    //9) "run of 6"
    //10) "run of 7"
    //11) "go"
    //12) "last card"

    if (claim.equalsIgnoreCase("15")){
      check15(p);
    }
    else if (claim.equalsIgnoreCase("31")){
      check31(p);
    }
    else if (claim.equalsIgnoreCase("pair")){
      checkPair(p);
    }
    else if (claim.equalsIgnoreCase("3 pair")){
      check3Pair(p);
    }
    else if(claim.equalsIgnoreCase("4 pair")){
      check4Pair(p);
    }
    else if(claim.equalsIgnoreCase("run of 3")){
      checkRunOf3(p);
    }
    else if (claim.equalsIgnoreCase("run of 4")){
      checkRunOf4(p);
    }
  }

  private void check15(Player p){

    //assumption: Card c from checkClaim() has been added to peggingCards already
    //assumption: check15() is called before the dealer plays a card

    int sum = 0;

    for (int i = 0; i < peggingCards.size(); i++){
      Card tempCard = peggingCards.get(i);
      sum += tempCard.getPointValue();
    }

    if (sum == 15){
      //award points to player
      //player p gets 2 points
    }
    else{
      //FRONT END
      //indicate to the player that the claim was not valid
    }
  }

  private void check31(Player p){

    //assumption: Card c from checkClaim() has been added to peggingCards already
    //assumption: check15() is called before the dealer plays a card

    int sum = 0;

    for (int i = 0; i < peggingCards.size(); i++){
      Card tempCard = peggingCards.get(i);
      sum += tempCard.getPointValue();
    }

    if (sum == 31){
      //award points to player
      //player p gets 2 points
    }
    else{
      //FRONT END
      //indicate to the player that the claim was not valid
    }
  }

  private void checkPair(Player p){
    //assumption: Card c from checkClaim() has been added to peggingCards already
    //assumption: check15() is called before the dealer plays a card

    Card precedingCard = peggingCards.get(peggingCards.size() - 2);
    Card mostRecentCard = peggingCards.get(peggingCards.size() - 1);

    if (Character.compare(precedingCard.getCardIdentifier(), mostRecentCard.getCardIdentifier())){
      //we have a pair
      //player p gets 2 points
    }
    else{
      //indicate to front end that the claim was not valid
    }
  }

  private void check3Pair(Player p){
    //assumption: Card c from checkClaim() has been added to peggingCards already
    //assumption: check15() is called before the dealer plays a card

    Card firstInPair = peggingCards.get(peggingCards.size() - 3);
    Card secondInPair = peggingCards.get(peggingCards.size() - 2);
    Card lastInPair = peggingCards.get(peggingCards.size() - 1);

    if (Character.compare(firstInPair.getCardIdentifier(), secondInPair.getCardIdentifier())){
      if (Character.compare(secondInPair.getCardIdentifier(), lastInPair.getCardIdentifier())){
        //player p gets 6 points
      }
    }
    else{
      //indicate to front end that the claim was not valid
    }
  }

  private void check4Pair(Player p){
    //assumption: Card c from checkClaim() has been added to peggingCards already
    //assumption: check15() is called before the dealer plays a card

    Card firstInPair = peggingCards.get(peggingCards.size() - 3);
    Card secondInPair = peggingCards.get(peggingCards.size() - 2);
    Card lastInPair = peggingCards.get(peggingCards.size() - 1);

    if (Character.compare(firstInPair.getCardIdentifier(), secondInPair.getCardIdentifier())){
      if (Character.compare(secondInPair.getCardIdentifier(), lastInPair.getCardIdentifier())){
        //player p gets 6 points
      }
    }
    else{
      //indicate to front end that the claim was not valid
    }
  }


  private void checkRunOf3 (Player p){

    if (peggingCards.size() < 3){
      //let front end know that there isn't a run of three
      return;
    }
    //note, they do not have to be played in sequential order
    //if the order is 5,3,4, there is a run of three
    Card firstInRun = peggingCards.get(peggingCards.size() - 3);
    Card secondInRun = peggingCards.get(peggingCards.size() - 2);
    Card thirdInRun = peggingCards.get(peggingCards.size() - 1);

    char firstCardId = firstInRun.getCardIdentifier();
    char secondCardId = secondInRun.getCardIdentifier();
    char thirdCardId = thirdInRun.getCardIdentifier();

    //make sure there are no cards with the same identifiers
    if (firstCardId == secondCardId || firstCardId == thirdCardId){
      //send information to front end that there isn't a run of 3
      return;
    }

    if (secondCardId == thirdCardId){
      //send information to front end that there isn't a run of 3
      return;
    }

    //once here, we know that none of the cards have the same identifier

    //get the next identifier for each card
    char firstInRunNextId = firstInRun.getNextIdentifier();
    char secondInRunNextId = secondInRun.getNextIdentifier();
    char thirdInRunNextId = thirdInRun.getNextIdentifier();

    //two of the three next identifiers must be equal to exactly one of the
    //identifiers of the other cards

    int numEqual = 0;

    //check the first next identifier
    if (firstInRunNextId == secondCardId || firstInRunNextId == thirdCardId){
      numEqual++;

    }

    if (secondInRunNextId == firstCardId || secondInRunNextId == thirdCardId){
      numEqual++;
    }

    if (thirdInRunNextId == firstCardId || thirdInRunNextId == secondCardId){
      numEqual++;
    }

    if (numEqual == 2){
      //we have a run of 3
      //give the points to player p

    }
    else{
      //we don't have a run of 3
      //notify front end
    }

  }

  private void checkRunOf4 (Player p){

    if (peggingCards.size() < 4){
      //let front end know that run of 4 isn't valid
      return;
    }

    //note, they do not have to be played in sequential order
    //if the order is 5,3,4, there is a run of three
    Card firstInRun = peggingCards.get(peggingCards.size() - 4);
    Card secondInRun = peggingCards.get(peggingCards.size() - 3);
    Card thirdInRun = peggingCards.get(peggingCards.size() - 2);
    Card fourthInRun = peggingCards.get(peggingCards.size() - 1);

    char firstCardId = firstInRun.getCardIdentifier();
    char secondCardId = secondInRun.getCardIdentifier();
    char thirdCardId = thirdInRun.getCardIdentifier();
    char fourthCardId = fourthInRun.getCardIdentifier();

    //make sure there are no cards with the same identifiers
    if (firstCardId == secondCardId || firstCardId == thirdCardId || firstCardId == fourthCardId){
      //send information to front end that there isn't a run of 4
      return;
    }

    if (secondCardId == thirdCardId || secondCardId == fourthCardId){
      //send information to front end that there isn't a run of 4
      return;
    }

    if (thirdCardId == fourthCardId){
      //send information to front end that there isn't a run of 4
      return;
    }

    //once here, we know that none of the cards have the same identifier

    //get the next identifier for each card
    char firstInRunNextId = firstInRun.getNextIdentifier();
    char secondInRunNextId = secondInRun.getNextIdentifier();
    char thirdInRunNextId = thirdInRun.getNextIdentifier();
    char fourthInRunNextId = fourthInRun.getNextIdentifier();

    //3 of the 4 next identifiers must be equal to exactly one of the
    //identifiers of the other cards

    int numEqual = 0;

    //check the first next identifier
    if (firstInRunNextId == secondCardId || firstInRunNextId == thirdCardId || firstInRunNextId == fourthCardId){
      numEqual++;
    }

    if (secondInRunNextId == firstCardId || secondInRunNextId == thirdCardId || secondInRunNextId == fourthCardId){
      numEqual++;
    }

    if (thirdInRunNextId == firstCardId || thirdInRunNextId == secondCardId || thirdInRunNextId == fourthCardId){
      numEqual++;
    }

    if (fourthInRunNextId == firstCardId || fourthInRunNextId == secondCardId || fourthInRunNextId == thirdCardId){
      numEqual++;
    }

    if (numEqual == 3){
      //we have a run of 4
      //give the points to player p

    }
    else{
      //we don't have a run of 4
      //notify front end
    }

  }




  //to check a claim for points, we would need a record of which cards had been placed
  //we can keep this record with an ArrayList in the class

  //when a player places a card down successfully, it should be temporarily moved from the
  //player's hand
  //it should be removed and placed in another array and placed back into the player's hand at the end of the
  //pegging phase

  //ways to score in pegging play
  //if a player places a card that brings the total to 15 or 31, then the player gets 2 points
  //if a player places a card that immediately follows a card with the same numerical value, the player gets 2 points
  //if a player places a card that immediately follows two cards with the same numerical values, the player gets 6 points
  //if a player places a card that immediately follows three cards with the same numerical values, the player gets 12 points
  //if a player has a run of 3, then the player gets 3 points
  //if a player has a run of 4, then the player gets 4 points
  //if a player has a run of 5,6, or 7, then the player gets 5, 6, or 7 respectively
  //if a player creates a go, then they get 1 point
  //if a player has the last card, they get 1 point

  //pegging phase:
  //pone places a card down first
  //points are pegged when received






}
