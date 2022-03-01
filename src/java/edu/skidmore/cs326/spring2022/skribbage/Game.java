public class Game{

  Deck theDeck;

  ArrayList <Player> playerList = new ArrayList <Player> ();

  public Game(int numPlayers){
    //initialize theDeck
    this.theDeck = new Deck();

    //initialize list of players, given umPlayers
    initPlayers(numPlayers);

  }

  public void initPlayers(int numPlayers){

    for (int i = 0; i < numPlayers; i++){
      Player p = new Player();
      playerList.add(p);
    }

  }//end of initPlayers

  //write method for count hand phase

  //write method for deal phase

  //write method for pegging play



}
