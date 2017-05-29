package it.polimi.ingsw.ps18.model.board.boardcells;

import it.polimi.ingsw.ps18.model.personalBoard.FMember;


/**
 * Defines a market cell. <br>
 * When a FMember is placed, MarketCell activates a set of quick effects.
 * 
 */

public class MarketCell {
	private FMember marketCellFM;
	
	
	public MarketCell() {
		marketCellFM = null;
	}
	
	public FMember getMarketCellFM() {
		return marketCellFM;
	}

	public void setMarketCellFM(FMember marketCellFM) {
		this.marketCellFM = marketCellFM;
	}

	/**
	 * Places a FMember from PBoard to the cell
	 * @param pBoardFM
	 */
	public void insertFM (FMember pBoardFM) {
		
		if(this.isEmpty())
			this.marketCellFM = pBoardFM;
		
		//QuickEff activation
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
}
