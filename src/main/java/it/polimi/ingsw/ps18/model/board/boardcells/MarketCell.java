package it.polimi.ingsw.ps18.model.board.boardcells;

import it.polimi.ingsw.ps18.model.personalBoard.FMember;


/**
 * Defines a market cell. <br>
 * When a FMember is placed, MarketCell activates a set of quick effects.
 * 
 */

public class MarketCell {
	private FMember marketCellFM;
	//effetto market cell
	
	
	public MarketCell() {
		marketCellFM = null;
	}

	/**
	 * Places a FMember from PBoard to the cell
	 * @param pBoardFM
	 */
	public boolean insertFM (FMember pBoardFM) {
		
		if(this.isEmpty()){
			this.marketCellFM = pBoardFM;
			return true;
		} return false;
		//QuickEff activation gestita dal chiamante
	}
	
	/**
	 * Checks the cell's state (Empty/Full)
	 * @return a boolean state
	 */
	
	private boolean isEmpty() {
		if(this.marketCellFM==null){ 
			System.out.println("\nMarket cell is clear!");
			return true;		
		}
		else {
			System.out.println("\nError: Market cell occupied!");
			return false;
		}	
	}

	/**
	 * @return the marketCellFM
	 */
	public FMember getMarketCellFM() {
		return marketCellFM;
	}

	/**
	 * @param marketCellFM the marketCellFM to set
	 */
	public void setMarketCellFM(FMember marketCellFM) {
		this.marketCellFM = marketCellFM;
	}
	
	
}
