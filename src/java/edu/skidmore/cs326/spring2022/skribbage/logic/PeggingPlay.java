package edu.skidmore.cs326.spring2022.skribbage.logic;
import java.util.ArrayList;

//@author Michael Shriner
public class PeggingPlay {

  public PeggingPlay(){
  }

  public void peggingPhase (){

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
  Takes a card and a player and adds the card's point value to the total value during pegging play
  unless 31 < peggingTotal + the value of the card to add. If the card is played during
  pegging play, the card is temporarily removed from the player's hand who played it.
  @param cardToAdd is the card whose point value will be added to the total if it meets the condition
  @param p is the player who is trying to play the card
  */
  public void addCardToPeggingTotal(Card cardToAdd, Player p){

    int theCardValue = cardToAdd.getPointValue();

    if (addToPeggingTotal(theCardValue)){
      //if here, the card was added to the pegging total

      //remove the card from the player's hand and place it in pegging cards
      p.getHand().removeCardFromHand(cardToAdd);

      if (p.isDealer){
        Game.addDealerPeggingCard(cardToAdd);
      }
      else{
        Game.addPonePeggingCard(cardToAdd);
      }

    }
    else{
      //indicate to the user that the card cannot be played
      //FRONT END INTERACTION HERE
    }
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
  public void checkClaim (String claim, Player p){

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
  public void check15(Player p){

    //assumption: Card c from checkClaim() has been added to peggingCards already
    //assumption: check15() is called before the next player plays a card

    if (sumTotalPeggingCards() == 15){
      p.addPoints(2);
    }
    else{
      //FRONT END
      //indicate to the player that the claim was not valid
    }

  }

  public int sumTotalPeggingCards(){

    int sum = 0;
    ArrayList<Card> dealerPeggingCards = Game.getDealerPeggingCards();
    ArrayList<Card> ponePeggingCards = Game.getPonePeggingCards();

    for (int i = 0; i < dealerPeggingCards.size(); i++){
      Card tempCard = dealerPeggingCards.get(i);
      sum += tempCard.getPointValue();
    }

    for (int i = 0; i < ponePeggingCards.size(); i++){
      Card tempCard = ponePeggingCards.get(i);
      sum += tempCard.getPointValue();
    }

    return sum;

  }

  /**
  If the player passed as a parameter placed a card during the pegging phase that
  brought the pegging total to 31, the player is awarded 2 points. Otherwise, the
  player is awarded no points.
  @param p is the player making the claim that he or she placed a card that brought
  the pegging total to 31
  */
  public void check31(Player p){

    //assumption: Card c from checkClaim() has been added to peggingCards already
    //assumption: check15() is called before the next player plays a card

    if (sumTotalPeggingCards() == 31){
      p.addPoints(2);
    }
    else{
      //FRONT END
      //indicate to the player that the claim was not valid
    }

  }

  public boolean isPair(ArrayList<Card> cards){

    //check if the cards in the list have the same identifier
    //if they do, return true
    //if they don't, return false
    //if there are no cards in the list, return false

    if (cards.size() == 0){
      return false;
    }

    char id = cards.get(0).getIdentifier();

    for (int i = 1; i < cards.size(); i++){
      char idToCompare = cards.get(i).getIdentifier();
      if (id != idToCompare){
        return false;
      }
    }

    return true;

  }


  /**
  If the player passed as a parameter placed a card that immediately followed a card with the
  same numerical value, the player is awarded 2 points. Otherwise, the player is awarded no points.
  @param the player who made the claim of having a pair during the pegging phase
  */
  public void checkPair(Player p){
    //assumption: Card c from checkClaim() has been added to peggingCards already
    //assumption: check15() is called before the next player plays a card

    ArrayList <Card> dealerPeggingCards = Game.getDealerPeggingCards();
    ArrayList <Card> ponePeggingCards = Game.getPonePeggingCards();
    ArrayList<Card> checkIfPair = new ArrayList <Card>();

    checkIfPair.add(dealerPeggingCards.get(dealerPeggingCards.size()-1));
    checkIfPair.add(ponePeggingCards.get(ponePeggingCards.size()-1));

    if (isPair(checkIfPair)){
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
  public void check3Pair(Player p){
    //assumption: Card c from checkClaim() has been added to peggingCards already
    //assumption: check15() is called before the next player plays a card

    ArrayList <Card> dealerPeggingCards = Game.getDealerPeggingCards();
    ArrayList <Card> ponePeggingCards = Game.getPonePeggingCards();
    ArrayList<Card> checkIfPair = new ArrayList <Card>();

    if (p.isDealer){
      //if the person making the claim is the dealer, the dealer played a card
      //first, then the pone, then the dealer again
      //so, check two cards from dealer and one from pone
      if (dealerPeggingCards.size() < 2){
        //the player does not have a pair of 3
        //let front end know
      }
      else{
        checkIfPair.add(dealerPeggingCards.get(dealerPeggingCards.size()-1));
        checkIfPair.add(dealerPeggingCards.get(dealerPeggingCards.size()-2));
        checkIfPair.add(ponePeggingCards.get(ponePeggingCards.size()-1));
      }

    }
    else{
      if (ponePeggingCards.size() < 2){
        //the player does not have a pair of 3
        //let front end know
      }
      else{
        //check two cards from pone and one from dealer
        checkIfPair.add(ponePeggingCards.get(ponePeggingCards.size()-1));
        checkIfPair.add(ponePeggingCards.get(ponePeggingCards.size()-2));
        checkIfPair.add(dealerPeggingCards.get(dealerPeggingCards.size()-1));
      }

    }

    if (isPair(checkIfPair)){
      p.addPoints(6);
    }
    else{
      //indicate to front end that the claim was not valid
    }

  }

  /**
  If the player passed as a parameter placed a card that immediately followed 3 cards with the
  same numerical values, the player is awarded 12 points. Otherwise, the player is awarded no points.
  @param the player who made the claim of having a 3 pair during the pegging phase
  */
  public void check4Pair(Player p){
    //assumption: Card c from checkClaim() has been added to peggingCards already
    //assumption: check15() is called before the dealer plays a card

    ArrayList <Card> dealerPeggingCards = Game.getDealerPeggingCards();
    ArrayList <Card> ponePeggingCards = Game.getPonePeggingCards();
    ArrayList<Card> checkIfPair = new ArrayList <Card>();

    checkIfPair.add(dealerPeggingCards.get(dealerPeggingCards.size()-1));
    checkIfPair.add(dealerPeggingCards.get(dealerPeggingCards.size()-2));
    checkIfPair.add(ponePeggingCards.get(ponePeggingCards.size()-1));
    checkIfPair.add(ponePeggingCards.get(ponePeggingCards.size()-2));

    if (isPair(checkIfPair)){
      p.addPoints(12);
    }
    else{
      //indicate to front end that the claim was not valid
    }

  }


  //============ left off here =====================
  //
  //
  // /**
  // If the player passed as a parameter has a run of 3, the player is awarded 3 points.
  // Otherwise, the player isn't awarded any points.
  // @param p is the player who claims to have a run of 3
  // **/
  // private void checkRunOf3 (Player p){
  //
  //   if (peggingCards.size() < 3){
  //     //let front end know that there isn't a run of three
  //     return;
  //   }
  //   //note, they do not have to be played in sequential order
  //   //if the order is 5,3,4, there is a run of three
  //   Card firstInRun = peggingCards.get(peggingCards.size() - 3);
  //   Card secondInRun = peggingCards.get(peggingCards.size() - 2);
  //   Card thirdInRun = peggingCards.get(peggingCards.size() - 1);
  //
  //   char firstCardId = firstInRun.getIdentifier();
  //   char secondCardId = secondInRun.getIdentifier();
  //   char thirdCardId = thirdInRun.getIdentifier();
  //
  //   //make sure there are no cards with the same identifiers
  //   if (firstCardId == secondCardId || firstCardId == thirdCardId){
  //     //send information to front end that there isn't a run of 3
  //     return;
  //   }
  //
  //   if (secondCardId == thirdCardId){
  //     //send information to front end that there isn't a run of 3
  //     return;
  //   }
  //
  //   //once here, we know that none of the cards have the same identifier
  //
  //   //get the next identifier for each card
  //   char firstInRunNextId = firstInRun.getNextIdentifier();
  //   char secondInRunNextId = secondInRun.getNextIdentifier();
  //   char thirdInRunNextId = thirdInRun.getNextIdentifier();
  //
  //   //two of the three next identifiers must be equal to exactly one of the
  //   //identifiers of the other cards
  //
  //   int numEqual = 0;
  //
  //   //check the first next identifier
  //   if (firstInRunNextId == secondCardId || firstInRunNextId == thirdCardId){
  //     numEqual++;
  //
  //   }
  //
  //   if (secondInRunNextId == firstCardId || secondInRunNextId == thirdCardId){
  //     numEqual++;
  //   }
  //
  //   if (thirdInRunNextId == firstCardId || thirdInRunNextId == secondCardId){
  //     numEqual++;
  //   }
  //
  //   if (numEqual == 2){
  //     //we have a run of 3
  //     //give the points to player p
  //     p.addPoints(3);
  //
  //   }
  //   else{
  //     //we don't have a run of 3
  //     //notify front end
  //   }
  //
  // }
  //
  // /**
  // If the player passed as a parameter has a run of 4, the player is awarded 4 points.
  // Otherwise, the player isn't awarded any points.
  // @param p is the player who claims to have a run of 4
  // **/
  // private void checkRunOf4 (Player p){
  //
  //   if (peggingCards.size() < 4){
  //     //let front end know that run of 4 isn't valid
  //     return;
  //   }
  //
  //   //note, they do not have to be played in sequential order
  //   //if the order is 5,3,4, there is a run of three
  //   Card firstInRun = peggingCards.get(peggingCards.size() - 4);
  //   Card secondInRun = peggingCards.get(peggingCards.size() - 3);
  //   Card thirdInRun = peggingCards.get(peggingCards.size() - 2);
  //   Card fourthInRun = peggingCards.get(peggingCards.size() - 1);
  //
  //   char firstCardId = firstInRun.getIdentifier();
  //   char secondCardId = secondInRun.getIdentifier();
  //   char thirdCardId = thirdInRun.getIdentifier();
  //   char fourthCardId = fourthInRun.getIdentifier();
  //
  //   //make sure there are no cards with the same identifiers
  //   if (firstCardId == secondCardId || firstCardId == thirdCardId || firstCardId == fourthCardId){
  //     //send information to front end that there isn't a run of 4
  //     return;
  //   }
  //
  //   if (secondCardId == thirdCardId || secondCardId == fourthCardId){
  //     //send information to front end that there isn't a run of 4
  //     return;
  //   }
  //
  //   if (thirdCardId == fourthCardId){
  //     //send information to front end that there isn't a run of 4
  //     return;
  //   }
  //
  //   //once here, we know that none of the cards have the same identifier
  //
  //   //get the next identifier for each card
  //   char firstInRunNextId = firstInRun.getNextIdentifier();
  //   char secondInRunNextId = secondInRun.getNextIdentifier();
  //   char thirdInRunNextId = thirdInRun.getNextIdentifier();
  //   char fourthInRunNextId = fourthInRun.getNextIdentifier();
  //
  //   //3 of the 4 next identifiers must be equal to exactly one of the
  //   //identifiers of the other cards
  //
  //   int numEqual = 0;
  //
  //   //check the first next identifier
  //   if (firstInRunNextId == secondCardId || firstInRunNextId == thirdCardId || firstInRunNextId == fourthCardId){
  //     numEqual++;
  //   }
  //
  //   if (secondInRunNextId == firstCardId || secondInRunNextId == thirdCardId || secondInRunNextId == fourthCardId){
  //     numEqual++;
  //   }
  //
  //   if (thirdInRunNextId == firstCardId || thirdInRunNextId == secondCardId || thirdInRunNextId == fourthCardId){
  //     numEqual++;
  //   }
  //
  //   if (fourthInRunNextId == firstCardId || fourthInRunNextId == secondCardId || fourthInRunNextId == thirdCardId){
  //     numEqual++;
  //   }
  //
  //   if (numEqual == 3){
  //     //we have a run of 4
  //     //give the points to player p
  //     p.addPoints(4);
  //
  //   }
  //   else{
  //     //we don't have a run of 4
  //     //notify front end
  //   }
  //
  // }
  //
  // /**
  // If the player passed as a parameter has a run of 5, the player is awarded 5 points.
  // Otherwise, the player isn't awarded any points.
  // @param p is the player who claims to have a run of 5
  // **/
  // private void checkRunOf5 (Player p){
  //
  //   if (peggingCards.size() < 5){
  //     //let front end know that run of 4 isn't valid
  //     return;
  //   }
  //
  //   //note, they do not have to be played in sequential order
  //
  //   Card firstInRun = peggingCards.get(peggingCards.size() - 5);
  //   Card secondInRun = peggingCards.get(peggingCards.size() - 4);
  //   Card thirdInRun = peggingCards.get(peggingCards.size() - 3);
  //   Card fourthInRun = peggingCards.get(peggingCards.size() - 2);
  //   Card fifthInRun = peggingCards.get(peggingCards.size() - 1);
  //
  //
  //   char firstCardId = firstInRun.getIdentifier();
  //   char secondCardId = secondInRun.getIdentifier();
  //   char thirdCardId = thirdInRun.getIdentifier();
  //   char fourthCardId = fourthInRun.getIdentifier();
  //   char fifthCardId = fifthInRun.getIdentifier();
  //
  //   //make sure there are no cards with the same identifiers
  //   if (firstCardId == secondCardId || firstCardId == thirdCardId || firstCardId == fourthCardId || firstCardId == fifthCardId ){
  //     //send information to front end that there isn't a run of 4
  //     return;
  //   }
  //
  //   if (secondCardId == thirdCardId || secondCardId == fourthCardId || secondCardId == fifthCardId){
  //     //send information to front end that there isn't a run of 4
  //     return;
  //   }
  //
  //   if (thirdCardId == fourthCardId || thirdCardId == fifthCardId ){
  //     //send information to front end that there isn't a run of 4
  //     return;
  //   }
  //
  //   if (fourthCardId == fifthCardId){
  //     //send information to front end that there isn't a run of 4
  //     return;
  //   }
  //
  //
  //   //once here, we know that none of the cards have the same identifier
  //
  //   //get the next identifier for each card
  //   char firstInRunNextId = firstInRun.getNextIdentifier();
  //   char secondInRunNextId = secondInRun.getNextIdentifier();
  //   char thirdInRunNextId = thirdInRun.getNextIdentifier();
  //   char fourthInRunNextId = fourthInRun.getNextIdentifier();
  //   char fifthInRunNextId = fifthInRun.getNextIdentifier();
  //
  //   //4 of the 5 next identifiers must be equal to exactly one of the
  //   //identifiers of the other cards
  //
  //   int numEqual = 0;
  //
  //   //check the first next identifier
  //   if (firstInRunNextId == secondCardId || firstInRunNextId == thirdCardId || firstInRunNextId == fourthCardId || firstInRunNextId == fifthCardId){
  //     numEqual++;
  //   }
  //
  //   if (secondInRunNextId == firstCardId || secondInRunNextId == thirdCardId || secondInRunNextId == fourthCardId || secondInRunNextId == fifthCardId){
  //     numEqual++;
  //   }
  //
  //   if (thirdInRunNextId == firstCardId || thirdInRunNextId == secondCardId || thirdInRunNextId == fourthCardId || thirdInRunNextId == fifthCardId){
  //     numEqual++;
  //   }
  //
  //   if (fourthInRunNextId == firstCardId || fourthInRunNextId == secondCardId || fourthInRunNextId == thirdCardId || fourthInRunNextId == fifthCardId){
  //     numEqual++;
  //   }
  //
  //   if (fifthInRunNextId == firstCardId || fifthInRunNextId == secondCardId || fifthInRunNextId == thirdCardId || fifthInRunNextId == fourthCardId){
  //     numEqual++;
  //   }
  //
  //
  //   if (numEqual == 4){
  //     //we have a run of 5
  //     //give the points to player p
  //     p.addPoints(5);
  //
  //   }
  //   else{
  //     //we don't have a run of 4
  //     //notify front end
  //   }
  //
  // }
  //
  //
  // /**
  // If the player passed as a parameter has a run of 6, the player is awarded 6 points.
  // Otherwise, the player isn't awarded any points.
  // @param p is the player who claims to have a run of 6
  // **/
  // private void checkRunOf6 (Player p){
  //
  //   if (peggingCards.size() < 6){
  //     //let front end know that run of 4 isn't valid
  //     return;
  //   }
  //
  //   //note, they do not have to be played in sequential order
  //
  //   Card firstInRun = peggingCards.get(peggingCards.size() - 6);
  //   Card secondInRun = peggingCards.get(peggingCards.size() - 5);
  //   Card thirdInRun = peggingCards.get(peggingCards.size() - 4);
  //   Card fourthInRun = peggingCards.get(peggingCards.size() - 3);
  //   Card fifthInRun = peggingCards.get(peggingCards.size() - 2);
  //   Card sixthInRun = peggingCards.get(peggingCards.size() - 1);
  //
  //
  //   char firstCardId = firstInRun.getIdentifier();
  //   char secondCardId = secondInRun.getIdentifier();
  //   char thirdCardId = thirdInRun.getIdentifier();
  //   char fourthCardId = fourthInRun.getIdentifier();
  //   char fifthCardId = fifthInRun.getIdentifier();
  //   char sixthCardId = sixthInRun.getIdentifier();
  //
  //   //make sure there are no cards with the same identifiers
  //   if (firstCardId == secondCardId || firstCardId == thirdCardId || firstCardId == fourthCardId || firstCardId == fifthCardId ||  firstCardId == sixthCardId){
  //     //send information to front end that there isn't a run of 4
  //     return;
  //   }
  //
  //   if (secondCardId == thirdCardId || secondCardId == fourthCardId || secondCardId == fifthCardId || secondCardId == sixthCardId){
  //     //send information to front end that there isn't a run of 4
  //     return;
  //   }
  //
  //   if (thirdCardId == fourthCardId || thirdCardId == fifthCardId || thirdCardId == sixthCardId ){
  //     //send information to front end that there isn't a run of 4
  //     return;
  //   }
  //
  //   if (fourthCardId == fifthCardId || fourthCardId == sixthCardId){
  //     //send information to front end that there isn't a run of 4
  //     return;
  //   }
  //
  //   if (fifthCardId == sixthCardId){
  //     //send information to front end that there isn't a run of 4
  //     return;
  //   }
  //
  //
  //   //once here, we know that none of the cards have the same identifier
  //
  //   //get the next identifier for each card
  //   char firstInRunNextId = firstInRun.getNextIdentifier();
  //   char secondInRunNextId = secondInRun.getNextIdentifier();
  //   char thirdInRunNextId = thirdInRun.getNextIdentifier();
  //   char fourthInRunNextId = fourthInRun.getNextIdentifier();
  //   char fifthInRunNextId = fifthInRun.getNextIdentifier();
  //   char sixthInRunNextId = sixthInRun.getNextIdentifier();
  //
  //   //5 of the 6 next identifiers must be equal to exactly one of the
  //   //identifiers of the other cards
  //
  //   int numEqual = 0;
  //
  //   //check the first next identifier
  //   if (firstInRunNextId == secondCardId || firstInRunNextId == thirdCardId || firstInRunNextId == fourthCardId || firstInRunNextId == fifthCardId || firstInRunNextId == sixthCardId){
  //     numEqual++;
  //   }
  //
  //   if (secondInRunNextId == firstCardId || secondInRunNextId == thirdCardId || secondInRunNextId == fourthCardId || secondInRunNextId == fifthCardId || secondInRunNextId == sixthCardId){
  //     numEqual++;
  //   }
  //
  //   if (thirdInRunNextId == firstCardId || thirdInRunNextId == secondCardId || thirdInRunNextId == fourthCardId || thirdInRunNextId == fifthCardId || thirdInRunNextId == sixthCardId ){
  //     numEqual++;
  //   }
  //
  //   if (fourthInRunNextId == firstCardId || fourthInRunNextId == secondCardId || fourthInRunNextId == thirdCardId || fourthInRunNextId == fifthCardId || fourthInRunNextId == sixthCardId){
  //     numEqual++;
  //   }
  //
  //   if (fifthInRunNextId == firstCardId || fifthInRunNextId == secondCardId || fifthInRunNextId == thirdCardId || fifthInRunNextId == fourthCardId || fifthInRunNextId == sixthCardId){
  //     numEqual++;
  //   }
  //
  //   if (sixthInRunNextId == firstCardId || sixthInRunNextId == secondCardId || sixthInRunNextId == thirdCardId || sixthInRunNextId == fourthCardId || sixthInRunNextId == fifthCardId){
  //     numEqual++;
  //   }
  //
  //
  //   if (numEqual == 5){
  //     //we have a run of 6
  //     //give the points to player p
  //     p.addPoints(6);
  //
  //   }
  //   else{
  //     //we don't have a run of 4
  //     //notify front end
  //   }
  //
  // }
  //
  // /**
  // If the player passed as a parameter has a run of 7, the player is awarded 7 points.
  // Otherwise, the player isn't awarded any points.
  // @param p is the player who claims to have a run of 7
  // **/
  // private void checkRunOf7 (Player p){
  //
  //   if (peggingCards.size() < 7){
  //     //let front end know that run of 4 isn't valid
  //     return;
  //   }
  //
  //   //note, they do not have to be played in sequential order
  //
  //   Card firstInRun = peggingCards.get(peggingCards.size() - 7);
  //   Card secondInRun = peggingCards.get(peggingCards.size() - 6);
  //   Card thirdInRun = peggingCards.get(peggingCards.size() - 5);
  //   Card fourthInRun = peggingCards.get(peggingCards.size() - 4);
  //   Card fifthInRun = peggingCards.get(peggingCards.size() - 3);
  //   Card sixthInRun = peggingCards.get(peggingCards.size() - 2);
  //   Card seventhInRun = peggingCards.get(peggingCards.size() - 1);
  //
  //   char firstCardId = firstInRun.getIdentifier();
  //   char secondCardId = secondInRun.getIdentifier();
  //   char thirdCardId = thirdInRun.getIdentifier();
  //   char fourthCardId = fourthInRun.getIdentifier();
  //   char fifthCardId = fifthInRun.getIdentifier();
  //   char sixthCardId = sixthInRun.getIdentifier();
  //   char seventhCardId = seventhInRun.getIdentifier();
  //
  //   //make sure there are no cards with the same identifiers
  //   if (firstCardId == secondCardId || firstCardId == thirdCardId || firstCardId == fourthCardId || firstCardId == fifthCardId ||  firstCardId == sixthCardId || firstCardId == seventhCardId){
  //     //send information to front end that there isn't a run of 4
  //     return;
  //   }
  //
  //   if (secondCardId == thirdCardId || secondCardId == fourthCardId || secondCardId == fifthCardId || secondCardId == sixthCardId || secondCardId == seventhCardId ){
  //     //send information to front end that there isn't a run of 4
  //     return;
  //   }
  //
  //   if (thirdCardId == fourthCardId || thirdCardId == fifthCardId || thirdCardId == sixthCardId || thirdCardId == seventhCardId){
  //     //send information to front end that there isn't a run of 4
  //     return;
  //   }
  //
  //   if (fourthCardId == fifthCardId || fourthCardId == sixthCardId || fourthCardId == seventhCardId){
  //     //send information to front end that there isn't a run of 4
  //     return;
  //   }
  //
  //   if (fifthCardId == sixthCardId || fifthCardId == seventhCardId){
  //     //send information to front end that there isn't a run of 4
  //     return;
  //   }
  //
  //   if (sixthCardId == seventhCardId){
  //     //send information to front end that there isn't a run of 4
  //     return;
  //   }
  //
  //
  //   //once here, we know that none of the cards have the same identifier
  //
  //   //get the next identifier for each card
  //   char firstInRunNextId = firstInRun.getNextIdentifier();
  //   char secondInRunNextId = secondInRun.getNextIdentifier();
  //   char thirdInRunNextId = thirdInRun.getNextIdentifier();
  //   char fourthInRunNextId = fourthInRun.getNextIdentifier();
  //   char fifthInRunNextId = fifthInRun.getNextIdentifier();
  //   char sixthInRunNextId = sixthInRun.getNextIdentifier();
  //   char seventhInRunNextId = seventhInRun.getNextIdentifier();
  //
  //   //6 of the 7 next identifiers must be equal to exactly one of the
  //   //identifiers of the other cards
  //
  //   int numEqual = 0;
  //
  //   //check the first next identifier
  //   if (firstInRunNextId == secondCardId || firstInRunNextId == thirdCardId || firstInRunNextId == fourthCardId || firstInRunNextId == fifthCardId || firstInRunNextId == sixthCardId || firstInRunNextId == seventhCardId){
  //     numEqual++;
  //   }
  //
  //   if (secondInRunNextId == firstCardId || secondInRunNextId == thirdCardId || secondInRunNextId == fourthCardId || secondInRunNextId == fifthCardId || secondInRunNextId == sixthCardId || secondInRunNextId == seventhCardId){
  //     numEqual++;
  //   }
  //
  //   if (thirdInRunNextId == firstCardId || thirdInRunNextId == secondCardId || thirdInRunNextId == fourthCardId || thirdInRunNextId == fifthCardId || thirdInRunNextId == sixthCardId || thirdInRunNextId == seventhCardId ){
  //     numEqual++;
  //   }
  //
  //   if (fourthInRunNextId == firstCardId || fourthInRunNextId == secondCardId || fourthInRunNextId == thirdCardId || fourthInRunNextId == fifthCardId || fourthInRunNextId == sixthCardId || fourthInRunNextId == seventhCardId){
  //     numEqual++;
  //   }
  //
  //   if (fifthInRunNextId == firstCardId || fifthInRunNextId == secondCardId || fifthInRunNextId == thirdCardId || fifthInRunNextId == fourthCardId || fifthInRunNextId == sixthCardId || fifthInRunNextId == seventhCardId){
  //     numEqual++;
  //   }
  //
  //   if (sixthInRunNextId == firstCardId || sixthInRunNextId == secondCardId || sixthInRunNextId == thirdCardId || sixthInRunNextId == fourthCardId || sixthInRunNextId == fifthCardId || sixthInRunNextId == seventhCardId){
  //     numEqual++;
  //   }
  //
  //   if (seventhInRunNextId == firstCardId || seventhInRunNextId == secondCardId || seventhInRunNextId == thirdCardId || seventhInRunNextId == fourthCardId || seventhInRunNextId == fifthCardId || seventhInRunNextId == sixthCardId){
  //     numEqual++;
  //   }
  //
  //
  //   if (numEqual == 6){
  //     //we have a run of 7
  //     //give the points to player p
  //     p.addPoints(7);
  //
  //   }
  //   else{
  //     //we don't have a run of 4
  //     //notify front end
  //   }
  //
  // }
  //
  //
  //
  // //Question about lastCard:
  // //is the last card the card played last in a sequence during pegging play or is the last card
  // //the last card to be played out of both player's hands
  //
  // /**
  // If the player passed as a parameter placed the final card during pegging play,
  // the player receives 1 point. Otherwise, the player receives no points for this claim.
  // @param p is the player who is claiming to have placed the last card
  // */
  // // private void lastCard(Player p){
  // //   //all the cards are in peggingCards
  // //   //the last card in peggingCards was placed by p
  // //   //how do we know whether p placed the final card?
  // //   //I think we can know this implicitly because points are earned as played
  // //   //and claims are made as played
  // //   //so, when player p makes a claim that the last card was placed, player p played the most recent card
  // //   //if there are no more cards to be placed, the p placed the last card
  // //
  // //   if (Game.getPlayerList().size() == 2){
  // //     if (peggingCards.size() == 8){
  // //       //give 1 point to p
  // //       p.addPoints(1);
  // //     }
  // //     else{
  // //       //indicate that the claim was false to front end
  // //       return;
  // //     }
  // //   }
  // //
  // // }
  // //
  // //
  // //
  // // public void go(){
  // //   //if a player cannot play a card without exceeding 31, the player says go
  // //   //this method is called
  // //   //if the other player can play a card without exceeding 31
  // //   //the other player gets 1 point
  // //   //if the other player plays the last card, the other player gets another point
  // //   //if the other player cannot play a card without exceeding 31
  // //   //the first player who said go gets 1 point
  // //
  // //   //reset the peggingTotal to 0
  // //   Game.setPeggingTotal(0);
  // // }
  //
  //
  //
  //
  // //to check a claim for points, we would need a record of which cards had been placed
  // //we can keep this record with an ArrayList in the class
  //
  // //when a player places a card down successfully, it should be temporarily moved from the
  // //player's hand
  // //it should be removed and placed in another array and placed back into the player's hand at the end of the
  // //pegging phase
  //
  // //ways to score in pegging play
  // //if a player places a card that brings the total to 15 or 31, then the player gets 2 points
  // //if a player places a card that immediately follows a card with the same numerical value, the player gets 2 points
  // //if a player places a card that immediately follows two cards with the same numerical values, the player gets 6 points
  // //if a player places a card that immediately follows three cards with the same numerical values, the player gets 12 points
  // //if a player has a run of 3, then the player gets 3 points
  // //if a player has a run of 4, then the player gets 4 points
  // //if a player has a run of 5,6, or 7, then the player gets 5, 6, or 7 respectively
  // //if a player creates a go, then they get 1 point
  // //if a player has the last card, they get 1 point
  //
  // //pegging phase:
  // //pone places a card down first
  // //points are pegged when received
  //
  //
  //
  //


}
