package it.polimi.ingsw.ps18.Model.Board.BoardCells;

import java.util.ArrayList;
import java.util.List;

import it.polimi.ingsw.ps18.Model.Cards.Cards;
import it.polimi.ingsw.ps18.Model.PBoard.FMember;

public interface Tower {
	
	public Cards insertFM(FMember pBoardFM, int floor);

	public void insertCards(List<Cards> turncards);
		
	//public void controls(); //Choose other name
		
		
	
	
	

}
