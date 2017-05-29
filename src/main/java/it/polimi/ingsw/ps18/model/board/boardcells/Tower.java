package it.polimi.ingsw.ps18.model.board.boardcells;

import java.util.ArrayList;
import java.util.List;

import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.personalBoard.FMember;


public interface Tower {
	
	public Cards insertFM(FMember pBoardFM, int floor);

	public void insertCards(List<Cards> turnCards);
	
}
