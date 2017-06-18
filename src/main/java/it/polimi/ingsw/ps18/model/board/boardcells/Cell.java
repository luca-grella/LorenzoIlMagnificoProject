package it.polimi.ingsw.ps18.model.board.boardcells;

import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.personalboard.FMember;

/**
 * Defines a Tower cell, which contains a Cards object. <br>
 * 
 * @see
 * {@link it.polimi.ingsw.ps18.model.cards.Cards}
 * 
 * @author yazan-matar
 */

public class Cell { 
	private Cards cellCard;
	private FMember cellFM;
	private int cellValue;
	
	public Cell() {
		cellCard = null;
		cellFM = null;
		cellValue =  3;     //TODO: Settare in modo diverso, magari su GeneralParameters
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
			this.cellFM = pBoardFM;
			return this.cellCard;
	}
	
	/**
	 * Checks Cell state (Empty/Full)
	 * @return a boolean state
	 */
	
	public boolean isEmptyTC() {
		if(this.cellFM==null){ 
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isLegalTC(FMember pBoardFM) {
		if(pBoardFM.getValue() >= this.getCellValue()){
			if(this.cellCard != null){
				return true;
			}
			else
				return false;
		}
		return false;
				
	}
	
	public String toString(int index){
		StringBuilder builder = new StringBuilder();
		builder.append("-----------------\n");
		builder.append("Tower cell number " + index + ":\n");
		
		if(cellCard != null){
			builder.append("Cards in tower cell number " + index + ":\n");
			builder.append(this.cellCard.toString());
		}
		else{
			builder.append("Card already taken!");
		}
		if(cellFM != null){
			builder.append("Family Member in tower cell number " + index + ":\n"
					+ "\tPlayer color: " + cellFM.getPlayercol() + "\n"
					+ "\tFamily Member color: " + cellFM.getColor() + "\n"
					+ "\tFamily Member value: " + cellFM.getValue() + "\n"
					);
		}
		else{
			builder.append("\nTower cell is empty!");
		}
		builder.append("\n-----------------\n");
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

	/**
	 * @return the value
	 */
	public int getCellValue() {
		return cellValue;
	}

	/**
	 * @param value the value to set
	 */
	public void setCellValue(int value) {
		this.cellValue = value;
	}
	
	
	
	
	
}
