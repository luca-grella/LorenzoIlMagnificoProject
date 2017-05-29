package it.polimi.ingsw.ps18.model.board.boardcells;

import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.personalBoard.FMember;

/**
 * Defines a Tower cell, which contains a Cards object. <br>
 * 
 * @see
 * {@link it.polimi.ingsw.ps18.model.cards.Cards}
 */

class Cell { 
	private Cards cellCard;
	private FMember cellFM;
	
	public Cell() {
		cellCard = null;
		cellFM = null;
	}
	
	
	public Cards getCellCard() {
		return cellCard;
	}

	public void setCellCard(Cards cellCard) {
		this.cellCard = cellCard;
	}

	public FMember getCellFM() {
		return cellFM;
	}

	public void setCellFM(FMember cellFM) {
		this.cellFM = cellFM;
	}



	/**
	 * Places a FMember from PBoard to Cell
	 * @param pBoardFM
	 * @return card from Cell to PBoard
	 */
	
	public Cards insertFM(FMember pBoardFM) { 
		if(this.isEmpty()){
			this.cellFM = pBoardFM; //Adds FM
		}
		return this.cellCard;
	}
	
	/**
	 * Checks Cell state (Empty/Full)
	 * @return a boolean state
	 */
	
	private boolean isEmpty() {
		if(this.cellFM==null){ 
			System.out.println("\nCell is clear!");
			return true;	
		}
		else {
			System.out.println("\nError: Cell occupied!");
			return false;
		}
	}
	
	/**
	 * Places a card in Cell
	 * @param card
	 */
	
	public void insertCard(Cards card) {
		this.cellCard = card;
	}
	
}
