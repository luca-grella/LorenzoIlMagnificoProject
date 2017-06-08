package it.polimi.ingsw.ps18.model.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.board.boardcells.ConcreteTower;
import it.polimi.ingsw.ps18.model.board.boardcells.CouncilCell;
import it.polimi.ingsw.ps18.model.board.boardcells.HarvCell;
import it.polimi.ingsw.ps18.model.board.boardcells.MarketCell;
import it.polimi.ingsw.ps18.model.board.boardcells.ProdCell;
import it.polimi.ingsw.ps18.model.board.boardcells.Tower;
import it.polimi.ingsw.ps18.model.cards.Excommunications;
import it.polimi.ingsw.ps18.model.effect.quickEffect.HashMapQE;
import it.polimi.ingsw.ps18.model.gamelogic.GeneralParameters;
import it.polimi.ingsw.ps18.model.messages.LogMessage;
import it.polimi.ingsw.ps18.view.BoardView;

/**
 * Defines a game board, composed of: <br>
 * <ul>
 * <li>Towers
 * <li>Market cells
 * <li>Council cells
 * <li>Harvest cells
 * <li>Production cells
 * <li>Excommunication cells
 * </ul>
 * 
 * @see
 * {@link import it.polimi.ingsw.ps18.model.board.boardcells.Tower}
 * @see
 * {@link import it.polimi.ingsw.ps18.model.board.boardcells.ConcreteTower}
 * @see
 * {@link import it.polimi.ingsw.ps18.model.board.boardcells.Cell}
 * @see
 * {@link import it.polimi.ingsw.ps18.model.board.boardcells.MarketCell}
 * @see
 * {@link import it.polimi.ingsw.ps18.model.board.boardcells.CouncilCell}
 * @see
 * {@link import it.polimi.ingsw.ps18.model.board.boardcells.HarvCell}
 * @see
 * {@link import it.polimi.ingsw.ps18.model.board.boardcells.ProdCell}
 * @see
 * {@link import it.polimi.ingsw.ps18.model.cards.Excommunications}
 * 
 * @author yazan-matar
 * @author Francesco-Musio
 *
 */
public class Board extends Observable {
	private BoardView boardview;
	private List<Tower> towers = new ArrayList<>();
	private List<MarketCell> marketCells = new ArrayList<>();
	private List<CouncilCell> councilCells = new ArrayList<>();
	private List<HarvCell> harvestCells = new ArrayList<>();
	private List<ProdCell> productionCells = new ArrayList<>();
	private List<Excommunications> excommCells = new ArrayList<>(); 
	
	public Board (MainController mcontroller){
		boardview = new BoardView(mcontroller);
		addObserver(boardview);
		notifyLogBoardView("Setup Board Initiated.");
		int count;

		for(count=0; count<GeneralParameters.numberofBaseTowers; count++){ 
			this.towers.add(new ConcreteTower(count));
		}
		for(count=0; count<GeneralParameters.numberofMarketCells; count++){ 
			this.marketCells.add(new MarketCell());
		}
		
		/*
		 * Production, Harvest and Council cells da implementare.
		 * Per queste celle conviene creare una nuova cella ad ogni azione verso uno di questi ArrayList:
		 * Se voglio mettere un familiare nel consiglio:
		 * councilCells.add(index, new CouncilCell()); 
		 * councilCells.set(index, councilCell) con councilCell settato con il familiare corretto
		 * e lo stesso per le celle produzione e raccolto. 
		 * In questo modo posso posizionare un numero illimitato di familiari.
		 * Domanda: in che parte del codice devo incrementare l'ArrayList?
		 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		 * Risposta: lo fanno direttamente le azioni nel turno, non te preoccupà
		 */
		
		
		for(count=0; count<GeneralParameters.numberofExcommCells; count++){ 
			this.excommCells.add(new Excommunications());
		}
		
		notifyLogBoardView("Setup Board Terminated.");
	}
	
	private void notifyLogBoardView(String msg){
		setChanged();
		notifyObservers(new LogMessage(msg));
	}
	
	
	/**
	 * Cleans the board for the next game period. <br>
	 * Excommunications cells remains intact.
	 * 
	 */
	public void refreshBoard(){
		
		int count;
		
		for(count=0; count<GeneralParameters.numberofBaseTowers; count++){
			towers.set(count, new ConcreteTower(count));
		}
		for(count=0; count<GeneralParameters.numberofMarketCells; count++){
			marketCells.set(count, new MarketCell());
		}
		
		councilCells.clear();
		harvestCells.clear();
		productionCells.clear();
		
	}
	
	/*
	 * DEFINE LATER
	 */
	public String toStringTowers(){
		StringBuilder builder = new StringBuilder();
		
		builder.append("\n-----------------\n");
		builder.append("Details of board towers\n");
		
		for(int towerIndex=0; towerIndex<GeneralParameters.numberofBaseTowers; towerIndex++){
			Tower boardTower = towers.get(towerIndex);
			builder.append(boardTower.toString());
			builder.append("\n-----------------\n");
		}
		
		return builder.toString();
	}
	
	public String toStringCouncil(){
		StringBuilder builder = new StringBuilder();
		if(this.councilCells.size()==0){
			builder.append("The Council is Empty.\n\n");
		} else {
			for(int i=0; i<this.councilCells.size(); i++){
				CouncilCell tempcell = this.councilCells.get(i);
			    builder.append(tempcell.toString(i));	
			}
		}
		return builder.toString();
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

	
}
