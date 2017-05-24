package it.polimi.ingsw.ps18.Model.Board.BoardCells;

import it.polimi.ingsw.ps18.Model.Cards.Cards;
import it.polimi.ingsw.ps18.Model.PBoard.FMember;

/**
 * Definition of tower cells
 * @author yaz
 *
 */

class Cell {
	Cards cellCard;
	FMember cellFM;
	int actionValue;
	
	
	public Cell (Cards gameCard, int actionValue){ // int actionValue is passed by the Tower class
		
		this.cellCard = gameCard;
		
		
		
		
	}
	
	// Method called by PBoard class. N.B: Controls are private
	
	public Cards insertFM(FMember pBoardFM/*int fMemberValue, */){  
		
		boolean cellStatus = this.controls(pBoardFM);
		if(cellStatus){
			this.cellFM = pBoardFM;
			/* The transfer of the card from the cell to the PBoard has to happen here or elsewhere?
			 * 1. Here: 
			 * Cards transferCard = cellCard;
			 * cellCard=null;
			 * return transferCard;
			 * 2. Elsewhere: 
			 * 
			 */
			
			return cellCard;
		}
		else{
			System.out.println("\nDEBUG");
			
		}
		
		
	}
	
	/**
	 * Controls about addictional payments (e.g 3 coins fee)
	 * bonuses (derived from the floor value)
	 * or family members values are made by the Tower class
	 * @param pBoardFM
	 * @return
	 */
	
	private boolean controls(FMember pBoardFM){
		if(cellFM==null){ 
			System.out.println("\nCell is clear!");
			this.cellFM = pBoardFM;  // Cell must be empty!
			//cellCard.cost: il pagamento lo si fa prima o dopo aver messo la carta sulla plancia?
			return true;
			
		}
		else {
			System.out.println("\nError: Cell occupied!");
			return false;
		}
		
	}
	
	

}
