package it.polimi.ingsw.ps18.model.gameLogic;

import it.polimi.ingsw.ps18.model.board.Board;
import it.polimi.ingsw.ps18.model.personalBoard.FMember;
import it.polimi.ingsw.ps18.model.personalBoard.PBoard;

public interface ActionChoice {
	
	/**
	 * Function that is going to be overriden in the class that implement it
	 * it's a prototype of a function that describe the action of the code
	 * related to the player's choice
	 * @param fam Family Member to put inside the board's cells
	 * @param board contains the various cells
	 * @param player the player that is doing the action, his value
	 *        will be modified
	 */
	public void act(FMember fam, Board board, PBoard player);

}
