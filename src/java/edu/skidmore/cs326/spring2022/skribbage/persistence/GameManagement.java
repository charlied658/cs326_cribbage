package edu.skidmore.cs326.spring2022.skribbage.persistence;

import edu.skidmore.cs326.spring2022.skribbage.common.User;
import edu.skidmore.cs326.spring2022.skribbage.logic.Game;

public interface GameManagement {

	public Game retrieveGame(User userName, Game whichGame);
	
	
	public boolean saveGame(User userName, Game currentGame);
	
}
