package it.polimi.ingsw.ps18.Model.Board.BoardCells;

import it.polimi.ingsw.ps18.Model.Cards.Cards;
import it.polimi.ingsw.ps18.Model.PBoard.FMember;

/**
 * Definition of tower cells
 * @author yaz
 *
 */

class Cell { //piano indicato come posizione nell'arraylist
	private Cards cellCard;
	private FMember cellFM;
	private int actionValue = 1; // Il valore che serve ai FMember per posizionarsi in una cella
	
	
	// Method called by PBoard class (OR MAYBE BY Tower class). N.B: Controls are private
	
	public Cards insertFM(FMember pBoardFM){  /*int fMemberValue ? Qui oppure nei controlli della torre? */
		//Cards transferCard;
		if(this.spaceCheck()){
			this.cellFM = pBoardFM; //Adds FM
			 //The transfer of the card from the cell to the PBoard has to happen here or elsewhere?
//			
//			transferCard = cellCard;
//			this.cellCard = null;
			 
			 
		}
		return this.cellCard;
		
		
	}
	
	
	
	/*
	 * Controls about addictional payments (e.g 3 coins fee)
	 * bonuses (derived from the floor value)
	 * or family members values are made by the Tower class
	 * 
	 */
	
	private boolean spaceCheck(){ //REMINDER: MAYBE PRIVATE IS NOT THE BEST CHOICE
		if(this.cellFM==null){ 
			System.out.println("\nCell is clear!");
			return true;
			
		}
		else {
			System.out.println("\nError: Cell occupied!");
			return false;
		}
		
	}
	
	public void insertCard(Cards card){
		this.cellCard = card;
	}
	
	

}
