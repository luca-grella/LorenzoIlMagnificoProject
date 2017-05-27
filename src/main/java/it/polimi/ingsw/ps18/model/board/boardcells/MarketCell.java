package it.polimi.ingsw.ps18.model.board.boardcells;

import it.polimi.ingsw.ps18.model.effect.excommEffects.ExcommEffects;
import it.polimi.ingsw.ps18.model.personalBoard.FMember;


public class MarketCell {
	private FMember marketCellFM;
	//public ExcommEffects bonus; //prova
	
	public FMember getMarketCellFM() {
		return marketCellFM;
	}



	public void setMarketCellFM(FMember marketCellFM) { //non necessario
		this.marketCellFM = marketCellFM;
	}

		
	public void insertFM (FMember pBoardFM){
		
		if(this.isEmpty())
			this.marketCellFM = pBoardFM;
		
		//QuickEff activation
	}
	
	private boolean isEmpty(){
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
