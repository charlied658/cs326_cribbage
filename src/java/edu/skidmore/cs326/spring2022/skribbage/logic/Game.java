package edu.skidmore.cs326.spring2022.skribbage.logic;
import java.util.ArrayList;
import org.apache.log4j.Logger;

/**
 Game contains the state of the game. It has a deck, a list of players, a
 pegging total, a list of cards in the crib, and a list of cards placed during
 pegging play. It has methods to initialize the list of players, get each field,
 and get the index containing the dealer in playerList.
@author Michael Shriner
*/
public class Game{

  /** the deck of cards used to play Cribbage */
  static Deck theDeck = new Deck();

  /**The list of players who are playing this game of Cribbage */
  static ArrayList <Player> playerList = new ArrayList <Player> ();

  /**The total score among the players during the pegging phase of the game ( 0 <= peggingTotal <= 31)*/
  static int peggingTotal = 0;

  /** the crib for the game */
  static ArrayList<Card> crib = new ArrayList <Card> ();

  //static ArrayList<Card> peggingCards = new ArrayList <Card>();

  /**the set of cards played by the pone during the pegging phase*/
  static ArrayList <Card> ponePeggingCards = new ArrayList <Card> ();

  /**the set of cards played by the dealer during the pegging phase*/
  static ArrayList <Card> dealerPeggingCards = new ArrayList <Card>();


  /**
  Initializes the ArrayList of Player objects given the number of players for this game.
  However, there are assumptions, for now, that numPlayers == 2
  @param numPlayers is the number of players
  */
  public static void initPlayers(int numPlayers){

    for (int i = 0; i < numPlayers; i++){
      Player p = new Player();
      playerList.add(p);
    }

  }//end of initPlayers

  public static void setPeggingTotal(int pts){
    peggingTotal = pts;
  }

  public static Deck getDeck(){
    return theDeck;
  }

  public static int getPeggingTotal(){
    return peggingTotal;
  }

  public static ArrayList <Card> getPonePeggingCards(){
    return ponePeggingCards;
  }

  public static ArrayList<Card> getDealerPeggingCards(){
    return dealerPeggingCards;
  }

  public static void addPonePeggingCard(Card c){
    ponePeggingCards.add(c);
  }

  public static void addDealerPeggingCard(Card c){
    dealerPeggingCards.add(c);
  }

  /**
  Returns the list of players.
  @return an ArrayList of players.
  */
  public static ArrayList <Player> getPlayerList (){
    return playerList;
  }

  public static ArrayList <Card> getCrib(){
    return crib;
  }

  //returns true if successful and false if amountToAdd + peggingTotal > 31
  public static boolean addToPeggingTotal (int amountToAdd){
    if (amountToAdd + peggingTotal > 31){
      return false;
    }
    else{
      peggingTotal += amountToAdd;
      return true;
    }
  }

  //gets the index in playerList where the dealer is
  /**
  Returns the index in playerList where the dealer is or -1.
  @return the index in playerList where the dealer is or -1 if there is no dealer.
  */
  public static int getDealerIdx(){
    for (int i = 0; i < playerList.size(); i++){
      if (playerList.get(i).isDealer == true){
        return i;
      }
    }
    return -1;
  }



}
