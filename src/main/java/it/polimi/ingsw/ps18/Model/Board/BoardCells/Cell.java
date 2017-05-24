package it.polimi.ingsw.ps18.Model.Board.BoardCells;

import it.polimi.ingsw.ps18.Model.Cards.Cards;
import it.polimi.ingsw.ps18.Model.PBoard.FMember;

/**
 * Definition of tower cells
 * @author yaz
 *
 */

class Cell {
	private Cards cellCard;
	private FMember cellFM;
	private int actionValue = 1; // Il valore che serve ai FMember per posizionarsi in una cella
	private static int floor = 1; // segna il numero del piano per ogni cella creata nella torre
	
	
	public Cell (){
		this.cellCard = null;
		this.cellFM = null;
		floor++;
		this.actionValue = 1;
	}
	
	public Cell (Cards gameCard, FMember PBoardFM, int actionValue){ 
		// int actionValue is passed by the Tower class
		
		//Sistemo DOPO
		
		this.cellCard = gameCard;
		this.cellFM = null;
		floor++;
		this.actionValue = actionValue + 2;	
		
	}
	
	// Method called by PBoard class (OR MAYBE BY Tower class). N.B: Controls are private
	
	public Cards insertFM(FMember pBoardFM){  /*int fMemberValue ? Qui oppure nei controlli della torre? */
		Cards transferCard;
		boolean cellStatus = this.spaceCheck(pBoardFM);
		if(cellStatus){
			this.cellFM = pBoardFM; //Adds FM
			 //The transfer of the card from the cell to the PBoard has to happen here or elsewhere?
			
			transferCard = cellCard;
			this.cellCard = null;
			 
			 
		}
		else{
			System.out.println("\nInsertion failed: card not taken");
			this.cellFM = null;
			transferCard = null;
		}
		
		return transferCard;
		
		
	}
	
	
	
	/*
	 * Controls about addictional payments (e.g 3 coins fee)
	 * bonuses (derived from the floor value)
	 * or family members values are made by the Tower class
	 * 
	 */
	
	private boolean spaceCheck(FMember pBoardFM){ //REMINDER: MAYBE PRIVATE IS NOT THE BEST CHOICE
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
