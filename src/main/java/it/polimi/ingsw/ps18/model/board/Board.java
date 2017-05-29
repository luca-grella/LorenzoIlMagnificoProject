package it.polimi.ingsw.ps18.model.board;

import java.util.ArrayList;
import java.util.List;

import it.polimi.ingsw.ps18.model.board.boardcells.Tower;
import it.polimi.ingsw.ps18.model.board.boardcells.ConcreteTower;
import it.polimi.ingsw.ps18.model.board.boardcells.MarketCell;
import it.polimi.ingsw.ps18.model.board.boardcells.CouncilCell;
import it.polimi.ingsw.ps18.model.board.boardcells.HarvCell;
import it.polimi.ingsw.ps18.model.board.boardcells.ProdCell;
import it.polimi.ingsw.ps18.model.cards.Excommunications;

public class Board {
	private List<ConcreteTower> towers = new ArrayList<>();
	private List<MarketCell> marketCells = new ArrayList<>();
	private List<CouncilCell> councilCells = new ArrayList<>();
	private List<HarvCell> harvestCells = new ArrayList<>();
	private List<ProdCell> productionCells = new ArrayList<>();
	private List<Excommunications> excommCells = new ArrayList<>(); 
	
	public Board (){ //Change for iterations
		int count;
		
		for(count=0; count<4; count++){ 
			this.towers.add(new ConcreteTower());
		}
		for(count=0; count<4; count++){ 
			this.marketCells.add(new MarketCell());
		}
		for(count=0; count<16; count++){ 
			this.councilCells.add(new CouncilCell());
		}
		for(count=0; count<4; count++){ 
			this.harvestCells.add(new HarvCell());
		}
		for(count=0; count<4; count++){ 
			this.productionCells.add(new ProdCell());
		}
		for(count=0; count<3; count++){ 
			this.excommCells.add(new Excommunications());
		}
	}

	
	
	
	public List<ConcreteTower> getTowers() {
		return towers;
	}

	public void setTowers(List<ConcreteTower> towers) {
		this.towers = towers;
	}

	public List<MarketCell> getMarketCells() {
		return marketCells;
	}

	public void setMarketCells(List<MarketCell> marketCells) {
		this.marketCells = marketCells;
	}

	public List<CouncilCell> getCouncilCells() {
		return councilCells;
	}

	public void setCouncilCells(List<CouncilCell> councilCells) {
		this.councilCells = councilCells;
	}

	public List<ProdCell> getProductionCells() {
		return productionCells;
	}

	public void setProductionCells(List<ProdCell> productionCells) {
		this.productionCells = productionCells;
	}

	public List<HarvCell> getHarvestCells() {
		return harvestCells;
	}

	public void setHarvestCells(List<HarvCell> harvestCells) {
		this.harvestCells = harvestCells;
	}

	public List<Excommunications> getExcommCells() {
		return excommCells;
	}

	public void setExcommCells(List<Excommunications> excommCells) {
		this.excommCells = excommCells;
	}
	
	
	
	
	//Controlli
	
	
	

}
