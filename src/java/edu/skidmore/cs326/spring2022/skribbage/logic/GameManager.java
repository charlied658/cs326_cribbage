package edu.skidmore.cs326.spring2022.skribbage.logic;

import java.util.ArrayList;
//import org.apache.log4j.Logger;

/**
 * GameManager contains methods to manipulate the data in Game. It includes
 * methods to initialize a list of players, add a player to the player list,
 * add a value to the pegging total, add a card to the pone's pegging cards,
 * add a card to the dealer's pegging cards, initialize the pegging total, and
 * determines the index in the player list where the dealer is. A key
 * assumption for this class is that there are only two players.
 *
 * @author Michael Shriner
 */
public class GameManager implements GameManagerInterface {

    /**
    * A Game to access the data this class is designed to manipulate.
    */
    private Game g;

    /**
    * GameManager constructor that initializes a Game.
    *
    * @param game is the Game to set the class Game to.
    */
    public GameManager(Game game) {
        //g = new Game(numPlayers);
        this.g = game;
    }

    // /**
    // * GameManager constructor that initializes a Game using the
    // * empty constructor in Game.
    // */
    // public GameManager(Game g) {
    //     g = new Game();
    // }

    /**
    * Returns the Game used for this class.
    * @return the Game used for this class.
    */
    public Game getGame() {
        return g;
    }

    /**
    * Sets the Game used for this class.
    * @param game is a Game object.
    */
    public void setGame(Game game) {
        g = game;
    }

    /**
     * Initializes the ArrayList of Player objects given the
     * number of players for this game. However, there is
     * the assumption, for now, that the number of players
     * is 2.
     *
     * @param numPlayers is the number of players.
     * @param playerList is the list of players.
     */
    public void initPlayers(int numPlayers, ArrayList<Player> playerList) {

        for (int i = 0; i < numPlayers; i++) {
            addPlayer(new Player(), playerList);
        }
    }

    /**
    * Adds a player to the player list.
    *
    * @param p is the player to add to the player list.
    * @param playerList is the list of players.
    */
    public void addPlayer(Player p, ArrayList<Player> playerList) {
        playerList.add(p);
    }

    /**
    * Takes in the amount to add to the pegging total
    * and adds it to the pegging total if the amount
    * to add plus the current pegging total does not exceed 31.
    * If it exceeds 31, this method returns false.
    * Otherwise, it returns true.
    *
    * @param amountToAdd is the amount of points to add
    * to the pegging total.
    * @return true iff amountToAdd + the pegging total <= 31.
    */
    public boolean addToPeggingTotal(int amountToAdd) {

        int peggingTotal = g.getPeggingTotal();

        if (amountToAdd + peggingTotal > 31) {
            return false;
        } else {
            peggingTotal += amountToAdd;
            g.setPeggingTotal(peggingTotal);
            return true;
        }
    }

     /**
      * Add the parameter Card to the pone's pegging cards.
      *
      * @param c is the Card to add to the list of the pone's pegging cards.
      */
    public void addPonePeggingCard(Card c) {
        ArrayList<Card> ponePegCards = g.getPonePeggingCards();
        ponePegCards.add(c);
        g.setPonePeggingCards(ponePegCards);
    }

     /**
      * Add the parameter Card to the dealer's pegging cards.
      *
      * @param c is the Card to add to the list of the dealer's
      * pegging cards.
      */
    public void addDealerPeggingCard(Card c) {
        ArrayList<Card> dealerPegCards = g.getDealerPeggingCards();
        dealerPegCards.add(c);
        g.setDealerPeggingCards(dealerPegCards);
    }

    /**
    * Initializes the pegging total to 0.
    */
    public void initPeggingTotal() {
        int peggingTotal = g.getPeggingTotal();
        peggingTotal = 0;
        g.setPeggingTotal(peggingTotal);
    }

     /**
      * Returns the index in playerList where the dealer is or
      * -1 if there is no dealer.
      * @param playerList is the list of players.
      * @return the index in playerList where the dealer is or
      * -1 if there is no dealer.
      */
    public int getDealerIdx(ArrayList<Player> playerList) {
        for (int i = 0; i < playerList.size(); i++) {
            if (playerList.get(i).isDealer()) {
                return i;
            }
        }
        return -1;
    }


}
