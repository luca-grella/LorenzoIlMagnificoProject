package it.polimi.ingsw.ps18.model.gamelogic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;
import java.util.Scanner;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.board.Board;
import it.polimi.ingsw.ps18.model.board.boardcells.Tower;
import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.cards.GreenC;
import it.polimi.ingsw.ps18.model.cards.PurpleC;
import it.polimi.ingsw.ps18.model.effect.generalEffects.GeneralEffect;
import it.polimi.ingsw.ps18.model.messages.ActionMessage;
import it.polimi.ingsw.ps18.model.messages.LogMessage;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.view.MainView;



public class GameLogic extends Observable {
	MainView mView;
	Scanner input = new Scanner(System.in);
	
	private int TURN = 0;
	private int AGE = 1;
	private int nplayer;
	private Board board;
	private List<PBoard> players = new ArrayList<>(nplayer);
	private PBoard turnplayer;
	private List<Cards> greencards = new ArrayList<>(GeneralParameters.numberGreenC);
	private List<Cards> bluecards = new ArrayList<>(GeneralParameters.numberBlueC);
	private List<Cards> yellowcards = new ArrayList<>(GeneralParameters.numberYellowC);
	private List<Cards> purplecards = new ArrayList<>(GeneralParameters.numberPurpleC);
	private List<Dice> dices = new ArrayList<>(GeneralParameters.numberofDices);
	private Action ongoingAction;
	private GeneralEffect ongoingEffect;
	
	
	/**
	 * Initialize the game
	 * @param nplayer set the number of players this game has
	 * @param controller 
	 */
	public GameLogic(int nplayer,MainController mController){
		this.nplayer = nplayer;
		mView = new MainView(mController);
		addObserver(mView);
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
		this.board = new Board(mainController);
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
		Collections.shuffle(players); //initial order
		notifyLogMainView("Player Order Shuffled.");
		notifyLogMainView("Setup Terminated.");
	}
	
	private void genDeck(){
		for(int i=1; i<=GeneralParameters.numberGreenC; i++){
			Integer index = new Integer(i);
			this.greencards.add(new GreenC(index));	
		} notifyLogMainView("Green Deck Created.");
		for(Integer i=1; i<=GeneralParameters.numberYellowC; i++){
			//yellowcards.add(new YellowC(i.toString()));
		} notifyLogMainView("Yellow Deck Created.");
		for(Integer i=1; i<=GeneralParameters.numberBlueC; i++){
			//bluecards.add(new BlueC(i.toString()));
		} notifyLogMainView("Blue Deck Created.");
		for(int i=1; i<=GeneralParameters.numberPurpleC; i++){
			Integer index = new Integer(i);
			purplecards.add(new PurpleC(index));
		} notifyLogMainView("Purple Deck Created.");
	}
	
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
//			case 2:
//				singletower.insertCards(yellowcards, AGE);
//				break;
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

	
	
	

}
