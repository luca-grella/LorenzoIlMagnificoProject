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
			this.towers.add(new ConcreteTower());
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
		
		Tower boardTower = new ConcreteTower(); //Tower or ConcreteTower?
		MarketCell marketCell = new MarketCell();
		/*
		 * Queste celle diventano inutili se bisogna eliminarle ad ogni refresh.
		 * Le tengo come reminder di ciò che non deve accadere in questo metodo.
		 * 
		 * CouncilCell councilCell = new CouncilCell();
		 * HarvCell harvestCell = new HarvCell();
		 * ProdCell productionCell = new ProdCell();
		 * 
		*/
		int count;
		
		for(count=0; count<GeneralParameters.numberofBaseTowers; count++){
			towers.set(count, boardTower);
		}
		for(count=0; count<GeneralParameters.numberofMarketCells; count++){
			marketCells.set(count, marketCell);
		}
		/*
		 * ATTENZIONE: Se implemento queste celle come ho scritto sopra, al refresh della Board
		 * devo proprio ELIMINARE tutte le celle dell'ArrayList, e NON iterare settando le celle inizializzate
		 * 
		 * Posso usare RemoveAll su uno stesso ArrayList? solitamente si usano due liste:
		 * listA.removeAll(listB) Elimina tutte le occorrenze di listB in listA
		 * list.removeAll(list) Non so se si può fare
		 * list.clear() Non so se elimina tutti gli elementi dell' ArrayList o se li setta a null (cosa che non voglio)
		 */
		
		councilCells.clear();
		harvestCells.clear();
		productionCells.clear();
		
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
