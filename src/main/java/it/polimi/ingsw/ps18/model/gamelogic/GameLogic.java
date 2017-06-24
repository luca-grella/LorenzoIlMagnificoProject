package it.polimi.ingsw.ps18.model.gamelogic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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
import it.polimi.ingsw.ps18.model.messages.ActionMessage;
import it.polimi.ingsw.ps18.model.messages.LogMessage;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;
import it.polimi.ingsw.ps18.view.MainView;


/**
 * 
 * @author Francesco-Musio
 *
 */
public class GameLogic extends Observable {
	MainView mView;
	Scanner input = new Scanner(System.in);
	
	private int TURN = 0;
	private int AGE = 1;
	private int nplayer;
	private Board board;
	private List<PBoard> players = new ArrayList<>(nplayer);
	private PBoard turnplayer;
	private List<Cards> bonusTiles = new ArrayList<>(GeneralParameters.numberOfBonusTiles); 
	private List<Cards> greencards = new ArrayList<>(GeneralParameters.numberGreenC);
	private List<Cards> bluecards = new ArrayList<>(GeneralParameters.numberBlueC);
	private List<Cards> yellowcards = new ArrayList<>(GeneralParameters.numberYellowC);
	private List<Cards> purplecards = new ArrayList<>(GeneralParameters.numberPurpleC);
	private List<Excommunications> excommcards = new ArrayList<>(GeneralParameters.numberExcommC);
	private List<Dice> dices = new ArrayList<>(GeneralParameters.numberofDices);
	private Action ongoingAction;
	private GeneralEffect ongoingEffect;
	
	
	/**
	 * Initialize the game
	 * @param nplayer set the number of players this game has
	 * @param players2 
	 * @param controller 
	 */
	public GameLogic(int nplayer,MainController mController, List<PBoard> players){
		this.nplayer = nplayer;
		this.players = players;
		mView = new MainView(mController);
		addObserver(mView);
	}
	
	/**
	 * Per i test
	 */
	public GameLogic(){
		
	}
	
	/**
	 * Initial Setup that create:
	 * {@link it.polimi.ingsw.ps18.model.board.Board#Board}
	 * - {@link it.polimi.ingsw.ps18.model.gamelogic.Dice#Dice} 
	 * - {@link it.polimi.ingsw.ps18.model.personalBoard.PBoard#PBoard(int, List)}
	 * - {@link it.polimi.ingsw.ps18.model.gamelogic.GameLogic#genDeck()}
	 * - {@link it.polimi.ingsw.ps18.model.gamelogic.Dice#Dice}
	 * - insert the cards in the Tower Cells {@link it.polimi.ingsw.ps18.model.board.boardcells.Tower#insertCards(List)} 
	 * @param mainController 
	 */
	public void setup(MainController mainController){
		notifyLogMainView("Setup Initiated.");
		this.board = new Board(mainController, this.nplayer);
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
		Collections.shuffle(players); //initial order
		notifyLogMainView("Player Order Shuffled.");
		notifyLogMainView("Setup Terminated.");
	}
	
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
			
			obj = parser.parse(new FileReader("src/main/java/it/polimi/ingsw/ps18/model/cards/BlueC.json"));
	    	jsonObject = (JSONObject) obj;
			for(int i=1; i<=GeneralParameters.numberBlueC; i++){
				Integer index = new Integer(i);
				bluecards.add(new BlueC((JSONObject) jsonObject.get(index.toString())));
			} notifyLogMainView("Blue Deck Created.");
			
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
	
	private void insertCardsinTowers() {
		List<Tower> towers = board.getTowers();
		for(int i=0; i<GeneralParameters.numberofBaseTowers; i++){
			Tower singletower = towers.get(i);
			switch(i){
			case 0:
				singletower.insertCards(greencards, AGE);
				break;
			case 1:
				singletower.insertCards(bluecards, AGE);
				break;
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
	 * Handle the flow of the game, but without the interaction with the players
	 * @return true if every player want play again
	 */
	public boolean gameFlow(){
		do{
			this.TURN++;
			//riordina giocatori
			for(int i=0; i<GeneralParameters.nfamperplayer; i++){
				for(int j=0; j<nplayer; j++){
					this.turnplayer = players.get(j);
					notifyActionMainView("Turn Handle Init");
					
					System.out.println(" ");
				}
			}
			if(TURN%2==0){
				board.refreshBoard(); //Added board cleaning after every period
				VaticanReport(TURN/2);
			}
		} while (TURN!=GeneralParameters.totalTurns);
		//PBoard winner = winnerCalc(players);
		//System.out.println("Do you want to play again? Y|N");
		String answer = input.nextLine();
		if("Y".equalsIgnoreCase(answer)){
			return true;
		}
		return false;
	}

	/**
	 * Calls {@link it.polimi.ingsw.ps18.model.personalBoard.PBoard#vPCalc()}
	 * @param players
	 * @return the player who has won
	 */
	private PBoard winnerCalc(List<PBoard> players) {
		return null;
	}

	/**
	 * Handle the vatican report phase
	 * @param age 
	 */
	private void VaticanReport(int age) {
	}
	
	private String toString(Integer i){
		StringBuilder builder = new StringBuilder();
		builder.append(i);
		return builder.toString();
	}
	
	private void notifyLogMainView(String msg){
		setChanged();
		notifyObservers(new LogMessage(msg));
	}
	
	private void notifyActionMainView(String msg){
		setChanged();
		notifyObservers(new ActionMessage(msg));
	}

	/**
	 * @return the turnplayer
	 */
	public PBoard getTurnplayer() {
		return turnplayer;
	}

	/**
	 * @return the board
	 */
	public Board getBoard() {
		return board;
	}

	/**
	 * @return the ongoingAction
	 */
	public Action getOngoingAction() {
		return ongoingAction;
	}

	/**
	 * @param ongoingAction the ongoingAction to set
	 */
	public void setOngoingAction(Action ongoingAction) {
		this.ongoingAction = ongoingAction;
	}

	/**
	 * @return the players
	 */
	public List<PBoard> getPlayers() {
		return players;
	}

	/**
	 * @return the ongoingEffect
	 */
	public GeneralEffect getOngoingEffect() {
		return ongoingEffect;
	}

	/**
	 * @param ongoingEffect the ongoingEffect to set
	 */
	public void setOngoingEffect(GeneralEffect ongoingEffect) {
		this.ongoingEffect = ongoingEffect;
	}

	/**
	 * @return the nplayer
	 */
	public int getNplayer() {
		return nplayer;
	}

	/**
	 * @param nplayer the nplayer to set
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
	
	
	
	
	

}
