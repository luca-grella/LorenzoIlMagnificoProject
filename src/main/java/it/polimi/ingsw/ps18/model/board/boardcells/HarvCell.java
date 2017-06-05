package it.polimi.ingsw.ps18.model.board.boardcells;

import it.polimi.ingsw.ps18.model.gamelogic.GeneralParameters;
import it.polimi.ingsw.ps18.model.personalboard.FMember;

/**
 * Defines a harvest cell. <br>
 * When a family member is placed, this cell activates 
 * a set of permanent effects if conditions are fulfilled.
 * 
 * @see
 * {@link it.polimi.ingsw.ps18.model.effect.harvestEffect.HashMapHE}
 * 
 * @author yazan-matar
 */

public class HarvCell {
	private FMember harvCellFM;
	private int harvCellValue;

	
	
	public HarvCell() {
		harvCellFM = null;
		harvCellValue = GeneralParameters.baseValueHarvCells;
	}


	public boolean insertFM(FMember pBoardFM, int valueFM) {
		if(this.isEmpty()){	
			if(valueFM >= harvCellValue){
				this.harvCellFM = pBoardFM;
				return true;
				// Harvest Effects gestiti dal chaimante
			}return false;
		}return false;
	}
	
	private boolean isEmpty() {
		if(this.harvCellFM==null){ 
			System.out.println("\nHarvest cell is clear!");
			return true;	
		}
		else {
			System.out.println("\nError: Harvest cell occupied!");
			return false;
		}
	}
	
	
	
	public String toString(int index) {
		StringBuilder builder = new StringBuilder();
		builder.append("-----------------\n");
		builder.append("Harvest cell number " + index + ":\n");
		builder.append("Malus value in position " + index + ": " + harvCellValue); //Must be -3 malus if position > 0
		
		if(harvCellFM != null){
			builder.append("Family Member in harvest cell number " + index + ":\n"
					+ "Player color: " + harvCellFM.getPlayercol() + "\n"
					+ "Family Member color: " + harvCellFM.getColor() + "\n"
					+ "Family Member value: " + harvCellFM.getValue() + "\n"
					);
		}
		else{
			builder.append("\nHarvest cell is empty!");
		}
		
		builder.append("-----------------\n");
		return builder.toString();
	}


	/**
	 * @return the harvCellFM
	 */
	public FMember getHarvCellFM() {
		return harvCellFM;
	}


	/**
	 * @param harvCellFM the harvCellFM to set
	 */
	public void setHarvCellFM(FMember harvCellFM) {
		this.harvCellFM = harvCellFM;
	}


	/**
	 * @return the harvCellValue
	 */
	public int getHarvCellValue() {
		return harvCellValue;
	}


	/**
	 * @param harvCellValue the harvCellValue to set
	 */
	public void setHarvCellValue(int harvCellValue) {
		this.harvCellValue = harvCellValue;
	}
	
	
}
