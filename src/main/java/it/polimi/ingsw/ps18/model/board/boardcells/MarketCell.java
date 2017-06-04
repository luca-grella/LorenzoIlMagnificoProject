package it.polimi.ingsw.ps18.model.board.boardcells;

import it.polimi.ingsw.ps18.model.personalBoard.FMember;


/**
 * Defines a market cell. <br>
 * When a family member is placed, MarketCell activates a set of quick effects.
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
			return true;		
		}
		else {
			return false;
		}	
	}
	
	public String toString(int index) {
		StringBuilder builder = new StringBuilder();
		builder.append("-----------------\n");
		builder.append("Market cell number " + index + ":\n");
		
		if(marketCellFM != null){
			builder.append("Family Member in market cell number " + index + ":\n"
					+ "Player color: " + marketCellFM.getPlayercol() + "\n"
					+ "Family Member color: " + marketCellFM.getColor() + "\n"
					+ "Family Member value: " + marketCellFM.getValue() + "\n"
					);
		}
		else{
			builder.append("\nMarket cell is empty!");
		}
		builder.append("-----------------\n");
		return builder.toString();
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
