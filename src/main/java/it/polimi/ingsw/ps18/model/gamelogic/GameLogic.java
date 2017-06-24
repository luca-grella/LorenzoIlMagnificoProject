package it.polimi.ingsw.ps18.model.gamelogic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Scanner;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.board.Board;
import it.polimi.ingsw.ps18.model.board.boardcells.Tower;
import it.polimi.ingsw.ps18.model.cards.BlueC;
import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.cards.Excommunications;
import it.polimi.ingsw.ps18.model.cards.GreenC;
import it.polimi.ingsw.ps18.model.cards.PurpleC;
import it.polimi.ingsw.ps18.model.cards.YellowC;
import it.polimi.ingsw.ps18.model.effect.generalEffects.GeneralEffect;
import it.polimi.ingsw.ps18.model.messages.ActionMessage;
import it.polimi.ingsw.ps18.model.messages.LogMessage;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.view.MainView;


// TODO: Auto-generated Javadoc
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
	 * The greencards.
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
	public GameLogic(int nplayer,MainController mController){
		this.nplayer = nplayer;
		mView = new MainView(mController);
		addObserver(mView);
	}
	
	/**
	 * Per i test.
	 */
	public GameLogic(){
		
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
		this.board = new Board(mainController, this.nplayer);
		for(int i=0; i<GeneralParameters.numberofDices; i++){
			this.dices.add(new Dice(i));
		}
		for(int i=0; i<nplayer; i++){
			this.players.add(new PBoard(i, this.dices, mainController));
		}
		genDeck();
		notifyLogMainView("Deck Initialized.");
		insertCardsinTowers();
		notifyLogMainView("Cards Inserted in Towers.");
		insertExcommInBoard();
		notifyLogMainView("Excommunications Inserted in Board."); //Controllare
		Collections.shuffle(players); //initial order
		notifyLogMainView("Player Order Shuffled.");
		notifyLogMainView("Setup Terminated.");
	}
	
	/**
	 * Gen deck.
	 */
	private void genDeck(){
		for(int i=1; i<=GeneralParameters.numberGreenC; i++){
			Integer index = new Integer(i);
			this.greencards.add(new GreenC(index));	
		} notifyLogMainView("Green Deck Created.");
		for(int i=1; i<=GeneralParameters.numberYellowC; i++){
			Integer index = new Integer(i);
			yellowcards.add(new YellowC(index));
		} notifyLogMainView("Yellow Deck Created.");
		for(int i=1; i<=GeneralParameters.numberBlueC; i++){
			Integer index = new Integer(i);
			bluecards.add(new BlueC(index));
		} notifyLogMainView("Blue Deck Created.");
		for(int i=1; i<=GeneralParameters.numberPurpleC; i++){
			Integer index = new Integer(i);
			purplecards.add(new PurpleC(index));
		} notifyLogMainView("Purple Deck Created.");
		for(int i=1; i<=GeneralParameters.numberExcommC; i++){
			Integer index = new Integer(i);
			this.excommcards.add(new Excommunications(index));	
		} notifyLogMainView("Excommunication Deck Created.");
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
	 * Insert excomm in board.
	 */
	private void insertExcommInBoard() {
		Collections.shuffle(excommcards);
		for(int excommPeriod=1; excommPeriod<=GeneralParameters.numberofExcommCells; excommPeriod++){
			Iterator<Excommunications> itr = excommcards.iterator();
			Excommunications excommcard = itr.next();
			while(itr.hasNext() && excommcard.getPeriod() != excommPeriod){
				excommcard = itr.next();
			}
			excommcards.add(excommcard);
			excommcards.remove(excommcard);
		}
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
				board.refreshBoard();
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
	 *
	 * @param players
	 *            the players
	 * @return the player who has won
	 */
	private PBoard winnerCalc(List<PBoard> players) {
		return null;
	}

	/**
	 * Handle the vatican report phase.
	 *
	 * @param age
	 *            the age
	 */
	private void VaticanReport(int age) {
		//Giri MVC
		/*
		 * Da qui dovrebbe partire una notify(credo message o parameter) alla View
		 */
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
	
	
	
	
	

}
