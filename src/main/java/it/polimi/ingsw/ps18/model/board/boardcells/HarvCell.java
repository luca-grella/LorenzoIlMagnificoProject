package it.polimi.ingsw.ps18.model.board.boardcells;

import it.polimi.ingsw.ps18.model.gameLogic.GeneralParameters;
import it.polimi.ingsw.ps18.model.personalBoard.FMember;

/**
 * Defines a harvest cell. <br>
 * When a FMember is placed, this cell activates 
 * a set of permanent effects if conditions are fulfilled.
 * 
 * @see
 * {@link it.polimi.ingsw.ps18.model.effect.harvestEffect.HashMapHE}
 */

public class HarvCell {
	private FMember harvCellFM;
	private int harvCellValue;

	
	
	public HarvCell() {
		harvCellFM = null;
		harvCellValue = GeneralParameters.valueHarvCells;
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
