package it.polimi.ingsw.ps18.model.board.boardcells;

import it.polimi.ingsw.ps18.model.personalBoard.FMember;

/**
 * Defines a council cell.
 * When a FMember is placed, the player can choose a quick effect.
 * 
 * @author yazan-matar
 */
public class CouncilCell { 
	private FMember councilCellFM;
	
	
	
	public CouncilCell() {
		councilCellFM = null;
	}
	
	public boolean insertFM(FMember pBoardFM) {
		if(this.isEmpty()){
			this.councilCellFM = pBoardFM;
			return true;
		} return false;
		//privilegio gestito dal chiamante
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
	
	
	
	
	public String toString(int index) {
		StringBuilder builder = new StringBuilder();
		builder.append("-----------------\n");
		builder.append("Council cell number " + index + ":\n");
		
		if(councilCellFM != null){
			builder.append("Family Member in council cell number " + index + ":\n"
					+ "Player color: " + councilCellFM.getPlayercol() + "\n"
					+ "Family Member color: " + councilCellFM.getColor() + "\n"
					+ "Family Member value: " + councilCellFM.getValue() + "\n"
					);
		}
		else{
			builder.append("\nCouncil cell is empty!");
		}
		builder.append("-----------------\n");
		return builder.toString();
	}
	
	

	/**
	 * @return the councilCellFM
	 */
	public FMember getCouncilCellFM() {
		return councilCellFM;
	}

	/**
	 * @param councilCellFM the councilCellFM to set
	 */
	public void setCouncilCellFM(FMember councilCellFM) {
		this.councilCellFM = councilCellFM;
	}
	
	
}
