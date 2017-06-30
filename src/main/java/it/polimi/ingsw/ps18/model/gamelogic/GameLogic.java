package it.polimi.ingsw.ps18.model.gamelogic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.board.Board;
import it.polimi.ingsw.ps18.model.board.boardcells.Tower;
import it.polimi.ingsw.ps18.model.cards.BlueC;
import it.polimi.ingsw.ps18.model.cards.BonusTile;
import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.cards.Excommunications;
import it.polimi.ingsw.ps18.model.cards.GreenC;
import it.polimi.ingsw.ps18.model.cards.PurpleC;
import it.polimi.ingsw.ps18.model.cards.YellowC;
import it.polimi.ingsw.ps18.model.effect.generalEffects.GeneralEffect;
import it.polimi.ingsw.ps18.model.effect.harvestEffect.HashMapHE;
import it.polimi.ingsw.ps18.model.effect.quickEffect.HashMapQE;
import it.polimi.ingsw.ps18.model.messagesandlogs.ActionMessage;
import it.polimi.ingsw.ps18.model.messagesandlogs.LogMessage;
import it.polimi.ingsw.ps18.model.messagesandlogs.StatusMessage;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;
import it.polimi.ingsw.ps18.view.MainView;


/**
 * The Class GameLogic.
 *
 * @author Francesco-Musio
 */
public class GameLogic extends Observable {
	
	/**
	 * The m view.
	 */
	MainView mView;
	
	/**
	 * The input.
	 */
	Scanner input = new Scanner(System.in);
	
	/**
	 * The turn.
	 */
	private int TURN = 0;
	
	/**
	 * The age.
	 */
	private int AGE = 1;
	
	/**
	 * The nplayer.
	 */
	private int nplayer;
	
	/**
	 * The board.
	 */
	private Board board;
	
	/**
	 * The players.
	 */
	private List<PBoard> players = new ArrayList<>(nplayer);
	
	/**
	 * The turnplayer.
	 */
	private PBoard turnplayer;
	
	/**
	 * The bonusTiles
	 */
	private List<Cards> bonusTiles = new ArrayList<>(GeneralParameters.numberOfBonusTiles);
	
	/**
	 * The Green Cards
	 */
	private List<Cards> greencards = new ArrayList<>(GeneralParameters.numberGreenC);
	
	/**
	 * The bluecards.
	 */
	private List<Cards> bluecards = new ArrayList<>(GeneralParameters.numberBlueC);
	
	/**
	 * The yellowcards.
	 */
	private List<Cards> yellowcards = new ArrayList<>(GeneralParameters.numberYellowC);
	
	/**
	 * The purplecards.
	 */
	private List<Cards> purplecards = new ArrayList<>(GeneralParameters.numberPurpleC);
	
	/**
	 * The excommcards.
	 */
	private List<Excommunications> excommcards = new ArrayList<>(GeneralParameters.numberExcommC);
	
	/**
	 * The dices.
	 */
	private List<Dice> dices = new ArrayList<>(GeneralParameters.numberofDices);
	
	/**
	 * per test
	 */
	int tester;
	
	/**
	 * The ongoing action.
	 */
	private Action ongoingAction;
	
	/**
	 * The ongoing effect.
	 */
	private GeneralEffect ongoingEffect;
	
	
	/**
	 * Initialize the game.
	 *
	 * @param nplayer
	 *            set the number of players this game has
	 * @param mController
	 *            the m controller
	 */
	public GameLogic(int nplayer,MainController mController, List<PBoard> players){
		this.nplayer = nplayer;
		this.players = players;
		mView = new MainView(mController);
		addObserver(mView);
	}
	
	/**
	 * Per i test.
	 * @return 
	 */
	public GameLogic(){
	
	}
	
	/**
	 * Per i test.
	 * @return 
	 */
	public GameLogic(int test){
	this.tester=test;
	}
	
	/**
	 * Initial Setup that create:
	 * {@link it.polimi.ingsw.ps18.model.board.Board#Board} -
	 * {@link it.polimi.ingsw.ps18.model.gamelogic.Dice#Dice} -
	 * {@link it.polimi.ingsw.ps18.model.personalBoard.PBoard#PBoard(int, List)}
	 * - {@link it.polimi.ingsw.ps18.model.gamelogic.GameLogic#genDeck()} -
	 * {@link it.polimi.ingsw.ps18.model.gamelogic.Dice#Dice} - insert the cards
	 * in the Tower Cells
	 * {@link it.polimi.ingsw.ps18.model.board.boardcells.Tower#insertCards(List)}
	 *
	 * @param mainController
	 *            the new up
	 */
	public void setup(MainController mainController){
		notifyLogMainView("Setup Initiated.");
		this.board = new Board(mainController, this.nplayer, this.mView);
		for(int i=0; i<GeneralParameters.numberofDices; i++){
			this.dices.add(new Dice(i));
		}
		genDeck();
		notifyLogMainView("Deck Initialized.");
		for(int i=0; i<nplayer; i++){
			this.turnplayer = players.get(i);
			this.players.get(i).completePBoardSetup(dices, mainController, bonusTiles);
			
		}
		insertCardsinTowers();
		notifyLogMainView("Cards Inserted in Towers.");
		board.setExcommCells(insertExcommInBoard()); //TODO: Controllare doppio carpiato
		notifyLogMainView("Excommunications Inserted in Board."); //TODO: Controllare
		Collections.shuffle(players); //initial order
		notifyLogMainView("Player Order Shuffled.");
		notifyLogMainView("Setup Terminated.");
	}
	
	/**
	 * Gen deck.
	 */
	private void genDeck(){
		JSONParser parser = new JSONParser();
	    try {
	    	Object obj = parser.parse(new FileReader("src/main/java/it/polimi/ingsw/ps18/model/cards/GreenC.json"));
	    	JSONObject jsonObject = (JSONObject) obj;
	        for(int i=1; i<=GeneralParameters.numberGreenC; i++){
				Integer index = new Integer(i);
				this.greencards.add(new GreenC((JSONObject) jsonObject.get(index.toString())));	
			} notifyLogMainView("Green Deck Created.");
			
			obj = parser.parse(new FileReader("src/main/java/it/polimi/ingsw/ps18/model/cards/YellowC.json"));
	    	jsonObject = (JSONObject) obj;
			for(int i=1; i<=GeneralParameters.numberYellowC; i++){
				Integer index = new Integer(i);
				yellowcards.add(new YellowC((JSONObject) jsonObject.get(index.toString())));
			} notifyLogMainView("Yellow Deck Created.");
			
//			obj = parser.parse(new FileReader("src/main/java/it/polimi/ingsw/ps18/model/cards/BlueC.json"));
//	    	jsonObject = (JSONObject) obj;
//			for(int i=1; i<=GeneralParameters.numberBlueC; i++){
//				Integer index = new Integer(i);
//				bluecards.add(new BlueC((JSONObject) jsonObject.get(index.toString())));
//			} notifyLogMainView("Blue Deck Created.");
			
			obj = parser.parse(new FileReader("src/main/java/it/polimi/ingsw/ps18/model/cards/PurpleC.json"));
	    	jsonObject = (JSONObject) obj;
			for(int i=1; i<=GeneralParameters.numberPurpleC; i++){
				Integer index = new Integer(i);
				purplecards.add(new PurpleC((JSONObject) jsonObject.get(index.toString())));
			} notifyLogMainView("Purple Deck Created.");
			
			obj = parser.parse(new FileReader("src/main/java/it/polimi/ingsw/ps18/model/cards/Excommunications.json"));
	    	jsonObject = (JSONObject) obj;
			for(int i=1; i<=GeneralParameters.numberExcommC; i++){
				Integer index = new Integer(i);
				this.excommcards.add(new Excommunications((JSONObject) jsonObject.get(index.toString())));	
			} notifyLogMainView("Excommunication Deck Created.");
			
			obj = parser.parse(new FileReader("src/main/java/it/polimi/ingsw/ps18/model/cards/BonusTiles.json"));
	    	jsonObject = (JSONObject) obj;
			for(int i=1; i<=GeneralParameters.numberOfBonusTiles; i++){
				Integer index = new Integer(i);
				this.bonusTiles.add(new BonusTile((JSONObject) jsonObject.get(index.toString())));
			} notifyLogMainView("Bonus Tiles Deck Created.");
	        
	    }catch (FileNotFoundException e) {
	        System.out.println("File non trovato.");

	    } catch (IOException e) {
		    System.out.println("IOException");
		} catch (org.json.simple.parser.ParseException e) {
			System.out.println("Problema nel parser");
		}
	}

	
	/**
	 * Insert cardsin towers.
	 */
	private void insertCardsinTowers() {
		List<Tower> towers = board.getTowers();
		for(int i=0; i<GeneralParameters.numberofBaseTowers; i++){
			Tower singletower = towers.get(i);
			switch(i){
			case 0:
				singletower.insertCards(greencards, AGE);
				break;
//			case 1:
//				singletower.insertCards(bluecards, AGE);
//				break;
			case 2:
				singletower.insertCards(yellowcards, AGE);
				break;
			case 3:
				singletower.insertCards(purplecards, AGE);
				break;
			}
					
		}
		
	}
	
	/**
	 * Insert excomm in board.
	 * @return 
	 */
	private List<Excommunications> insertExcommInBoard() {
		Collections.shuffle(excommcards);
		for(int excommPeriod=1; excommPeriod<=GeneralParameters.numberofExcommCells; excommPeriod++){
			Iterator<Excommunications> itr = excommcards.iterator();
			Excommunications excommcard = itr.next();
			while(itr.hasNext() && excommcard.getPeriod() != excommPeriod){
				excommcard = itr.next();
			}
			excommcards.add(excommcard);
		}
		return excommcards;
	}
	
	/**
	 * Handles the game flow, but without the interaction with the players.
	 *
	 * @return a boolean value:
	 *         <ul>
	 *         <li>True: Every player in the game wants to play again
	 *         <li>False: At least one player doesn't want to play again
	 *         </ul>
	 */
	public boolean gameFlow(){
		do{
			this.TURN++;
			//riordina giocatori
			for(int famIndex=0; famIndex<GeneralParameters.nfamperplayer; famIndex++){
				for(int playerIndex=0; playerIndex<nplayer; playerIndex++){
					this.turnplayer = players.get(playerIndex);
					notifyActionMainView("Turn Handle Init");

					System.out.println(" ");
				}
			}

			if(TURN%2==0){		
				/*
				 * Se faccio qui il parser al posto di fare due volte il parser (in Trigger e in VaticanReport)
				 * devo capire come passare i valori letti tramite notify, perche' 
				 */
				notifyActionMainController("Verify Church Support");
			}
			this.refreshGame();

		} while (TURN!=GeneralParameters.totalTurns);
		//PBoard winner = winnerCalc(players);
		//System.out.println("Do you want to play again? Y|N");
		String answer = input.nextLine();
		if("Y".equalsIgnoreCase(answer)){
			return true;
		}
		return false;
	}
	
	
	
	public void refreshGame(){
		for(int diceIndex=0; diceIndex<GeneralParameters.numberofDices; diceIndex++){
			this.dices.set(diceIndex, new Dice(diceIndex)); 
			//Dice riceve il colore del dado, che coincide con il valore sequenziale dell'ArrayList
		}
		this.getTurnplayer().refreshFMembers(dices);
		this.getBoard().refreshBoard();
		this.insertCardsinTowers();
	}

	/**
	 * Calls {@link it.polimi.ingsw.ps18.model.personalBoard.PBoard#vPCalc()}
	 *
	 * @param players
	 *            the players
	 * @return the player who has won
	 */
	private PBoard winnerCalc(List<PBoard> players) {
		return null;
	}
	
	/**
	 * To string.
	 *
	 * @param i
	 *            the i
	 * @return the string
	 */
	private String toString(Integer i){
		StringBuilder builder = new StringBuilder();
		builder.append(i);
		return builder.toString();
	}
	
	
	private void notifyActionMainController(String msg) {
		setChanged();
		notifyObservers(new ActionMessage(msg));
	}
	
	/**
	 * Notify log main view.
	 *
	 * @param msg
	 *            the msg
	 */
	private void notifyLogMainView(String msg){
		setChanged();
		notifyObservers(new LogMessage(msg));
	}
	
	/**
	 * Notify action main view.
	 *
	 * @param msg
	 *            the msg
	 */
	private void notifyActionMainView(String msg){
		setChanged();
		notifyObservers(new ActionMessage(msg));
	}
	
	private void notifyStatusMainView(String msg){
		setChanged();
		notifyObservers(new StatusMessage(msg));
	}

	/**
	 * Gets the turnplayer.
	 *
	 * @return the turnplayer
	 */
	public PBoard getTurnplayer() {
		return turnplayer;
	}

	/**
	 * Gets the board.
	 *
	 * @return the board
	 */
	public Board getBoard() {
		return board;
	}

	/**
	 * Gets the ongoing action.
	 *
	 * @return the ongoingAction
	 */
	public Action getOngoingAction() {
		return ongoingAction;
	}

	/**
	 * Sets the ongoing action.
	 *
	 * @param ongoingAction
	 *            the ongoingAction to set
	 */
	public void setOngoingAction(Action ongoingAction) {
		this.ongoingAction = ongoingAction;
	}

	/**
	 * Gets the players.
	 *
	 * @return the players
	 */
	public List<PBoard> getPlayers() {
		return players;
	}

	/**
	 * Gets the ongoing effect.
	 *
	 * @return the ongoingEffect
	 */
	public GeneralEffect getOngoingEffect() {
		return ongoingEffect;
	}

	/**
	 * Sets the ongoing effect.
	 *
	 * @param ongoingEffect
	 *            the ongoingEffect to set
	 */
	public void setOngoingEffect(GeneralEffect ongoingEffect) {
		this.ongoingEffect = ongoingEffect;
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

	/**
	 * @return the bonusTiles
	 */
	public List<Cards> getBonusTiles() {
		return bonusTiles;
	}

	/**
	 * @return the excommcards
	 */
	public List<Excommunications> getExcommcards() {
		return excommcards;
	}

	/**
	 * @return the aGE
	 */
	public int getAGE() {
		return AGE;
	}

	/**
	 * 
	 */
	public void setCurrentPlayer(PBoard turnplayer) {
		this.turnplayer = turnplayer;
		
	}
	
	
	
	
	
	

}
