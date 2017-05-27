package it.polimi.ingsw.ps18.model.gameLogic;

import it.polimi.ingsw.ps18.model.board.Board;
import it.polimi.ingsw.ps18.model.personalBoard.FMember;
import it.polimi.ingsw.ps18.model.personalBoard.PBoard;

public interface ActionChoice {
	
	public void act(FMember fam, Board board, PBoard player);

}
