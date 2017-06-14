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
	private int malus = 0;

	
	
	public HarvCell(int malus) {
		harvCellFM = null;
		harvCellValue = GeneralParameters.baseValueHarvCells;
		this.malus = malus;
	}


	public boolean insertFM(FMember pBoardFM) {
		if(this.isEmpty()){	
			if(pBoardFM.getValue() >= harvCellValue){
				this.harvCellFM = pBoardFM;
				return true;
				// Harvest Effects gestiti dal chaimante
			}return false;
		}return false;
	}
	
	private boolean isEmpty() {
		if(this.harvCellFM==null){ 
			return true;	
		}
		else {
			return false;
		}
	}
	
	
	
	public String toString(int index) {
		StringBuilder builder = new StringBuilder();
		builder.append("-----------------\n");
		builder.append("Harvest cell number " + index + ":\n");
		builder.append("Minimum value to access this cell: " + harvCellValue);
		builder.append("\nAction Malus from this cell: " + malus);
		
		if(harvCellFM != null){
			builder.append("\nFamily Member in harvest cell number " + index + ":\n"
					+ "\tPlayer color: " + harvCellFM.getPlayercol() + "\n"
					+ "\tFamily Member color: " + harvCellFM.getColor() + "\n"
					+ "\tFamily Member value: " + harvCellFM.getValue() + "\n"
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


	/**
	 * @param malus the malus to set
	 */
	public void setMalus(int malus) {
		this.malus = malus;
	}


	/**
	 * @return the malus
	 */
	public int getMalus() {
		return malus;
	}
	
	
	
	
}
