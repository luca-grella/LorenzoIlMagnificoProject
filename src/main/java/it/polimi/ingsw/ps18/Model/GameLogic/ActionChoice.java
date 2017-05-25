package it.polimi.ingsw.ps18.Model.GameLogic;

import it.polimi.ingsw.ps18.Model.Board.Board;
import it.polimi.ingsw.ps18.Model.PBoard.FMember;
import it.polimi.ingsw.ps18.Model.PBoard.PBoard;

public interface ActionChoice {
	
	public void act(FMember fam, Board board, PBoard player);

}
