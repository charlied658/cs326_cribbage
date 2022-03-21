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
  private static Deck theDeck = new Deck();

  /**The list of players who are playing this game of Cribbage */
  private static ArrayList <Player> playerList = new ArrayList <Player> ();

  /**The total score among the players during the pegging phase of the game ( 0 <= peggingTotal <= 31)*/
  private static int peggingTotal = 0;

  /** the crib for the game */
  private static ArrayList<Card> crib = new ArrayList <Card> ();

  private static ArrayList<Card> peggingCards = new ArrayList <Card>();

  //
  // /**
  // Constructor creates a Game, initializes the deck, the list of players, and the
  // pegging total for this game.
  // @param numPlayers is the number of players
  // */
  // public Game(int numPlayers){
  //   //initialize theDeck
  //   this.theDeck = new Deck();
  //
  //   //initialize list of players, given numPlayers
  //   initPlayers(numPlayers);
  //
  //   this.peggingTotal = 0;
  // }

  /**
  Initializes the ArrayList of Player objects given the number of players for this game.
  @param numPlayers is the number of players
  */
  private static void initPlayers(int numPlayers){

    for (int i = 0; i < numPlayers; i++){
      Player p = new Player();
      playerList.add(p);
    }

  }//end of initPlayers

  /**
  Returns the list of players.
  @return an ArrayList of players.
  */
  private static ArrayList <Player> getPlayerList (){
    return playerList;
  }

  private static ArrayList <Card> getCrib(){
    return crib;
  }

  //gets the index in playerList where the dealer is
  /**
  Returns the index in playerList where the dealer is or -1.
  @return the index in playerList where the dealer is or -1 if there is no dealer.
  */
  private static int getDealerIdx(){
    for (int i = 0; i < playerList.size(); i++){
      if (playerList.get(i).isDealer == true){
        return i;
      }
    }
    return -1;
  }



}
