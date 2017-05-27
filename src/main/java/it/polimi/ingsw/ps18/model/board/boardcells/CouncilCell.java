package it.polimi.ingsw.ps18.model.board.boardcells;

import it.polimi.ingsw.ps18.model.personalBoard.FMember;

public class CouncilCell { 
	private FMember councilCellFM;
	
	
	public void insertFM(FMember pBoardFM){
		
		if(this.isEmpty())
			this.councilCellFM = pBoardFM;
		
		//Chosen quickEff activation
	}
	
	
	private boolean isEmpty(){
		if(this.councilCellFM == null){
			System.out.println("\nCouncil cell is empty!");
			return true;
		}
		else{
			System.out.println("Error: Council cell occupied!");
			return false;
		}
		
	}
	
	

}
