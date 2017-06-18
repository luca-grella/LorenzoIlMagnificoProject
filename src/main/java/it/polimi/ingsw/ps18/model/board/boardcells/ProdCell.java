package it.polimi.ingsw.ps18.model.board.boardcells;

import it.polimi.ingsw.ps18.model.gamelogic.GeneralParameters;
import it.polimi.ingsw.ps18.model.personalboard.FMember;

/**
 * Defines a production cell. <br>
 * When a FMember is placed, this cell activates 
 * a set of permanent effects if conditions are fulfilled.
 * 
 * @see
 * {@link it.polimi.ingsw.ps18.model.effect.prodEffect.HashMapPE}
 * 
 * @author yazan-matar
 */

public class ProdCell {
	private FMember prodCellFM;
	private int prodCellValue;
	private int malus = 0;

	public ProdCell(int malus) {
		prodCellFM = null;
		prodCellValue = GeneralParameters.baseValueProdCells;
		this.malus = malus;
	}

	
	public boolean insertFM(FMember pBoardFM) {
		if(this.isEmptyPC()){
			if(pBoardFM.getValue() >= prodCellValue){
				this.prodCellFM = pBoardFM;
				return true;
				//Production Effects gestiti dal chiamante
			}return false;
		}return false;
	}
	
	public boolean isEmptyPC() {
		if(this.prodCellFM==null){ 
			return true;	
		}
		else {
			return false;
		}
	}
	public boolean isLegalPC(FMember pBoardFM){
		if(pBoardFM.getValue() >= this.getProdCellValue()){
			return true;
		}
		return false;
	}
	
	
	
	public String toString(int index) {
		StringBuilder builder = new StringBuilder();
		builder.append("-----------------\n");
		builder.append("Production cell number " + index + ":\n");
		builder.append("Minimum value to access this cell: " + prodCellValue);
		builder.append("\nAction Malus from this cell: " + malus);
		
		if(prodCellFM != null){
			builder.append("Family Member in production cell number " + index + ":\n"
					+ "\tPlayer color: " + prodCellFM.getPlayercol() + "\n"
					+ "\tFamily Member color: " + prodCellFM.getColor() + "\n"
					+ "\tFamily Member value: " + prodCellFM.getValue() + "\n"
					);
		}
		else{
			builder.append("\nProduction cell is empty!");
		}
		builder.append("-----------------\n");
		return builder.toString();
	}


	/**
	 * @return the prodCellFM
	 */
	public FMember getProdCellFM() {
		return prodCellFM;
	}


	/**
	 * @param prodCellFM the prodCellFM to set
	 */
	public void setProdCellFM(FMember prodCellFM) {
		this.prodCellFM = prodCellFM;
	}


	/**
	 * @return the prodCellValue
	 */
	public int getProdCellValue() {
		return prodCellValue;
	}


	/**
	 * @param prodCellValue the prodCellValue to set
	 */
	public void setProdCellValue(int prodCellValue) {
		this.prodCellValue = prodCellValue;
	}


	/**
	 * @return the malus
	 */
	public int getMalus() {
		return malus;
	}


	/**
	 * @param malus the malus to set
	 */
	public void setMalus(int malus) {
		this.malus = malus;
	}
	
	
	
	
}
