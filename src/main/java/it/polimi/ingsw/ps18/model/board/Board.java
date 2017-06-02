package it.polimi.ingsw.ps18.model.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import it.polimi.ingsw.ps18.model.board.boardcells.Tower;
import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.board.boardcells.ConcreteTower;
import it.polimi.ingsw.ps18.model.board.boardcells.MarketCell;
import it.polimi.ingsw.ps18.model.board.boardcells.CouncilCell;
import it.polimi.ingsw.ps18.model.board.boardcells.HarvCell;
import it.polimi.ingsw.ps18.model.board.boardcells.ProdCell;
import it.polimi.ingsw.ps18.model.cards.Excommunications;
import it.polimi.ingsw.ps18.model.gameLogic.GeneralParameters;
import it.polimi.ingsw.ps18.view.BoardView;

public class Board extends Observable {
	private BoardView boardview;
	private List<Tower> towers = new ArrayList<>();
	private List<MarketCell> marketCells = new ArrayList<>();
	private List<CouncilCell> councilCells = new ArrayList<>();
	private List<HarvCell> harvestCells = new ArrayList<>();
	private List<ProdCell> productionCells = new ArrayList<>();
	private List<Excommunications> excommCells = new ArrayList<>(); 
	
	public Board (MainController mcontroller){ //Change for iterations
		boardview = new BoardView(mcontroller);
		addObserver(boardview);
		notifyBoardView("Setup Board Initiated.");
		int count;
		
		for(count=0; count<GeneralParameters.numberofBaseTowers; count++){ 
			this.towers.add(new ConcreteTower());
		}
		for(count=0; count<GeneralParameters.numberofMarketCells; count++){ 
			this.marketCells.add(new MarketCell());
		}
		for(count=0; count<GeneralParameters.numberofExcommCells; count++){ 
			this.excommCells.add(new Excommunications());
		}
		notifyBoardView("Setup Board Terminated.");
	}
	
	private void notifyBoardView(String msg){
		setChanged();
		notifyObservers(msg);
	}

	/**
	 * @return the towers
	 */
	public List<Tower> getTowers() {
		return towers;
	}

	/**
	 * @param towers the towers to set
	 */
	public void setTowers(List<Tower> towers) {
		this.towers = towers;
	}

	/**
	 * @return the marketCells
	 */
	public List<MarketCell> getMarketCells() {
		return marketCells;
	}

	/**
	 * @param marketCells the marketCells to set
	 */
	public void setMarketCells(List<MarketCell> marketCells) {
		this.marketCells = marketCells;
	}

	/**
	 * @return the councilCells
	 */
	public List<CouncilCell> getCouncilCells() {
		return councilCells;
	}

	/**
	 * @param councilCells the councilCells to set
	 */
	public void setCouncilCells(List<CouncilCell> councilCells) {
		this.councilCells = councilCells;
	}

	/**
	 * @return the harvestCells
	 */
	public List<HarvCell> getHarvestCells() {
		return harvestCells;
	}

	/**
	 * @param harvestCells the harvestCells to set
	 */
	public void setHarvestCells(List<HarvCell> harvestCells) {
		this.harvestCells = harvestCells;
	}

	/**
	 * @return the productionCells
	 */
	public List<ProdCell> getProductionCells() {
		return productionCells;
	}

	/**
	 * @param productionCells the productionCells to set
	 */
	public void setProductionCells(List<ProdCell> productionCells) {
		this.productionCells = productionCells;
	}

	/**
	 * @return the excommCells
	 */
	public List<Excommunications> getExcommCells() {
		return excommCells;
	}

	/**
	 * @param excommCells the excommCells to set
	 */
	public void setExcommCells(List<Excommunications> excommCells) {
		this.excommCells = excommCells;
	}

	
	//RefreshBoard
}
