package it.polimi.ingsw.ps18.model.board.boardcells;

import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.personalBoard.FMember;

/**
 * Defines a Tower cell, which contains a Cards object. <br>
 * 
 * @see
 * {@link it.polimi.ingsw.ps18.model.cards.Cards}
 * 
 * @author yazan-matar
 */

class Cell { 
	private Cards cellCard;
	private FMember cellFM;
	
	public Cell() {
		cellCard = null;
		cellFM = null;
	}
	
	/**
	 * Places a card in Cell
	 * @param card
	 */
	
	public void insertCard(Cards card) {
		this.cellCard = card;
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
	
	public String toString(int index){
		StringBuilder builder = new StringBuilder();
		builder.append("-----------------\n");
		builder.append("Tower cell number " + index + ":\n");
		
		if(cellCard != null){
			builder.append("Cards in tower cell number " + index + ":\n"
					+ "Name: " + cellCard.getName() + "\n"
					+ "ID: " + cellCard.getID() + "\n"
					+ "Color: " + cellCard.getColor() + "\n"
					+ "Period: " + cellCard.getPeriod() + "\n"
					);
		}
		else{
			builder.append("Card already taken!");
		}
		if(cellFM != null){
			builder.append("Family Member in tower cell number " + index + ":\n"
					+ "Player color: " + cellFM.getPlayercol() + "\n"
					+ "Family Member color: " + cellFM.getColor() + "\n"
					+ "Family Member value: " + cellFM.getValue() + "\n"
					);
		}
		else{
			builder.append("\nTower cell is empty!");
		}
		builder.append("-----------------\n");
		return builder.toString();
		
	}
	

	/**
	 * @return the cellCard
	 */
	public Cards getCellCard() {
		return cellCard;
	}

	/**
	 * @param cellCard the cellCard to set
	 */
	public void setCellCard(Cards cellCard) {
		this.cellCard = cellCard;
	}

	/**
	 * @return the cellFM
	 */
	public FMember getCellFM() {
		return cellFM;
	}

	/**
	 * @param cellFM the cellFM to set
	 */
	public void setCellFM(FMember cellFM) {
		this.cellFM = cellFM;
	}
	
	
	
	
	
}
