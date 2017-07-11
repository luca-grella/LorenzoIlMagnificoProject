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
	
	/**
	 * The council cell FM.
	 */
	private FMember councilCellFM;
	
	/**
	 * The council cell value.
	 */
	private int councilCellValue;
	
	/**
	 * Instantiates a new council cell.
	 *
	 * @param pBoardFM
	 *            the board FM
	 */
	public CouncilCell(FMember pBoardFM) {
			this.councilCellFM = pBoardFM;
			this.councilCellValue = GeneralParameters.baseValueCouncilCells;
	}
	
	/**
	 * Instantiates a new council cell.
	 */
	public CouncilCell(){
		this.councilCellValue = GeneralParameters.baseValueCouncilCells;
	}
	
	/**
	 * Checks the cell's state (Empty/Full).
	 *
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
	
	/**
	 * Checks if is legal CC.
	 *
	 * @param actionValue the action value
	 * @return true, if is legal CC
	 */
	public boolean isLegalCC(int actionValue) {
		if(this.isEmptyCC()){
			if(actionValue >= this.getCouncilCellValue()){
				return true;
			}
		}
		return false;
	}
	
	
	
	/**
	 * To string.
	 *
	 * @param index
	 *            the index
	 * @return the string
	 */
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
	 * Gets the council cell FM.
	 *
	 * @return the councilCellFM
	 */
	public FMember getCouncilCellFM() {
		return councilCellFM;
	}

	/**
	 * Sets the council cell FM.
	 *
	 * @param councilCellFM
	 *            the councilCellFM to set
	 */
	public void setCouncilCellFM(FMember councilCellFM) {
		this.councilCellFM = councilCellFM;
	}

	/**
	 * Gets the council cell value.
	 *
	 * @return the councilCellValue
	 */
	public int getCouncilCellValue() {
		return councilCellValue;
	}

	/**
	 * Sets the council cell value.
	 *
	 * @param councilCellValue
	 *            the councilCellValue to set
	 */
	public void setCouncilCellValue(int councilCellValue) {
		this.councilCellValue = councilCellValue;
	}
	
	
}
