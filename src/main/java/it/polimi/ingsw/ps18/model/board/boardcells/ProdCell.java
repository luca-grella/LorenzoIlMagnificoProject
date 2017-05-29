package it.polimi.ingsw.ps18.model.board.boardcells;

import it.polimi.ingsw.ps18.model.personalBoard.FMember;

/**
 * Defines a production cell. <br>
 * When a FMember is placed, this cell activates 
 * a set of permanent effects if conditions are fulfilled.
 * 
 * @see
 * {@link it.polimi.ingsw.ps18.model.effect.prodEffect.HashMapPE}
 */

public class ProdCell {
	
	private FMember prodCellFM;
	private int prodCellValue;

	public ProdCell() {
		prodCellFM = null;
		prodCellValue = 0;
	}
	
	public FMember getProdCellFM() {
		return prodCellFM;
	}

	public void setProdCellFM(FMember prodCellFM) {
		this.prodCellFM = prodCellFM;
	}
	
	
	public int getProdCellValue() {
		return prodCellValue;
	}

	public void setProdCellValue(int prodCellValue) {
		this.prodCellValue = prodCellValue;
	}

	
	public void insertFM(FMember pBoardFM, int valueFM) {
		if(this.isEmpty()){
			if(valueFM >= prodCellValue){
				this.prodCellFM = pBoardFM;
				//Production Effects
			}		
		}
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
}
