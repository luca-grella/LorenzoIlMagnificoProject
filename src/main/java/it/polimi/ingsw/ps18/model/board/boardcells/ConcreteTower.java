package it.polimi.ingsw.ps18.model.board.boardcells;

import java.util.ArrayList;

import java.util.List;

import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.gameLogic.GeneralParameters;
import it.polimi.ingsw.ps18.model.personalBoard.FMember;

/**
 * Defines a Tower composed by Cell objects. <br>
 * Inherits and overrides methods from the Tower Interface.
 * @see
 * {@link it.polimi.ingsw.ps18.model.board.boardcells.Cell} 
 * @see
 * {@link it.polimi.ingsw.ps18.model.board.boardcells.Tower}
 */

public class ConcreteTower implements Tower {
	
	private List<Cell> towerCells = new ArrayList<>();
	
	public ConcreteTower () {
		for(int count=0; count<GeneralParameters.numberofCells; count++){
		      this.towerCells.add(count, new Cell());
		}
	}
	
	
	
	public List<Cell> getTowerCells() {
		return towerCells;
	}

	public void setTowerCells(List<Cell> towerCells) {
		this.towerCells = towerCells;
	}
	
	
	/**
	 * Uses the Cell method insertFM, that places a FMember in a cell
	 * after selecting the cell floor in a tower
	 */
	
	public Cards insertFM(FMember pBoardFM, int floor) {
		
		Cell towerCell = this.towerCells.get(floor);
		Cards  cellCard = towerCell.insertFM(pBoardFM);
		return cellCard;
		
	}
	/**
	 * Uses the Cell method insertCard, that places a card in a cell
	 * and iterates it for all the cells in a tower
	 */
	public void insertCards (List<Cards> turnCards) {
		
		for(int i=0; i<2; i++){ //Change number of iterations
			Cell towerCell = this.towerCells.get(i);
			Cards cellCard = turnCards.get(i);
			towerCell.insertCard(cellCard);
		}
	}

}
