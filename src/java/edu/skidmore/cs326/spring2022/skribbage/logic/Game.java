package edu.skidmore.cs326.spring2022.skribbage.logic;
import java.util.ArrayList;
import org.apache.log4j.Logger;

/**
Game has a deck, a list of players, a pegging total, a list of cards in the crib, and
a list of cards placed during pegging play. The constructor initializes the deck, the list of players, and
the pegging total. This class contains methods for the deal phase and the pegging phase, which are not complete.
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
  Constructor creates a Game, initializes the deck, the list of players, and the
  pegging total for this game.
  @param numPlayers is the number of players
  */
  public Game(int numPlayers){
    //initialize theDeck
    this.theDeck = new Deck();

    //initialize list of players, given numPlayers
    initPlayers(numPlayers);

    this.peggingTotal = 0;
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
  Returns the list of players.
  @return an ArrayList of players.
  */
  private ArrayList <Player> getPlayerList (){
    return playerList;
  }

  private ArrayList <Card> getCrib(){
    return crib;
  }


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

    if (amountToCutP1 < 4 || amountToCutP1 > 26){
      //invalid number of cards to cut
      //send that information to front end
      //for now, print to console
      System.out.println("The amount of cards to cut must be at least 4 and less than 26 for the first cut.");
    }

    if (amountToCutP2 < 4 || amountToCutP2 > 22){
      //invalid number of cards to cut
      //send information to front end
      //for now, print to console
      System.out.println("The amount of cards to cut must be at least 4 and less than 22 for the second cut.");
    }


    determineDealer(amountToCutP1, amountToCutP2);

    theDeck.shuffle();

    dealCards();

    //FRONT END INTERACTION
    //assume you got the information from front end
    Card [] toDiscardP1 ={new Card ('0', Suit.DIAMONDS), new Card('8', Suit.HEARTS)};
    Card [] toDiscardP2 = {new Card('4', Suit.DIAMONDS ), new Card('7', Suit.DIAMONDS)};

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

      if (c.getSuit() == cardToRemove.getSuit() && c.getIdentifier() == cardToRemove.getIdentifier()){
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

    Hand dealerHand = new Hand();
    Hand poneHand = new Hand();

    for (int i = 0; i < 6; i++){
      poneHand.addCardToHand(theDeck.removeTopCard());
      dealerHand.addCardToHand(theDeck.removeTopCard());
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

    if (cardP1.getPointValue() < cardP2.getPointValue()){
      playerList.get(0).isDealer = true;
    }
    else if (cardP2.getPointValue() < cardP1.getPointValue()){
      playerList.get(1).isDealer = true;
    }
    else if (cardP2.getPointValue() == 10){
      //ordering is J, Q, K
      //compare based on that ordering
      char p1Id = cardP1.getIdentifier();
      char p2Id = cardP2.getIdentifier();

      if (p1Id == 'J'){
        playerList.get(0).isDealer = true;
      }
      else if (p1Id == 'Q' && p2Id == 'K'){
        playerList.get(0).isDealer = true;
      }
      else if (p2Id == 'J'){
        playerList.get(1).isDealer = true;
      }
      else if (p2Id == 'Q' && p1Id == 'K'){
        playerList.get(1).isDealer = true;
      }
      else{
        determineDealer(amountToCutP1, amountToCutP2);
      }
    }
    else{
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
      if (playerList.get(i).isDealer == true){
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

  /**
  Takes a claim and awards the player who made the claim the points earned for the
  claim made if the claim is valid.
  Claims that can be made:
  "15"
  "31"
  "pair"
  "3 pair"
  "4 pair"
  "run of 3"
  "run of 4"
  "run of 5"
  "run of 6"
  "run of 7"
  "last card"
  "go"
  @param claim is the claim the player makes
  @param p is the player who made the claim
  */
  private void checkClaim (String claim, Player p){

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
    else if (claim.equalsIgnoreCase("run of 5")){
      checkRunOf5(p);
    }
    else if (claim.equalsIgnoreCase("run of 6")){
      checkRunOf6(p);
    }
    else if (claim.equalsIgnoreCase("run of 7")){
      checkRunOf7(p);
    }
  }

  /**
  If the player passed as a parameter placed a card during the pegging phase that
  brought the pegging total to 15, the player is awarded 2 points. Otherwise, the
  player is awarded no points.
  @param p is the player making the claim that he or she placed a card that brought
  the pegging total to 15
  */
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
      p.addPoints(2);
    }
    else{
      //FRONT END
      //indicate to the player that the claim was not valid
    }
  }

  /**
  If the player passed as a parameter placed a card during the pegging phase that
  brought the pegging total to 31, the player is awarded 2 points. Otherwise, the
  player is awarded no points.
  @param p is the player making the claim that he or she placed a card that brought
  the pegging total to 31
  */
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
      p.addPoints(2);
    }
    else{
      //FRONT END
      //indicate to the player that the claim was not valid
    }
  }


  /**
  If the player passed as a parameter placed a card that immediately followed a card with the
  same numerical value, the player is awarded 2 points. Otherwise, the player is awarded no points.
  @param the player who made the claim of having a pair during the pegging phase
  */
  private void checkPair(Player p){
    //assumption: Card c from checkClaim() has been added to peggingCards already
    //assumption: check15() is called before the dealer plays a card

    Card precedingCard = peggingCards.get(peggingCards.size() - 2);
    Card mostRecentCard = peggingCards.get(peggingCards.size() - 1);

    if (precedingCard.getIdentifier() == mostRecentCard.getIdentifier()){
      //we have a pair
      //player p gets 2 points
      p.addPoints(2);
    }
    else{
      //indicate to front end that the claim was not valid
    }
  }

  /**
  If the player passed as a parameter placed a card that immediately followed two cards with the
  same numerical values, the player is awarded 6 points. Otherwise, the player is awarded no points.
  @param the player who made the claim of having a 3 pair during the pegging phase
  */
  private void check3Pair(Player p){
    //assumption: Card c from checkClaim() has been added to peggingCards already
    //assumption: check15() is called before the dealer plays a card

    Card firstInPair = peggingCards.get(peggingCards.size() - 3);
    Card secondInPair = peggingCards.get(peggingCards.size() - 2);
    Card lastInPair = peggingCards.get(peggingCards.size() - 1);

    if (firstInPair.getIdentifier() == secondInPair.getIdentifier()){
      if (secondInPair.getIdentifier() == lastInPair.getIdentifier()){
        //player p gets 6 points
        p.addPoints(6);
      }
    }
    else{
      //indicate to front end that the claim was not valid
    }
  }

  /**
  If the player passed as a parameter placed a card that immediately followed two cards with the
  same numerical values, the player is awarded 6 points. Otherwise, the player is awarded no points.
  @param the player who made the claim of having a 3 pair during the pegging phase
  */
  private void check4Pair(Player p){
    //assumption: Card c from checkClaim() has been added to peggingCards already
    //assumption: check15() is called before the dealer plays a card

    Card firstInPair = peggingCards.get(peggingCards.size() - 3);
    Card secondInPair = peggingCards.get(peggingCards.size() - 2);
    Card lastInPair = peggingCards.get(peggingCards.size() - 1);

    if (firstInPair.getIdentifier() == secondInPair.getIdentifier()){
      if (secondInPair.getIdentifier() == lastInPair.getIdentifier()){
        //player p gets 6 points
        p.addPoints(6);
      }
    }
    else{
      //indicate to front end that the claim was not valid
    }
  }


  /**
  If the player passed as a parameter has a run of 3, the player is awarded 3 points.
  Otherwise, the player isn't awarded any points.
  @param p is the player who claims to have a run of 3
  **/
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

    char firstCardId = firstInRun.getIdentifier();
    char secondCardId = secondInRun.getIdentifier();
    char thirdCardId = thirdInRun.getIdentifier();

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
      p.addPoints(3);

    }
    else{
      //we don't have a run of 3
      //notify front end
    }

  }

  /**
  If the player passed as a parameter has a run of 4, the player is awarded 4 points.
  Otherwise, the player isn't awarded any points.
  @param p is the player who claims to have a run of 4
  **/
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

    char firstCardId = firstInRun.getIdentifier();
    char secondCardId = secondInRun.getIdentifier();
    char thirdCardId = thirdInRun.getIdentifier();
    char fourthCardId = fourthInRun.getIdentifier();

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
      p.addPoints(4);

    }
    else{
      //we don't have a run of 4
      //notify front end
    }

  }

  /**
  If the player passed as a parameter has a run of 5, the player is awarded 5 points.
  Otherwise, the player isn't awarded any points.
  @param p is the player who claims to have a run of 5
  **/
  private void checkRunOf5 (Player p){

    if (peggingCards.size() < 5){
      //let front end know that run of 4 isn't valid
      return;
    }

    //note, they do not have to be played in sequential order

    Card firstInRun = peggingCards.get(peggingCards.size() - 5);
    Card secondInRun = peggingCards.get(peggingCards.size() - 4);
    Card thirdInRun = peggingCards.get(peggingCards.size() - 3);
    Card fourthInRun = peggingCards.get(peggingCards.size() - 2);
    Card fifthInRun = peggingCards.get(peggingCards.size() - 1);


    char firstCardId = firstInRun.getIdentifier();
    char secondCardId = secondInRun.getIdentifier();
    char thirdCardId = thirdInRun.getIdentifier();
    char fourthCardId = fourthInRun.getIdentifier();
    char fifthCardId = fifthInRun.getIdentifier();

    //make sure there are no cards with the same identifiers
    if (firstCardId == secondCardId || firstCardId == thirdCardId || firstCardId == fourthCardId || firstCardId == fifthCardId ){
      //send information to front end that there isn't a run of 4
      return;
    }

    if (secondCardId == thirdCardId || secondCardId == fourthCardId || secondCardId == fifthCardId){
      //send information to front end that there isn't a run of 4
      return;
    }

    if (thirdCardId == fourthCardId || thirdCardId == fifthCardId ){
      //send information to front end that there isn't a run of 4
      return;
    }

    if (fourthCardId == fifthCardId){
      //send information to front end that there isn't a run of 4
      return;
    }


    //once here, we know that none of the cards have the same identifier

    //get the next identifier for each card
    char firstInRunNextId = firstInRun.getNextIdentifier();
    char secondInRunNextId = secondInRun.getNextIdentifier();
    char thirdInRunNextId = thirdInRun.getNextIdentifier();
    char fourthInRunNextId = fourthInRun.getNextIdentifier();
    char fifthInRunNextId = fifthInRun.getNextIdentifier();

    //4 of the 5 next identifiers must be equal to exactly one of the
    //identifiers of the other cards

    int numEqual = 0;

    //check the first next identifier
    if (firstInRunNextId == secondCardId || firstInRunNextId == thirdCardId || firstInRunNextId == fourthCardId || firstInRunNextId == fifthCardId){
      numEqual++;
    }

    if (secondInRunNextId == firstCardId || secondInRunNextId == thirdCardId || secondInRunNextId == fourthCardId || secondInRunNextId == fifthCardId){
      numEqual++;
    }

    if (thirdInRunNextId == firstCardId || thirdInRunNextId == secondCardId || thirdInRunNextId == fourthCardId || thirdInRunNextId == fifthCardId){
      numEqual++;
    }

    if (fourthInRunNextId == firstCardId || fourthInRunNextId == secondCardId || fourthInRunNextId == thirdCardId || fourthInRunNextId == fifthCardId){
      numEqual++;
    }

    if (fifthInRunNextId == firstCardId || fifthInRunNextId == secondCardId || fifthInRunNextId == thirdCardId || fifthInRunNextId == fourthCardId){
      numEqual++;
    }


    if (numEqual == 4){
      //we have a run of 5
      //give the points to player p
      p.addPoints(5);

    }
    else{
      //we don't have a run of 4
      //notify front end
    }

  }


  /**
  If the player passed as a parameter has a run of 6, the player is awarded 6 points.
  Otherwise, the player isn't awarded any points.
  @param p is the player who claims to have a run of 6
  **/
  private void checkRunOf6 (Player p){

    if (peggingCards.size() < 6){
      //let front end know that run of 4 isn't valid
      return;
    }

    //note, they do not have to be played in sequential order

    Card firstInRun = peggingCards.get(peggingCards.size() - 6);
    Card secondInRun = peggingCards.get(peggingCards.size() - 5);
    Card thirdInRun = peggingCards.get(peggingCards.size() - 4);
    Card fourthInRun = peggingCards.get(peggingCards.size() - 3);
    Card fifthInRun = peggingCards.get(peggingCards.size() - 2);
    Card sixthInRun = peggingCards.get(peggingCards.size() - 1);


    char firstCardId = firstInRun.getIdentifier();
    char secondCardId = secondInRun.getIdentifier();
    char thirdCardId = thirdInRun.getIdentifier();
    char fourthCardId = fourthInRun.getIdentifier();
    char fifthCardId = fifthInRun.getIdentifier();
    char sixthCardId = sixthInRun.getIdentifier();

    //make sure there are no cards with the same identifiers
    if (firstCardId == secondCardId || firstCardId == thirdCardId || firstCardId == fourthCardId || firstCardId == fifthCardId ||  firstCardId == sixthCardId){
      //send information to front end that there isn't a run of 4
      return;
    }

    if (secondCardId == thirdCardId || secondCardId == fourthCardId || secondCardId == fifthCardId || secondCardId == sixthCardId){
      //send information to front end that there isn't a run of 4
      return;
    }

    if (thirdCardId == fourthCardId || thirdCardId == fifthCardId || thirdCardId == sixthCardId ){
      //send information to front end that there isn't a run of 4
      return;
    }

    if (fourthCardId == fifthCardId || fourthCardId == sixthCardId){
      //send information to front end that there isn't a run of 4
      return;
    }

    if (fifthCardId == sixthCardId){
      //send information to front end that there isn't a run of 4
      return;
    }


    //once here, we know that none of the cards have the same identifier

    //get the next identifier for each card
    char firstInRunNextId = firstInRun.getNextIdentifier();
    char secondInRunNextId = secondInRun.getNextIdentifier();
    char thirdInRunNextId = thirdInRun.getNextIdentifier();
    char fourthInRunNextId = fourthInRun.getNextIdentifier();
    char fifthInRunNextId = fifthInRun.getNextIdentifier();
    char sixthInRunNextId = sixthInRun.getNextIdentifier();

    //5 of the 6 next identifiers must be equal to exactly one of the
    //identifiers of the other cards

    int numEqual = 0;

    //check the first next identifier
    if (firstInRunNextId == secondCardId || firstInRunNextId == thirdCardId || firstInRunNextId == fourthCardId || firstInRunNextId == fifthCardId || firstInRunNextId == sixthCardId){
      numEqual++;
    }

    if (secondInRunNextId == firstCardId || secondInRunNextId == thirdCardId || secondInRunNextId == fourthCardId || secondInRunNextId == fifthCardId || secondInRunNextId == sixthCardId){
      numEqual++;
    }

    if (thirdInRunNextId == firstCardId || thirdInRunNextId == secondCardId || thirdInRunNextId == fourthCardId || thirdInRunNextId == fifthCardId || thirdInRunNextId == sixthCardId ){
      numEqual++;
    }

    if (fourthInRunNextId == firstCardId || fourthInRunNextId == secondCardId || fourthInRunNextId == thirdCardId || fourthInRunNextId == fifthCardId || fourthInRunNextId == sixthCardId){
      numEqual++;
    }

    if (fifthInRunNextId == firstCardId || fifthInRunNextId == secondCardId || fifthInRunNextId == thirdCardId || fifthInRunNextId == fourthCardId || fifthInRunNextId == sixthCardId){
      numEqual++;
    }

    if (sixthInRunNextId == firstCardId || sixthInRunNextId == secondCardId || sixthInRunNextId == thirdCardId || sixthInRunNextId == fourthCardId || sixthInRunNextId == fifthCardId){
      numEqual++;
    }


    if (numEqual == 5){
      //we have a run of 6
      //give the points to player p
      p.addPoints(6);

    }
    else{
      //we don't have a run of 4
      //notify front end
    }

  }

  /**
  If the player passed as a parameter has a run of 7, the player is awarded 7 points.
  Otherwise, the player isn't awarded any points.
  @param p is the player who claims to have a run of 7
  **/
  private void checkRunOf7 (Player p){

    if (peggingCards.size() < 7){
      //let front end know that run of 4 isn't valid
      return;
    }

    //note, they do not have to be played in sequential order

    Card firstInRun = peggingCards.get(peggingCards.size() - 7);
    Card secondInRun = peggingCards.get(peggingCards.size() - 6);
    Card thirdInRun = peggingCards.get(peggingCards.size() - 5);
    Card fourthInRun = peggingCards.get(peggingCards.size() - 4);
    Card fifthInRun = peggingCards.get(peggingCards.size() - 3);
    Card sixthInRun = peggingCards.get(peggingCards.size() - 2);
    Card seventhInRun = peggingCards.get(peggingCards.size() - 1);

    char firstCardId = firstInRun.getIdentifier();
    char secondCardId = secondInRun.getIdentifier();
    char thirdCardId = thirdInRun.getIdentifier();
    char fourthCardId = fourthInRun.getIdentifier();
    char fifthCardId = fifthInRun.getIdentifier();
    char sixthCardId = sixthInRun.getIdentifier();
    char seventhCardId = seventhInRun.getIdentifier();

    //make sure there are no cards with the same identifiers
    if (firstCardId == secondCardId || firstCardId == thirdCardId || firstCardId == fourthCardId || firstCardId == fifthCardId ||  firstCardId == sixthCardId || firstCardId == seventhCardId){
      //send information to front end that there isn't a run of 4
      return;
    }

    if (secondCardId == thirdCardId || secondCardId == fourthCardId || secondCardId == fifthCardId || secondCardId == sixthCardId || secondCardId == seventhCardId ){
      //send information to front end that there isn't a run of 4
      return;
    }

    if (thirdCardId == fourthCardId || thirdCardId == fifthCardId || thirdCardId == sixthCardId || thirdCardId == seventhCardId){
      //send information to front end that there isn't a run of 4
      return;
    }

    if (fourthCardId == fifthCardId || fourthCardId == sixthCardId || fourthCardId == seventhCardId){
      //send information to front end that there isn't a run of 4
      return;
    }

    if (fifthCardId == sixthCardId || fifthCardId == seventhCardId){
      //send information to front end that there isn't a run of 4
      return;
    }

    if (sixthCardId == seventhCardId){
      //send information to front end that there isn't a run of 4
      return;
    }


    //once here, we know that none of the cards have the same identifier

    //get the next identifier for each card
    char firstInRunNextId = firstInRun.getNextIdentifier();
    char secondInRunNextId = secondInRun.getNextIdentifier();
    char thirdInRunNextId = thirdInRun.getNextIdentifier();
    char fourthInRunNextId = fourthInRun.getNextIdentifier();
    char fifthInRunNextId = fifthInRun.getNextIdentifier();
    char sixthInRunNextId = sixthInRun.getNextIdentifier();
    char seventhInRunNextId = seventhInRun.getNextIdentifier();

    //6 of the 7 next identifiers must be equal to exactly one of the
    //identifiers of the other cards

    int numEqual = 0;

    //check the first next identifier
    if (firstInRunNextId == secondCardId || firstInRunNextId == thirdCardId || firstInRunNextId == fourthCardId || firstInRunNextId == fifthCardId || firstInRunNextId == sixthCardId || firstInRunNextId == seventhCardId){
      numEqual++;
    }

    if (secondInRunNextId == firstCardId || secondInRunNextId == thirdCardId || secondInRunNextId == fourthCardId || secondInRunNextId == fifthCardId || secondInRunNextId == sixthCardId || secondInRunNextId == seventhCardId){
      numEqual++;
    }

    if (thirdInRunNextId == firstCardId || thirdInRunNextId == secondCardId || thirdInRunNextId == fourthCardId || thirdInRunNextId == fifthCardId || thirdInRunNextId == sixthCardId || thirdInRunNextId == seventhCardId ){
      numEqual++;
    }

    if (fourthInRunNextId == firstCardId || fourthInRunNextId == secondCardId || fourthInRunNextId == thirdCardId || fourthInRunNextId == fifthCardId || fourthInRunNextId == sixthCardId || fourthInRunNextId == seventhCardId){
      numEqual++;
    }

    if (fifthInRunNextId == firstCardId || fifthInRunNextId == secondCardId || fifthInRunNextId == thirdCardId || fifthInRunNextId == fourthCardId || fifthInRunNextId == sixthCardId || fifthInRunNextId == seventhCardId){
      numEqual++;
    }

    if (sixthInRunNextId == firstCardId || sixthInRunNextId == secondCardId || sixthInRunNextId == thirdCardId || sixthInRunNextId == fourthCardId || sixthInRunNextId == fifthCardId || sixthInRunNextId == seventhCardId){
      numEqual++;
    }

    if (seventhInRunNextId == firstCardId || seventhInRunNextId == secondCardId || seventhInRunNextId == thirdCardId || seventhInRunNextId == fourthCardId || seventhInRunNextId == fifthCardId || seventhInRunNextId == sixthCardId){
      numEqual++;
    }


    if (numEqual == 6){
      //we have a run of 7
      //give the points to player p
      p.addPoints(7);

    }
    else{
      //we don't have a run of 4
      //notify front end
    }

  }

  /**
  If the player passed as a parameter placed the final card during pegging play,
  the player receives 1 point. Otherwise, the player receives no points for this claim.
  @param p is the player who is claiming to have placed the last card
  */
  private void lastCard(Player p){
    //all the cards are in peggingCards
    //the last card in peggingCards was placed by p
    //how do we know whether p placed the final card?
    //I think we can know this implicitly because points are earned as played
    //and claims are made as played
    //so, when player p makes a claim that the last card was placed, player p played the most recent card
    //if there are no more cards to be placed, the p placed the last card

    if (playerList.size() == 2){
      if (peggingCards.size() == 8){
        //give 1 point to p
        p.addPoints(1);
      }
      else{
        //indicate that the claim was false to front end
        return;
      }
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
