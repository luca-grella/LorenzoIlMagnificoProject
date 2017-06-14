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

	public ProdCell() {
		prodCellFM = null;
		prodCellValue = GeneralParameters.baseValueProdCells;
	}

	
	public boolean insertFM(FMember pBoardFM, int valueFM) {
		if(this.isEmpty()){
			if(valueFM >= prodCellValue){
				this.prodCellFM = pBoardFM;
				return true;
				//Production Effects gestiti dal chiamante
			}return false;
		}return false;
	}
	
	private boolean isEmpty() {
		if(this.prodCellFM==null){ 
			System.out.println("\nProduction cell is clear!");
			return true;	
		}
		else {
			System.out.println("\nError: Production cell occupied!");
			return false;
		}
	}
	
	
	
	public String toString(int index) {
		StringBuilder builder = new StringBuilder();
		builder.append("-----------------\n");
		builder.append("Production cell number " + index + ":\n");
		builder.append("Malus value in position " + index + ": " + prodCellValue); //Must be -3 malus if position > 0

		
		if(prodCellFM != null){
			builder.append("Family Member in production cell number " + index + ":\n"
					+ "Player color: " + prodCellFM.getPlayercol() + "\n"
					+ "Family Member color: " + prodCellFM.getColor() + "\n"
					+ "Family Member value: " + prodCellFM.getValue() + "\n"
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
	
	
}
