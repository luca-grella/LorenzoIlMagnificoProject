package it.polimi.ingsw.ps18.model.board;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Random;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.board.boardcells.ConcreteTower;
import it.polimi.ingsw.ps18.model.board.boardcells.CouncilCell;
import it.polimi.ingsw.ps18.model.board.boardcells.HarvCell;
import it.polimi.ingsw.ps18.model.board.boardcells.MarketCell;
import it.polimi.ingsw.ps18.model.board.boardcells.ProdCell;
import it.polimi.ingsw.ps18.model.board.boardcells.Tower;
import it.polimi.ingsw.ps18.model.cards.Excommunications;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.gamelogic.GeneralParameters;
import it.polimi.ingsw.ps18.model.gamelogic.ShowBoard;
import it.polimi.ingsw.ps18.model.messagesandlogs.LogMessage;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.view.MainView;

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
 * .
 *
 * @author yazan-matar
 * @see {@link import it.polimi.ingsw.ps18.model.board.boardcells.Tower}
 * @see {@link import it.polimi.ingsw.ps18.model.board.boardcells.ConcreteTower}
 * @see {@link import it.polimi.ingsw.ps18.model.board.boardcells.Cell}
 * @see {@link import it.polimi.ingsw.ps18.model.board.boardcells.MarketCell}
 * @see {@link import it.polimi.ingsw.ps18.model.board.boardcells.CouncilCell}
 * @see {@link import it.polimi.ingsw.ps18.model.board.boardcells.HarvCell}
 * @see {@link import it.polimi.ingsw.ps18.model.board.boardcells.ProdCell}
 * @see {@link import it.polimi.ingsw.ps18.model.cards.Excommunications}
 */
public class Board extends Observable {
	
	/**
	 * The nplayer.
	 */
	private int nplayer;
	
	/**
	 * The towers.
	 */
	private List<Tower> towers = new ArrayList<>();
	
	/**
	 * The market cells.
	 */
	private List<MarketCell> marketCells = new ArrayList<>();
	
	/**
	 * The council cells.
	 */
	private List<CouncilCell> councilCells = new ArrayList<>();
	
	/**
	 * The harvest cells with malus.
	 */
	private List<HarvCell> harvestCells = new ArrayList<>();
	
	/**
	 * The harvest cell without malus.
	 */
	private HarvCell harvCellNoMalus = new HarvCell(0);
	
	/**
	 * The production cells with malus.
	 */
	private List<ProdCell> productionCells = new ArrayList<>();
	
	/**
	 * The production cell without malus
	 */
	private ProdCell prodCellNoMalus = new ProdCell(0);
	
	/**
	 * The excomm cells.
	 */
	private List<Excommunications> excommCells = new ArrayList<>(); 
	
	
	/**
	 * 
	 * test
	 */
	public Board (){
	}
	
	/**
	 * Instantiates a new board.
	 *
	 * @param mcontroller
	 *            the mcontroller
	 * @param nplayer
	 *            the nplayer
	 */
	public Board (MainController mcontroller, int nplayer, MainView mView){
		addObserver(mView);
		notifyLogBoardView("Setup Board Initiated.");
		this.nplayer = nplayer;
		int count;
		JSONParser parser = new JSONParser();
		
		try {
	    	
			Object obj = parser.parse(new FileReader("src/main/java/it/polimi/ingsw/ps18/model/board/boardcells/TowerCell.json")); 
	    	JSONObject jsonObject = (JSONObject) obj;
			
	    	for(count=0; count<GeneralParameters.numberofBaseTowers; count++){ 
	    		Integer towerIndex = new Integer(count);
				this.towers.add(new ConcreteTower(towerIndex,(JSONObject) jsonObject.get(towerIndex.toString())));
			}
			obj = parser.parse(new FileReader("src/main/java/it/polimi/ingsw/ps18/model/board/boardcells/MarketCell.json")); 
	    	jsonObject = (JSONObject) obj;
	    	
	    	for(count=1; count<=GeneralParameters.numberofMarketCells; count++){ 
	    		Integer i = new Integer(count);
				MarketCell cell = new MarketCell((JSONObject) jsonObject.get(i.toString()));
				if(cell.getMinPlayers() <= nplayer){
					this.marketCells.add(cell);
				}
			}
	    	
		}catch (FileNotFoundException e) {
	        System.out.println("File not found.");

	    } catch (IOException e) {
		    System.out.println("IOException");
		} catch (org.json.simple.parser.ParseException e) {
			System.out.println("Problem in parser");
		}
		notifyLogBoardView("Setup Board Terminated.");
		
	}
	
	/**
	 * Notify log board view.
	 *
	 * @param msg
	 *            the msg
	 */
	private void notifyLogBoardView(String msg){
		setChanged();
		notifyObservers(new LogMessage(msg));
	}
	
	
	/**
	 * Cleans the board for the next game period. <br>
	 * Excommunication cells remains intact.
	 * 
	 */
	public void refreshBoard(){
		
		int count;
		JSONParser parser = new JSONParser();
		
		try {
	    	
			Object obj = parser.parse(new FileReader("src/main/java/it/polimi/ingsw/ps18/model/board/boardcells/TowerCell.json")); 
	    	JSONObject jsonObject = (JSONObject) obj;
			
	    	for(count=0; count<GeneralParameters.numberofBaseTowers; count++){
	    		Integer towerIndex = new Integer(count);
//				this.towers.add(new ConcreteTower(towerIndex,(JSONObject) jsonObject.get(towerIndex.toString())));
	    		this.towers.set(count, new ConcreteTower(towerIndex, (JSONObject) jsonObject.get(towerIndex.toString())));
			}
			obj = parser.parse(new FileReader("src/main/java/it/polimi/ingsw/ps18/model/board/boardcells/MarketCell.json")); 
	    	jsonObject = (JSONObject) obj;
	    	this.marketCells.clear();
	    	for(count=1; count<=GeneralParameters.numberofMarketCells; count++){ 
	    		Integer i = new Integer(count);
				MarketCell cell = new MarketCell((JSONObject) jsonObject.get(i.toString()));
				if(cell.getMinPlayers() <= nplayer){
					this.marketCells.add(cell);
//					this.marketCells.set(count, cell);
				}
			}
	    	
		}catch (FileNotFoundException e) {
	        System.out.println("File not found.");

	    } catch (IOException e) {
		    System.out.println("IOException");
		} catch (org.json.simple.parser.ParseException e) {
			System.out.println("Problem in parser");
		}
		
		councilCells.clear();
		harvestCells.clear();
		productionCells.clear();
		
	}
	
	/**
	 * Checks the Market status.
	 *
	 * @return a boolean value:
	 *         <ul>
	 *         <li>True:
	 *         <ul>
	 *         <li>Market is full, meaning that all of its cells are occupied by
	 *         a Family Member (regardless of the Family Member player color)
	 *         </ul>
	 *         <li>False:
	 *         <ul>
	 *         <li>Market contains at least an empty cell
	 *         </ul>
	 *         </ul>
	 */
	public boolean isFullMarket() {
		for(int marketIndex=0; marketIndex<marketCells.size(); marketIndex++){
			MarketCell marketCell = marketCells.get(marketIndex);
			if(marketCell.isEmptyMC())
				return false;
		}
		return true;
	}
	
	
	
	/**
	 * Checks the legality of the current player's action.
	 * @param pBoardFM is the family member chosen by the player
	 * @return a boolean value:
	 * <ul>
	 * 	<li>True:
	 * 		<ul>
	 * 			<li> Harvest is empty
	 * 			<li> Harvest contains some family Member, but there's no Family Member
	 * 				 of the current player's color
	 * 			<li> Harvest contains a Family Member that belongs to the current player
	 * 				 that's not neutral and the chosen Family Member is neutral
	 * 			<li> Harvest contains a Family Member that belongs to the current player
	 * 				 that's neutral
	 * 		</ul>
	 * 	<li> False:
	 * 		<ul>
	 * 			<li> Harvest contains a Family Member that belongs to the current player
	 * 				 that's not neutral and the chosen Family Member is not neutral
	 * 		</ul>
	 * </ul>
	 */
	public boolean isLegalHarv(FMember pBoardFM){
		if(pBoardFM != null){
			if(this.harvCellNoMalus.isEmptyHC() && this.harvestCells.isEmpty()){
				return true;
			}
			
			if( ! (this.harvCellNoMalus.isEmptyHC())){
				if(this.harvCellNoMalus.getHarvCellFM().getPlayercol() != pBoardFM.getPlayercol()){
					for(int harvIndex=0; harvIndex < harvestCells.size(); harvIndex++){
						HarvCell harvCell = harvestCells.get(harvIndex);
						if( ! (harvCell.isEmptyHC()) ){
							if(harvCell.getHarvCellFM().getPlayercol() == pBoardFM.getPlayercol()){
								if(pBoardFM.getColor() != GeneralParameters.neutralFMColor){
									if(harvCell.getHarvCellFM().getColor() != GeneralParameters.neutralFMColor){
										return false;
									}
								}
							}
						}
					}
				}
				else{
					if(pBoardFM.getColor() != GeneralParameters.neutralFMColor){	
						if(this.harvCellNoMalus.getHarvCellFM().getColor() != GeneralParameters.neutralFMColor)
							return false;
						else{
							for(int harvIndex=0; harvIndex < harvestCells.size(); harvIndex++){
								HarvCell harvCell = harvestCells.get(harvIndex);
								if( ! (harvCell.isEmptyHC()) ){
									if(harvCell.getHarvCellFM().getPlayercol() == pBoardFM.getPlayercol()){	
										if(pBoardFM.getColor() != GeneralParameters.neutralFMColor){		
											if(harvCell.getHarvCellFM().getColor() != GeneralParameters.neutralFMColor)
												return false;
										}
									}
								}
							}
						}
					}
				}
			}
			else{
				for(int harvIndex=0; harvIndex < harvestCells.size(); harvIndex++){
					HarvCell harvCell = harvestCells.get(harvIndex);
					if( ! (harvCell.isEmptyHC()) ){
						if(harvCell.getHarvCellFM().getPlayercol() == pBoardFM.getPlayercol()){
							if(pBoardFM.getColor() != GeneralParameters.neutralFMColor){
								if(harvCell.getHarvCellFM().getColor() != GeneralParameters.neutralFMColor)
									return false;
							}
						}
					}
				}
			}
		}
		else{ //Familiare a null
			System.out.println("\n[Board isLegalHarv] familiare null!");
			return false;
		}
		
		return true;
	}

	/**
	 * Checks the legality of the current player's action.
	 * @param pBoardFM is the family member chosen by the player
	 * @return a boolean value:
	 * <ul>
	 * 	<li>True:
	 * 		<ul>
	 * 			<li> Production is empty
	 * 			<li> Production contains some family Member, but there's no Family Member
	 * 				 of the current player's color
	 * 			<li> Production contains a Family Member that belongs to the current player
	 * 				 that's not neutral and the chosen Family Member is neutral
	 * 			<li> Production contains a Family Member that belongs to the current player
	 * 				 that's neutral
	 * 		</ul>
	 * 	<li> False:
	 * 		<ul>
	 * 			<li> Production contains a Family Member that belongs to the current player
	 * 				 that's not neutral and the chosen Family Member is not neutral
	 * 		</ul>
	 * </ul>
	 */
	public boolean isLegalProd(FMember pBoardFM){
		
		if(pBoardFM != null){
			if(this.prodCellNoMalus.isEmptyPC() && this.productionCells.isEmpty()){
				return true;
			}
			
			if( ! (this.prodCellNoMalus.isEmptyPC())){
				if(this.prodCellNoMalus.getProdCellFM().getPlayercol() != pBoardFM.getPlayercol()){
					for(int prodIndex=0; prodIndex < productionCells.size(); prodIndex++){
						ProdCell prodCell = productionCells.get(prodIndex);
						if( ! (prodCell.isEmptyPC()) ){
							if(prodCell.getProdCellFM().getPlayercol() == pBoardFM.getPlayercol()){
								if(pBoardFM.getColor() != GeneralParameters.neutralFMColor){
									if(prodCell.getProdCellFM().getColor() != GeneralParameters.neutralFMColor){
										return false;
									}
								}
							}
						}
					}
				}
				else{
					if(pBoardFM.getColor() != GeneralParameters.neutralFMColor){	
						if(this.prodCellNoMalus.getProdCellFM().getColor() != GeneralParameters.neutralFMColor)
							return false;
						else{
							for(int prodIndex=0; prodIndex < harvestCells.size(); prodIndex++){
								ProdCell prodCell = productionCells.get(prodIndex);
								if( ! (prodCell.isEmptyPC()) ){
									if(prodCell.getProdCellFM().getPlayercol() == pBoardFM.getPlayercol()){	
										if(pBoardFM.getColor() != GeneralParameters.neutralFMColor){		
											if(prodCell.getProdCellFM().getColor() != GeneralParameters.neutralFMColor)
												return false;
										}
									}
								}
							}
						}
					}
				}
			}
			else{
				for(int prodIndex=0; prodIndex < productionCells.size(); prodIndex++){
					ProdCell prodCell = productionCells.get(prodIndex);
					if( ! (prodCell.isEmptyPC()) ){
						if(prodCell.getProdCellFM().getPlayercol() == pBoardFM.getPlayercol()){
							if(pBoardFM.getColor() != GeneralParameters.neutralFMColor){
								if(prodCell.getProdCellFM().getColor() != GeneralParameters.neutralFMColor)
									return false;
							}
						}
					}
				}
			}
		}
		else{ //Familiare a null
			System.out.println("\n[Board isLegalProd] familiare null!");
			return false;
		}
		
		return true;
	}

	/**
	 * Inserts a FMember in Harvest:<br>
	 * There are two cases:
	 * 		<ol>
	 * 			<li> Harvest is empty, meaning that the player can access only the first Cell of the ArrayList (malus missing).
	 * 			<li> Harvest is not empty, meaning that the player can access only the Cells containing a malus.
	 * 		</ol>
	 * 
	 * In both cases, the method uses the Harvest Cell method insertFM, that places a FMember in a Cell.
	 * 
	 * @param fam
	 * FMember chosen for the current action
	 * @return the FMember value considering a possible Harvest malus
	 */
	public void insertFMHarv(FMember fam, int chosenCell, GameLogic game){
		HarvCell harvCell;
		/*
		 * Cambia: if la scelta e' stata di piazzare il fam nella prima cella,
		 * lo inserisce li
		 */
		if(chosenCell == 0){
			this.harvCellNoMalus.insertFM(fam, game);
		} 
		else {
			harvCell = new HarvCell(GeneralParameters.baseMalusHarvCells);
			if(harvCell.insertFM(fam, game)){
				harvestCells.add(harvCell);
			}
		} 
//		return (fam.getValue() - harvCell.getMalus());
	}
	
	public int getActionValueHarv(FMember fam, int chosenCell) {
		int malus = 0;
		if(chosenCell != 0){
			malus = 3;
		}
		return (fam.getValue() - malus);

	}

	
	/**
	 * Inserts a FMember in Production:<br>
	 * There are two cases:
	 * 		<ol>
	 * 			<li> Production is empty, meaning that the player can access only the first Cell of the ArrayList (malus missing).
	 * 			<li> Production is not empty, meaning that the player can access only the Cells containing a malus,
	 * 		</ol>
	 * 
	 * In both cases, the method uses the Production Cell method insertFM, that places a FMember in a Cell.
	 * 
	 * @param fam
	 * FMember chosen for the current action.
	 * @return the FMember value considering a possible Harvest malus.
	 */
	public void insertFMProd(FMember fam, int chosenCell, GameLogic game){
		ProdCell prodCell;
		if(chosenCell == 0){
			this.prodCellNoMalus.insertFM(fam, game);
		} else {
			prodCell = new ProdCell(GeneralParameters.baseMalusProdCells);
			if(prodCell.insertFM(fam, game)){
				productionCells.add(prodCell);
			}
		}
	}
	
	public int getActionValueProd(FMember fam, int chosenCell){
		int malus = 0;
		if(chosenCell != 0){
			malus = 3;
		}
		return (fam.getValue() - malus);
	}
	
	/**
	 * To string towers.
	 *
	 * @return the string
	 */
	/*
	 * DEFINE LATER
	 */
	public String toStringTowers(){
		StringBuilder builder = new StringBuilder();
		
		builder.append("-----------------\n");
		
		for(int towerIndex=0; towerIndex<GeneralParameters.numberofBaseTowers; towerIndex++){
			Tower boardTower = towers.get(towerIndex);
			builder.append("Tower number: " + (towerIndex+1) + "\n" + boardTower.toString());
			builder.append("\n-----------------\n");
		}
		
		return builder.toString();
	}
	
	/**
	 * To string council.
	 *
	 * @return the string
	 */
	public String toStringCouncil(){
		StringBuilder builder = new StringBuilder();
		if(this.councilCells.size()==0){
			builder.append("\nThe Council Section is Empty.\n\n");
		} else {
			for(int councilIndex=0; councilIndex<this.councilCells.size(); councilIndex++){
				CouncilCell tempcell = this.councilCells.get(councilIndex);
			    builder.append(tempcell.toString(councilIndex));	
			}
		}
		return builder.toString();
	}
	
	/**
	 * To string harvest.
	 *
	 * @return the string
	 */
	public String toStringHarvest(){
		StringBuilder builder = new StringBuilder();
		if(this.harvestCells.isEmpty() && this.harvCellNoMalus.isEmptyHC()){
			builder.append("\nThe Harvest Section is Empty.\n\n");
		}
		else{
			if( ! (this.harvCellNoMalus.isEmptyHC()) )
				builder.append(this.harvCellNoMalus.toString(0));
			if( ! (this.harvestCells.isEmpty()) ){
				for(int harvestIndex=0; harvestIndex<this.harvestCells.size(); harvestIndex++){
				HarvCell tempcell = this.harvestCells.get(harvestIndex);
			    builder.append(tempcell.toString(harvestIndex+1));
				}
			}
		}
		return builder.toString();
	}
	
	/**
	 * To string production.
	 *
	 * @return the string
	 */
	public String toStringProduction(){
		StringBuilder builder = new StringBuilder();
		if(this.productionCells.isEmpty() && this.prodCellNoMalus.isEmptyPC()){
			builder.append("\nThe Production Section is Empty.\n\n");
		}
		else{
			if( ! (this.prodCellNoMalus.isEmptyPC()) )
				builder.append(this.prodCellNoMalus.toString(0));
			if( ! (this.productionCells.isEmpty()) ){
				for(int prodIndex=0; prodIndex<this.productionCells.size(); prodIndex++){
					ProdCell tempcell = this.productionCells.get(prodIndex);
				    builder.append(tempcell.toString(prodIndex+1));
				}
			}
		}
		return builder.toString();
	}
	
	
	public String toStringExcomm(){
		StringBuilder builder = new StringBuilder();
		for(int i=0; i<this.excommCells.size(); i++){
			Excommunications card = this.excommCells.get(i);
			builder.append(card.toString(i));
		}
		builder.append("-----------------\n");
		return builder.toString();
	}
	

	/**
	 * Gets the towers.
	 *
	 * @return the towers
	 */
	public List<Tower> getTowers() {
		return towers;
	}

	/**
	 * Sets the towers.
	 *
	 * @param towers
	 *            the towers to set
	 */
	public void setTowers(List<Tower> towers) {
		this.towers = towers;
	}

	/**
	 * Gets the market cells.
	 *
	 * @return the marketCells
	 */
	public List<MarketCell> getMarketCells() {
		return marketCells;
	}

	/**
	 * Sets the market cells.
	 *
	 * @param marketCells
	 *            the marketCells to set
	 */
	public void setMarketCells(List<MarketCell> marketCells) {
		this.marketCells = marketCells;
	}

	/**
	 * Gets the council cells.
	 *
	 * @return the councilCells
	 */
	public List<CouncilCell> getCouncilCells() {
		return councilCells;
	}

	/**
	 * Sets the council cells.
	 *
	 * @param councilCells
	 *            the councilCells to set
	 */
	public void setCouncilCells(List<CouncilCell> councilCells) {
		this.councilCells = councilCells;
	}

	/**
	 * Gets the harvest cells.
	 *
	 * @return the harvestCells
	 */
	public List<HarvCell> getHarvestCells() {
		return harvestCells;
	}

	/**
	 * Sets the harvest cells.
	 *
	 * @param harvestCells
	 *            the harvestCells to set
	 */
	public void setHarvestCells(List<HarvCell> harvestCells) {
		this.harvestCells = harvestCells;
	}
	
	

	/**
	 * @return the harvCellNoMalus
	 */
	public HarvCell getHarvCellNoMalus() {
		return harvCellNoMalus;
	}

	/**
	 * @param harvCellNoMalus the harvCellNoMalus to set
	 */
	public void setHarvCellNoMalus(HarvCell harvCellNoMalus) {
		this.harvCellNoMalus = harvCellNoMalus;
	}

	/**
	 * Gets the production cells.
	 *
	 * @return the productionCells
	 */
	public List<ProdCell> getProductionCells() {
		return productionCells;
	}

	/**
	 * Sets the production cells.
	 *
	 * @param productionCells
	 *            the productionCells to set
	 */
	public void setProductionCells(List<ProdCell> productionCells) {
		this.productionCells = productionCells;
	}

	/**
	 * @return the prodCellNoMalus
	 */
	public ProdCell getProdCellNoMalus() {
		return prodCellNoMalus;
	}

	/**
	 * @param prodCellNoMalus the prodCellNoMalus to set
	 */
	
	public void setProdCellNoMalus(ProdCell prodCellNoMalus) {
		this.prodCellNoMalus = prodCellNoMalus;
	}

	/**
	 * Gets the excomm cells.
	 *
	 * @return the excommCells
	 */
	public List<Excommunications> getExcommCells() {
		return excommCells;
	}

	/**
	 * Sets the excomm cells.
	 *
	 * @param excommCells
	 *            the excommCells to set
	 */
	public void setExcommCells(List<Excommunications> excommCells) {
		this.excommCells = excommCells;
	}

	/**
	 * Gets the nplayer.
	 *
	 * @return the nplayer
	 */
	public int getNplayer() {
		return nplayer;
	}

	/**
	 * Sets the nplayer.
	 *
	 * @param nplayer
	 *            the nplayer to set
	 */
	public void setNplayer(int nplayer) {
		this.nplayer = nplayer;
	}

	
}
