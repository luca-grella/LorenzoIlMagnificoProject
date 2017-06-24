package it.polimi.ingsw.ps18.model.board.boardcells;

import java.util.List;

import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.personalboard.FMember;

// TODO: Auto-generated Javadoc
/**
 * Interface of a generic tower. <br>
 * In the base game, towers have the same attributes, but a specific tower for a
 * future implementation might be added. <br>
 *
 * @author yazan-matar
 * @see {@link }
 */
public interface Tower {
	
	/**
	 * Insert FM.
	 *
	 * @param pBoardFM
	 *            the board FM
	 * @param floor
	 *            the floor
	 * @return the cards
	 */
	public Cards insertFM(FMember pBoardFM, int floor);

	/**
	 * Insert cards.
	 *
	 * @param turnCards
	 *            the turn cards
	 * @param period
	 *            the period
	 */
	public void insertCards(List<Cards> turnCards, int period);
	
	/**
	 * To string.
	 *
	 * @param index
	 *            the index
	 * @return the string
	 */
	public String toString(int index);
	
	/**
	 * Gets the tower cells.
	 *
	 * @return the tower cells
	 */
	public List<Cell> getTowerCells();
	
}
