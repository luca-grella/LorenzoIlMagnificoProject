package it.polimi.ingsw.ps18.model.board.boardcells;

import it.polimi.ingsw.ps18.model.gamelogic.GeneralParameters;
import it.polimi.ingsw.ps18.model.personalboard.FMember;

// TODO: Auto-generated Javadoc
/**
 * Defines a harvest cell. <br>
 * When a family member is placed, this cell activates a set of permanent
 * effects if conditions are fulfilled.
 *
 * @author yazan-matar
 * @see {@link it.polimi.ingsw.ps18.model.effect.harvestEffect.HashMapHE}
 */

public class HarvCell {
	
	/**
	 * The harv cell FM.
	 */
	private FMember harvCellFM;
	
	/**
	 * The harv cell value.
	 */
	private int harvCellValue;
	
	/**
	 * The malus.
	 */
	private int malus = 0;

	
	
	/**
	 * Instantiates a new harv cell.
	 *
	 * @param malus
	 *            the malus
	 */
	public HarvCell(int malus) {
		harvCellFM = null;
		this.malus = malus;
		harvCellValue = GeneralParameters.baseValueHarvCells - malus;  
		//TODO: verificare se si intede un malus positivo da sottrarre o uno negativo da aggiungere
		
	}


	/**
	 * Insert FM.
	 *
	 * @param pBoardFM
	 *            the board FM
	 * @return true, if successful
	 */
	public boolean insertFM(FMember pBoardFM) {
		if(this.isEmptyHC()){	
			if(pBoardFM.getValue() >= harvCellValue){
				this.harvCellFM = pBoardFM;
				return true;
				// Harvest Effects gestiti dal chiamante
			}return false;
		}return false;
	}
	
	/**
	 * Checks if is empty HC.
	 *
	 * @return true, if is empty HC
	 */
	public boolean isEmptyHC() {
		if(this.harvCellFM==null){ 
			return true;	
		}
		else {
			return false;
		}
	}
	
	/**
	 * Checks if is legal HC.
	 *
	 * @param pBoardFM
	 *            the board FM
	 * @return true, if is legal HC
	 */
	public boolean isLegalHC(FMember pBoardFM){
		if(this.isEmptyHC()){
			if(pBoardFM.getValue() >= this.getHarvCellValue()){
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
	 * Gets the harv cell FM.
	 *
	 * @return the harvCellFM
	 */
	public FMember getHarvCellFM() {
		return harvCellFM;
	}


	/**
	 * Sets the harv cell FM.
	 *
	 * @param harvCellFM
	 *            the harvCellFM to set
	 */
	public void setHarvCellFM(FMember harvCellFM) {
		this.harvCellFM = harvCellFM;
	}


	/**
	 * Gets the harv cell value.
	 *
	 * @return the harvCellValue
	 */
	public int getHarvCellValue() {
		return harvCellValue;
	}


	/**
	 * Sets the harv cell value.
	 *
	 * @param harvCellValue
	 *            the harvCellValue to set
	 */
	public void setHarvCellValue(int harvCellValue) {
		this.harvCellValue = harvCellValue;
	}


	/**
	 * Sets the malus.
	 *
	 * @param malus
	 *            the malus to set
	 */
	public void setMalus(int malus) {
		this.malus = malus;
	}


	/**
	 * Gets the malus.
	 *
	 * @return the malus
	 */
	public int getMalus() {
		return malus;
	}
	
	
	
	
}
