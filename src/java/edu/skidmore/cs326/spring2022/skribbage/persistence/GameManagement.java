package edu.skidmore.cs326.spring2022.skribbage.persistence;


public interface GameManagement {

	public Game retrieveGame(Game whichGame);
	
	
	public boolean saveGame(Game currentGame);
	
}
