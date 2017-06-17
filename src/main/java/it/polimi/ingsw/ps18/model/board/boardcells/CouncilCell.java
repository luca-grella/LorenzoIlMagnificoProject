package it.polimi.ingsw.ps18.model.board.boardcells;

import it.polimi.ingsw.ps18.model.gamelogic.GeneralParameters;
import it.polimi.ingsw.ps18.model.personalboard.FMember;

/**
 * Defines a council cell.
 * When a FMember is placed, the player can choose a quick effect.
 * 
 * @author yazan-matar
 */
public class CouncilCell { 
	private FMember councilCellFM;
	private int councilCellValue;
	
	public CouncilCell(FMember pBoardFM) {
			this.councilCellFM = pBoardFM;
			this.councilCellValue = GeneralParameters.baseValueCouncilCells;
	}
	
	/**
	 * Checks the cell's state (Empty/Full)
	 * @return a boolean state
	 */
	
	public boolean isEmptyCC() {
		if(this.councilCellFM == null){
			return true;
		}
		else{
			return false;
		}	
	}
	public boolean isLegalCC(FMember pBoardFM) {
		if(pBoardFM.getValue() >= this.getCouncilCellValue()){
			return true;
		}
		return false;
	}
	
	
	
	public String toString(int index) {
		StringBuilder builder = new StringBuilder();
		builder.append("-----------------\n");
		builder.append("Council cell number " + index + ":\n");
		
		if(councilCellFM != null){
			builder.append("Family Member in council cell number " + index + ":\n"
					+ "    Player color: " + councilCellFM.getPlayercol() + "\n"
					+ "    Family Member color: " + councilCellFM.getColor() + "\n"
					+ "    Family Member value: " + councilCellFM.getValue() + "\n"
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

	/**
	 * @return the councilCellValue
	 */
	public int getCouncilCellValue() {
		return councilCellValue;
	}

	/**
	 * @param councilCellValue the councilCellValue to set
	 */
	public void setCouncilCellValue(int councilCellValue) {
		this.councilCellValue = councilCellValue;
	}
	
	
}
