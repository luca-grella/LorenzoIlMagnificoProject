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
	private List<Cell> towerCells = new ArrayList<>(GeneralParameters.numberofCells);
	
	
	
	public ConcreteTower () {
		for(int count=0; count<GeneralParameters.numberofCells; count++){
		      this.towerCells.add(count, new Cell());
		}
	}
	
	/**
	 * Uses the Cell method insertCard, that places a card in a cell
	 * and iterates it for all the cells in a tower
	 */
	public void insertCards (List<Cards> Cards) {
		//TODO: riscrivere insertCards. deve togliere dalla lista quelle usate e posizionare solo quelle dell'era giusta
    	for(int i=0; i<GeneralParameters.numberofCells; i++){
			Cell towerCell = this.towerCells.get(i);
			Cards cellCard = Cards.get(i);
			towerCell.insertCard(cellCard);
		}
	}
	
	
	/**
	 * Uses the Cell method insertFM, that places a FMember in a cell
	 * after selecting the cell floor in a tower
	 * @param pBoardFM indicates the FM that is going to be used in the action
	 */
	
	public Cards insertFM(FMember pBoardFM, int floor) {
		
		Cell towerCell = this.towerCells.get(floor);
		return towerCell.insertFM(pBoardFM);
		
	}

	/**
	 * @return the towerCells
	 */
	public List<Cell> getTowerCells() {
		return towerCells;
	}

	/**
	 * @param towerCells the towerCells to set
	 */
	public void setTowerCells(List<Cell> towerCells) {
		this.towerCells = towerCells;
	}
	
	//controlli

}
