package it.polimi.ingsw.ps18.model.board.boardcells;

import java.util.List;

import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.personalBoard.FMember;

/**
 * Interface of a generic tower. <br>
 * In the base game, towers have the same attributes, 
 * but a specific tower for a future implementation might be added. <br>
 * 
 * @see
 * {@link }
 * @author yazan-matar
 *
 */
public interface Tower {
	
	public Cards insertFM(FMember pBoardFM, int floor);

	public void insertCards(List<Cards> turnCards, int period);
	
}
