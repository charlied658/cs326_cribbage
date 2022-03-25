//
// import java.util.ArrayList;
//
// public class CountHand {
//
// 	private Player p = new Player();
//
// 	public CountHand () {
// 		this.p = new Player ();
// 	}
// //	private void check15(Player p){
// //
// //	    //assumption: Card c from checkClaim() has been added to peggingCards already
// //	    //assumption: check15() is called before the dealer plays a card
// //
// //	    int sum = 0;
// //
// //	    for (int i = 0; i < peggingCards.size(); i++){
// //	      Card tempCard = peggingCards.get(i);
// //	      sum += tempCard.getPointValue();
// //	    }
// //
// //	    if (sum == 15){
// //	      //award points to player
// //	      //player p gets 2 points
// //	      p.addPoints(2);
// //	    }
// //	    else{
// //	      //FRONT END
// //	      //indicate to the player that the claim was not valid
// //	    }
// //	  }
//
// 	  /**
// 	  If the player passed as a parameter placed a card during the pegging phase that
// 	  brought the pegging total to 31, the player is awarded 2 points. Otherwise, the
// 	  player is awarded no points.
// 	  @param p is the player making the claim that he or she placed a card that brought
// 	  the pegging total to 31
// 	  */
// //	  private void check31(Player p){
// //
// //	    //assumption: Card c from checkClaim() has been added to peggingCards already
// //	    //assumption: check15() is called before the dealer plays a card
// //
// //	    int sum = 0;
// //
// //	    for (int i = 0; i < peggingCards.size(); i++){
// //	      Card tempCard = peggingCards.get(i);
// //	      sum += tempCard.getPointValue();
// //	    }
// //
// //	    if (sum == 31){
// //	      //award points to player
// //	      //player p gets 2 points
// //	      p.addPoints(2);
// //	    }
// //	    else{
// //	      //FRONT END
// //	      //indicate to the player that the claim was not valid
// //	    }
// //	  }
//
//
// 	  /**
// 	  If the player passed as a parameter placed a card that immediately followed a card with the
// 	  same numerical value, the player is awarded 2 points. Otherwise, the player is awarded no points.
// 	  @param the player who made the claim of having a pair during the pegging phase
// 	  */
// 	  private void checkPair(Player p){
// 	    //assumption: Card c from checkClaim() has been added to peggingCards already
// 	    //assumption: check15() is called before the dealer plays a card
//
// 	    Card precedingCard = peggingCards.get(peggingCards.size() - 2);
// 	    Card mostRecentCard = peggingCards.get(peggingCards.size() - 1);
//
// 	    if (precedingCard.getIdentifier() == mostRecentCard.getIdentifier()){
// 	      //we have a pair
// 	      //player p gets 2 points
// 	      p.addPoints(2);
// 	    }
// 	    else{
// 	      //indicate to front end that the claim was not valid
// 	    }
// 	  }
//
// 	  /**
// 	  If the player passed as a parameter placed a card that immediately followed two cards with the
// 	  same numerical values, the player is awarded 6 points. Otherwise, the player is awarded no points.
// 	  @param the player who made the claim of having a 3 pair during the pegging phase
// 	  */
// 	  private void check3Pair(Player p){
// 	    //assumption: Card c from checkClaim() has been added to peggingCards already
// 	    //assumption: check15() is called before the dealer plays a card
//
// 	    Card firstInPair = peggingCards.get(peggingCards.size() - 3);
// 	    Card secondInPair = peggingCards.get(peggingCards.size() - 2);
// 	    Card lastInPair = peggingCards.get(peggingCards.size() - 1);
//
// 	    if (firstInPair.getIdentifier() == secondInPair.getIdentifier()){
// 	      if (secondInPair.getIdentifier() == lastInPair.getIdentifier()){
// 	        //player p gets 6 points
// 	        p.addPoints(6);
// 	      }
// 	    }
// 	    else{
// 	      //indicate to front end that the claim was not valid
// 	    }
// 	  }
//
// 	  /**
// 	  If the player passed as a parameter placed a card that immediately followed two cards with the
// 	  same numerical values, the player is awarded 6 points. Otherwise, the player is awarded no points.
// 	  @param the player who made the claim of having a 3 pair during the pegging phase
// 	  */
// 	  private void check4Pair(Player p){
// 	    //assumption: Card c from checkClaim() has been added to peggingCards already
// 	    //assumption: check15() is called before the dealer plays a card
//
// 	    Card firstInPair = peggingCards.get(peggingCards.size() - 3);
// 	    Card secondInPair = peggingCards.get(peggingCards.size() - 2);
// 	    Card lastInPair = peggingCards.get(peggingCards.size() - 1);
//
// 	    if (firstInPair.getIdentifier() == secondInPair.getIdentifier()){
// 	      if (secondInPair.getIdentifier() == lastInPair.getIdentifier()){
// 	        //player p gets 6 points
// 	        p.addPoints(6);
// 	      }
// 	    }
// 	    else{
// 	      //indicate to front end that the claim was not valid
// 	    }
// 	  }
//
//
// 	  /**
// 	  If the player passed as a parameter has a run of 3, the player is awarded 3 points.
// 	  Otherwise, the player isn't awarded any points.
// 	  @param p is the player who claims to have a run of 3
// 	  **/
// 	  private void checkRunOf3 (Player p){
//
// 	    if (peggingCards.size() < 3){
// 	      //let front end know that there isn't a run of three
// 	      return;
// 	    }
// 	    //note, they do not have to be played in sequential order
// 	    //if the order is 5,3,4, there is a run of three
// 	    Card firstInRun = peggingCards.get(peggingCards.size() - 3);
// 	    Card secondInRun = peggingCards.get(peggingCards.size() - 2);
// 	    Card thirdInRun = peggingCards.get(peggingCards.size() - 1);
//
// 	    char firstCardId = firstInRun.getIdentifier();
// 	    char secondCardId = secondInRun.getIdentifier();
// 	    char thirdCardId = thirdInRun.getIdentifier();
//
// 	    //make sure there are no cards with the same identifiers
// 	    if (firstCardId == secondCardId || firstCardId == thirdCardId){
// 	      //send information to front end that there isn't a run of 3
// 	      return;
// 	    }
//
// 	    if (secondCardId == thirdCardId){
// 	      //send information to front end that there isn't a run of 3
// 	      return;
// 	    }
//
// 	    //once here, we know that none of the cards have the same identifier
//
// 	    //get the next identifier for each card
// 	    char firstInRunNextId = firstInRun.getNextIdentifier();
// 	    char secondInRunNextId = secondInRun.getNextIdentifier();
// 	    char thirdInRunNextId = thirdInRun.getNextIdentifier();
//
// 	    //two of the three next identifiers must be equal to exactly one of the
// 	    //identifiers of the other cards
//
// 	    int numEqual = 0;
//
// 	    //check the first next identifier
// 	    if (firstInRunNextId == secondCardId || firstInRunNextId == thirdCardId){
// 	      numEqual++;
//
// 	    }
//
// 	    if (secondInRunNextId == firstCardId || secondInRunNextId == thirdCardId){
// 	      numEqual++;
// 	    }
//
// 	    if (thirdInRunNextId == firstCardId || thirdInRunNextId == secondCardId){
// 	      numEqual++;
// 	    }
//
// 	    if (numEqual == 2){
// 	      //we have a run of 3
// 	      //give the points to player p
// 	      p.addPoints(3);
//
// 	    }
// 	    else{
// 	      //we don't have a run of 3
// 	      //notify front end
// 	    }
//
// 	  }
//
// 	  /**
// 	  If the player passed as a parameter has a run of 4, the player is awarded 4 points.
// 	  Otherwise, the player isn't awarded any points.
// 	  @param p is the player who claims to have a run of 4
// 	  **/
// 	  private void checkRunOf4 (Player p){
//
// 	    if (peggingCards.size() < 4){
// 	      //let front end know that run of 4 isn't valid
// 	      return;
// 	    }
//
// 	    //note, they do not have to be played in sequential order
// 	    //if the order is 5,3,4, there is a run of three
// 	    Card firstInRun = peggingCards.get(peggingCards.size() - 4);
// 	    Card secondInRun = peggingCards.get(peggingCards.size() - 3);
// 	    Card thirdInRun = peggingCards.get(peggingCards.size() - 2);
// 	    Card fourthInRun = peggingCards.get(peggingCards.size() - 1);
//
// 	    char firstCardId = firstInRun.getIdentifier();
// 	    char secondCardId = secondInRun.getIdentifier();
// 	    char thirdCardId = thirdInRun.getIdentifier();
// 	    char fourthCardId = fourthInRun.getIdentifier();
//
// 	    //make sure there are no cards with the same identifiers
// 	    if (firstCardId == secondCardId || firstCardId == thirdCardId || firstCardId == fourthCardId){
// 	      //send information to front end that there isn't a run of 4
// 	      return;
// 	    }
//
// 	    if (secondCardId == thirdCardId || secondCardId == fourthCardId){
// 	      //send information to front end that there isn't a run of 4
// 	      return;
// 	    }
//
// 	    if (thirdCardId == fourthCardId){
// 	      //send information to front end that there isn't a run of 4
// 	      return;
// 	    }
//
// 	    //once here, we know that none of the cards have the same identifier
//
// 	    //get the next identifier for each card
// 	    char firstInRunNextId = firstInRun.getNextIdentifier();
// 	    char secondInRunNextId = secondInRun.getNextIdentifier();
// 	    char thirdInRunNextId = thirdInRun.getNextIdentifier();
// 	    char fourthInRunNextId = fourthInRun.getNextIdentifier();
//
// 	    //3 of the 4 next identifiers must be equal to exactly one of the
// 	    //identifiers of the other cards
//
// 	    int numEqual = 0;
//
// 	    //check the first next identifier
// 	    if (firstInRunNextId == secondCardId || firstInRunNextId == thirdCardId || firstInRunNextId == fourthCardId){
// 	      numEqual++;
// 	    }
//
// 	    if (secondInRunNextId == firstCardId || secondInRunNextId == thirdCardId || secondInRunNextId == fourthCardId){
// 	      numEqual++;
// 	    }
//
// 	    if (thirdInRunNextId == firstCardId || thirdInRunNextId == secondCardId || thirdInRunNextId == fourthCardId){
// 	      numEqual++;
// 	    }
//
// 	    if (fourthInRunNextId == firstCardId || fourthInRunNextId == secondCardId || fourthInRunNextId == thirdCardId){
// 	      numEqual++;
// 	    }
//
// 	    if (numEqual == 3){
// 	      //we have a run of 4
// 	      //give the points to player p
// 	      p.addPoints(4);
//
// 	    }
// 	    else{
// 	      //we don't have a run of 4
// 	      //notify front end
// 	    }
//
// 	  }
//
// 	  /**
// 	  If the player passed as a parameter has a run of 5, the player is awarded 5 points.
// 	  Otherwise, the player isn't awarded any points.
// 	  @param p is the player who claims to have a run of 5
// 	  **/
// 	  private void checkRunOf5 (Player p){
//
// 	    if (peggingCards.size() < 5){
// 	      //let front end know that run of 4 isn't valid
// 	      return;
// 	    }
//
// 	    //note, they do not have to be played in sequential order
//
// 	    Card firstInRun = peggingCards.get(peggingCards.size() - 5);
// 	    Card secondInRun = peggingCards.get(peggingCards.size() - 4);
// 	    Card thirdInRun = peggingCards.get(peggingCards.size() - 3);
// 	    Card fourthInRun = peggingCards.get(peggingCards.size() - 2);
// 	    Card fifthInRun = peggingCards.get(peggingCards.size() - 1);
//
//
// 	    char firstCardId = firstInRun.getIdentifier();
// 	    char secondCardId = secondInRun.getIdentifier();
// 	    char thirdCardId = thirdInRun.getIdentifier();
// 	    char fourthCardId = fourthInRun.getIdentifier();
// 	    char fifthCardId = fifthInRun.getIdentifier();
//
// 	    //make sure there are no cards with the same identifiers
// 	    if (firstCardId == secondCardId || firstCardId == thirdCardId || firstCardId == fourthCardId || firstCardId == fifthCardId ){
// 	      //send information to front end that there isn't a run of 4
// 	      return;
// 	    }
//
// 	    if (secondCardId == thirdCardId || secondCardId == fourthCardId || secondCardId == fifthCardId){
// 	      //send information to front end that there isn't a run of 4
// 	      return;
// 	    }
//
// 	    if (thirdCardId == fourthCardId || thirdCardId == fifthCardId ){
// 	      //send information to front end that there isn't a run of 4
// 	      return;
// 	    }
//
// 	    if (fourthCardId == fifthCardId){
// 	      //send information to front end that there isn't a run of 4
// 	      return;
// 	    }
//
//
// 	    //once here, we know that none of the cards have the same identifier
//
// 	    //get the next identifier for each card
// 	    char firstInRunNextId = firstInRun.getNextIdentifier();
// 	    char secondInRunNextId = secondInRun.getNextIdentifier();
// 	    char thirdInRunNextId = thirdInRun.getNextIdentifier();
// 	    char fourthInRunNextId = fourthInRun.getNextIdentifier();
// 	    char fifthInRunNextId = fifthInRun.getNextIdentifier();
//
// 	    //4 of the 5 next identifiers must be equal to exactly one of the
// 	    //identifiers of the other cards
//
// 	    int numEqual = 0;
//
// 	    //check the first next identifier
// 	    if (firstInRunNextId == secondCardId || firstInRunNextId == thirdCardId || firstInRunNextId == fourthCardId || firstInRunNextId == fifthCardId){
// 	      numEqual++;
// 	    }
//
// 	    if (secondInRunNextId == firstCardId || secondInRunNextId == thirdCardId || secondInRunNextId == fourthCardId || secondInRunNextId == fifthCardId){
// 	      numEqual++;
// 	    }
//
// 	    if (thirdInRunNextId == firstCardId || thirdInRunNextId == secondCardId || thirdInRunNextId == fourthCardId || thirdInRunNextId == fifthCardId){
// 	      numEqual++;
// 	    }
//
// 	    if (fourthInRunNextId == firstCardId || fourthInRunNextId == secondCardId || fourthInRunNextId == thirdCardId || fourthInRunNextId == fifthCardId){
// 	      numEqual++;
// 	    }
//
// 	    if (fifthInRunNextId == firstCardId || fifthInRunNextId == secondCardId || fifthInRunNextId == thirdCardId || fifthInRunNextId == fourthCardId){
// 	      numEqual++;
// 	    }
//
//
// 	    if (numEqual == 4){
// 	      //we have a run of 5
// 	      //give the points to player p
// 	      p.addPoints(5);
//
// 	    }
// 	    else{
// 	      //we don't have a run of 4
// 	      //notify front end
// 	    }
//
// 	  }
//
//
// 	  /**
// 	  If the player passed as a parameter has a run of 6, the player is awarded 6 points.
// 	  Otherwise, the player isn't awarded any points.
// 	  @param p is the player who claims to have a run of 6
// 	  **/
// 	  private void checkRunOf6 (Player p){
//
// 	    if (peggingCards.size() < 6){
// 	      //let front end know that run of 4 isn't valid
// 	      return;
// 	    }
//
// 	    //note, they do not have to be played in sequential order
//
// 	    Card firstInRun = peggingCards.get(peggingCards.size() - 6);
// 	    Card secondInRun = peggingCards.get(peggingCards.size() - 5);
// 	    Card thirdInRun = peggingCards.get(peggingCards.size() - 4);
// 	    Card fourthInRun = peggingCards.get(peggingCards.size() - 3);
// 	    Card fifthInRun = peggingCards.get(peggingCards.size() - 2);
// 	    Card sixthInRun = peggingCards.get(peggingCards.size() - 1);
//
//
// 	    char firstCardId = firstInRun.getIdentifier();
// 	    char secondCardId = secondInRun.getIdentifier();
// 	    char thirdCardId = thirdInRun.getIdentifier();
// 	    char fourthCardId = fourthInRun.getIdentifier();
// 	    char fifthCardId = fifthInRun.getIdentifier();
// 	    char sixthCardId = sixthInRun.getIdentifier();
//
// 	    //make sure there are no cards with the same identifiers
// 	    if (firstCardId == secondCardId || firstCardId == thirdCardId || firstCardId == fourthCardId || firstCardId == fifthCardId ||  firstCardId == sixthCardId){
// 	      //send information to front end that there isn't a run of 4
// 	      return;
// 	    }
//
// 	    if (secondCardId == thirdCardId || secondCardId == fourthCardId || secondCardId == fifthCardId || secondCardId == sixthCardId){
// 	      //send information to front end that there isn't a run of 4
// 	      return;
// 	    }
//
// 	    if (thirdCardId == fourthCardId || thirdCardId == fifthCardId || thirdCardId == sixthCardId ){
// 	      //send information to front end that there isn't a run of 4
// 	      return;
// 	    }
//
// 	    if (fourthCardId == fifthCardId || fourthCardId == sixthCardId){
// 	      //send information to front end that there isn't a run of 4
// 	      return;
// 	    }
//
// 	    if (fifthCardId == sixthCardId){
// 	      //send information to front end that there isn't a run of 4
// 	      return;
// 	    }
//
//
// 	    //once here, we know that none of the cards have the same identifier
//
// 	    //get the next identifier for each card
// 	    char firstInRunNextId = firstInRun.getNextIdentifier();
// 	    char secondInRunNextId = secondInRun.getNextIdentifier();
// 	    char thirdInRunNextId = thirdInRun.getNextIdentifier();
// 	    char fourthInRunNextId = fourthInRun.getNextIdentifier();
// 	    char fifthInRunNextId = fifthInRun.getNextIdentifier();
// 	    char sixthInRunNextId = sixthInRun.getNextIdentifier();
//
// 	    //5 of the 6 next identifiers must be equal to exactly one of the
// 	    //identifiers of the other cards
//
// 	    int numEqual = 0;
//
// 	    //check the first next identifier
// 	    if (firstInRunNextId == secondCardId || firstInRunNextId == thirdCardId || firstInRunNextId == fourthCardId || firstInRunNextId == fifthCardId || firstInRunNextId == sixthCardId){
// 	      numEqual++;
// 	    }
//
// 	    if (secondInRunNextId == firstCardId || secondInRunNextId == thirdCardId || secondInRunNextId == fourthCardId || secondInRunNextId == fifthCardId || secondInRunNextId == sixthCardId){
// 	      numEqual++;
// 	    }
//
// 	    if (thirdInRunNextId == firstCardId || thirdInRunNextId == secondCardId || thirdInRunNextId == fourthCardId || thirdInRunNextId == fifthCardId || thirdInRunNextId == sixthCardId ){
// 	      numEqual++;
// 	    }
//
// 	    if (fourthInRunNextId == firstCardId || fourthInRunNextId == secondCardId || fourthInRunNextId == thirdCardId || fourthInRunNextId == fifthCardId || fourthInRunNextId == sixthCardId){
// 	      numEqual++;
// 	    }
//
// 	    if (fifthInRunNextId == firstCardId || fifthInRunNextId == secondCardId || fifthInRunNextId == thirdCardId || fifthInRunNextId == fourthCardId || fifthInRunNextId == sixthCardId){
// 	      numEqual++;
// 	    }
//
// 	    if (sixthInRunNextId == firstCardId || sixthInRunNextId == secondCardId || sixthInRunNextId == thirdCardId || sixthInRunNextId == fourthCardId || sixthInRunNextId == fifthCardId){
// 	      numEqual++;
// 	    }
//
//
// 	    if (numEqual == 5){
// 	      //we have a run of 6
// 	      //give the points to player p
// 	      p.addPoints(6);
//
// 	    }
// 	    else{
// 	      //we don't have a run of 4
// 	      //notify front end
// 	    }
//
// 	  }
//
// 	  /**
// 	  If the player passed as a parameter has a run of 7, the player is awarded 7 points.
// 	  Otherwise, the player isn't awarded any points.
// 	  @param p is the player who claims to have a run of 7
// 	  **/
// 	  private void checkRunOf7 (Player p){
//
// 	    if (peggingCards.size() < 7){
// 	      //let front end know that run of 4 isn't valid
// 	      return;
// 	    }
//
// 	    //note, they do not have to be played in sequential order
//
// 	    Card firstInRun = peggingCards.get(peggingCards.size() - 7);
// 	    Card secondInRun = peggingCards.get(peggingCards.size() - 6);
// 	    Card thirdInRun = peggingCards.get(peggingCards.size() - 5);
// 	    Card fourthInRun = peggingCards.get(peggingCards.size() - 4);
// 	    Card fifthInRun = peggingCards.get(peggingCards.size() - 3);
// 	    Card sixthInRun = peggingCards.get(peggingCards.size() - 2);
// 	    Card seventhInRun = peggingCards.get(peggingCards.size() - 1);
//
// 	    char firstCardId = firstInRun.getIdentifier();
// 	    char secondCardId = secondInRun.getIdentifier();
// 	    char thirdCardId = thirdInRun.getIdentifier();
// 	    char fourthCardId = fourthInRun.getIdentifier();
// 	    char fifthCardId = fifthInRun.getIdentifier();
// 	    char sixthCardId = sixthInRun.getIdentifier();
// 	    char seventhCardId = seventhInRun.getIdentifier();
//
// 	    //make sure there are no cards with the same identifiers
// 	    if (firstCardId == secondCardId || firstCardId == thirdCardId || firstCardId == fourthCardId || firstCardId == fifthCardId ||  firstCardId == sixthCardId || firstCardId == seventhCardId){
// 	      //send information to front end that there isn't a run of 4
// 	      return;
// 	    }
//
// 	    if (secondCardId == thirdCardId || secondCardId == fourthCardId || secondCardId == fifthCardId || secondCardId == sixthCardId || secondCardId == seventhCardId ){
// 	      //send information to front end that there isn't a run of 4
// 	      return;
// 	    }
//
// 	    if (thirdCardId == fourthCardId || thirdCardId == fifthCardId || thirdCardId == sixthCardId || thirdCardId == seventhCardId){
// 	      //send information to front end that there isn't a run of 4
// 	      return;
// 	    }
//
// 	    if (fourthCardId == fifthCardId || fourthCardId == sixthCardId || fourthCardId == seventhCardId){
// 	      //send information to front end that there isn't a run of 4
// 	      return;
// 	    }
//
// 	    if (fifthCardId == sixthCardId || fifthCardId == seventhCardId){
// 	      //send information to front end that there isn't a run of 4
// 	      return;
// 	    }
//
// 	    if (sixthCardId == seventhCardId){
// 	      //send information to front end that there isn't a run of 4
// 	      return;
// 	    }
//
//
// 	    //once here, we know that none of the cards have the same identifier
//
// 	    //get the next identifier for each card
// 	    char firstInRunNextId = firstInRun.getNextIdentifier();
// 	    char secondInRunNextId = secondInRun.getNextIdentifier();
// 	    char thirdInRunNextId = thirdInRun.getNextIdentifier();
// 	    char fourthInRunNextId = fourthInRun.getNextIdentifier();
// 	    char fifthInRunNextId = fifthInRun.getNextIdentifier();
// 	    char sixthInRunNextId = sixthInRun.getNextIdentifier();
// 	    char seventhInRunNextId = seventhInRun.getNextIdentifier();
//
// 	    //6 of the 7 next identifiers must be equal to exactly one of the
// 	    //identifiers of the other cards
//
// 	    int numEqual = 0;
//
// 	    //check the first next identifier
// 	    if (firstInRunNextId == secondCardId || firstInRunNextId == thirdCardId || firstInRunNextId == fourthCardId || firstInRunNextId == fifthCardId || firstInRunNextId == sixthCardId || firstInRunNextId == seventhCardId){
// 	      numEqual++;
// 	    }
//
// 	    if (secondInRunNextId == firstCardId || secondInRunNextId == thirdCardId || secondInRunNextId == fourthCardId || secondInRunNextId == fifthCardId || secondInRunNextId == sixthCardId || secondInRunNextId == seventhCardId){
// 	      numEqual++;
// 	    }
//
// 	    if (thirdInRunNextId == firstCardId || thirdInRunNextId == secondCardId || thirdInRunNextId == fourthCardId || thirdInRunNextId == fifthCardId || thirdInRunNextId == sixthCardId || thirdInRunNextId == seventhCardId ){
// 	      numEqual++;
// 	    }
//
// 	    if (fourthInRunNextId == firstCardId || fourthInRunNextId == secondCardId || fourthInRunNextId == thirdCardId || fourthInRunNextId == fifthCardId || fourthInRunNextId == sixthCardId || fourthInRunNextId == seventhCardId){
// 	      numEqual++;
// 	    }
//
// 	    if (fifthInRunNextId == firstCardId || fifthInRunNextId == secondCardId || fifthInRunNextId == thirdCardId || fifthInRunNextId == fourthCardId || fifthInRunNextId == sixthCardId || fifthInRunNextId == seventhCardId){
// 	      numEqual++;
// 	    }
//
// 	    if (sixthInRunNextId == firstCardId || sixthInRunNextId == secondCardId || sixthInRunNextId == thirdCardId || sixthInRunNextId == fourthCardId || sixthInRunNextId == fifthCardId || sixthInRunNextId == seventhCardId){
// 	      numEqual++;
// 	    }
//
// 	    if (seventhInRunNextId == firstCardId || seventhInRunNextId == secondCardId || seventhInRunNextId == thirdCardId || seventhInRunNextId == fourthCardId || seventhInRunNextId == fifthCardId || seventhInRunNextId == sixthCardId){
// 	      numEqual++;
// 	    }
//
//
// 	    if (numEqual == 6){
// 	      //we have a run of 7
// 	      //give the points to player p
// 	      p.addPoints(7);
//
// 	    }
// 	    else{
// 	      //we don't have a run of 4
// 	      //notify front end
// 	    }
//
// 	  }
//
// 	  /**
// 	  If the player passed as a parameter placed the final card during pegging play,
// 	  the player receives 1 point. Otherwise, the player receives no points for this claim.
// 	  @param p is the player who is claiming to have placed the last card
// 	  */
// 	  private void lastCard(Player p){
// 	    //all the cards are in peggingCards
// 	    //the last card in peggingCards was placed by p
// 	    //how do we know whether p placed the final card?
// 	    //I think we can know this implicitly because points are earned as played
// 	    //and claims are made as played
// 	    //so, when player p makes a claim that the last card was placed, player p played the most recent card
// 	    //if there are no more cards to be placed, the p placed the last card
//
// 	    if (playerList.size() == 2){
// 	      if (peggingCards.size() == 8){
// 	        //give 1 point to p
// 	        p.addPoints(1);
// 	      }
// 	      else{
// 	        //indicate that the claim was false to front end
// 	        return;
// 	      }
// 	    }
//
// 	  }
//
//
//
//
// 	  //to check a claim for points, we would need a record of which cards had been placed
// 	  //we can keep this record with an ArrayList in the class
//
// 	  //when a player places a card down successfully, it should be temporarily moved from the
// 	  //player's hand
// 	  //it should be removed and placed in another array and placed back into the player's hand at the end of the
// 	  //pegging phase
//
// 	  //ways to score in pegging play
// 	  //if a player places a card that brings the total to 15 or 31, then the player gets 2 points
// 	  //if a player places a card that immediately follows a card with the same numerical value, the player gets 2 points
// 	  //if a player places a card that immediately follows two cards with the same numerical values, the player gets 6 points
// 	  //if a player places a card that immediately follows three cards with the same numerical values, the player gets 12 points
// 	  //if a player has a run of 3, then the player gets 3 points
// 	  //if a player has a run of 4, then the player gets 4 points
// 	  //if a player has a run of 5,6, or 7, then the player gets 5, 6, or 7 respectively
// 	  //if a player creates a go, then they get 1 point
// 	  //if a player has the last card, they get 1 point
//
// 	  //pegging phase:
// 	  //pone places a card down first
// 	  //points are pegged when received
//
//
//
//
//
//
// 	}
//
