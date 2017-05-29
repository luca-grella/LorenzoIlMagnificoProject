package it.polimi.ingsw.ps18.model.board.boardcells;

import it.polimi.ingsw.ps18.model.personalBoard.FMember;

/**
 * Defines a council cell.
 * When a FMember is placed, the player can choose a quick effect.
 * 
 */
public class CouncilCell { 
	private FMember councilCellFM;
	
	public CouncilCell() {
		councilCellFM = null;
	}
	
	
	public FMember getCouncilCellFM() {
		return councilCellFM;
	}

	public void setCouncilCellFM(FMember councilCellFM) {
		this.councilCellFM = councilCellFM;
	}

	
	public void insertFM(FMember pBoardFM) {
		
		if(this.isEmpty())
			this.councilCellFM = pBoardFM;
		
		//Chosen quickEff activation
	}
	
	/**
	 * Checks the cell's state (Empty/Full)
	 * @return a boolean state
	 */
	
	private boolean isEmpty() {
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
