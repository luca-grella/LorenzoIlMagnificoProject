package it.polimi.ingsw.ps18.model.gamelogic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Random;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.controller.controlleractions.HashMapActions;
import it.polimi.ingsw.ps18.model.board.Board;
import it.polimi.ingsw.ps18.model.board.boardcells.CouncilCell;
import it.polimi.ingsw.ps18.model.board.boardcells.Tower;
import it.polimi.ingsw.ps18.model.cards.BlueC;
import it.polimi.ingsw.ps18.model.cards.BonusTile;
import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.cards.Excommunications;
import it.polimi.ingsw.ps18.model.cards.GreenC;
import it.polimi.ingsw.ps18.model.cards.LeaderCards;
import it.polimi.ingsw.ps18.model.cards.PurpleC;
import it.polimi.ingsw.ps18.model.cards.YellowC;
import it.polimi.ingsw.ps18.model.effect.excommEffects.*;
import it.polimi.ingsw.ps18.model.effect.finalEffect.FinalEffect;
import it.polimi.ingsw.ps18.model.effect.finalEffect.HashMapFE;
import it.polimi.ingsw.ps18.model.effect.finalEffect.HashMapVPBlue;
import it.polimi.ingsw.ps18.model.effect.finalEffect.HashMapVPGreen;
import it.polimi.ingsw.ps18.model.effect.generalEffects.GeneralEffect;
import it.polimi.ingsw.ps18.model.effect.generalEffects.WoodorRockEffects;
import it.polimi.ingsw.ps18.model.effect.generalEffects.addVP;
import it.polimi.ingsw.ps18.model.effect.harvestEffect.HashMapHE;
import it.polimi.ingsw.ps18.model.effect.leaderEffects.ChoiceLeaderEffect;
import it.polimi.ingsw.ps18.model.effect.quickEffect.HashMapQE;
import it.polimi.ingsw.ps18.model.messagesandlogs.ActionMessage;
import it.polimi.ingsw.ps18.model.messagesandlogs.LogMessage;
import it.polimi.ingsw.ps18.model.messagesandlogs.StatusMessage;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;
import it.polimi.ingsw.ps18.model.personalboard.resources.VictoryPoints;
import it.polimi.ingsw.ps18.view.IdleViewThread;
import it.polimi.ingsw.ps18.view.MainView;


/**
 * The Class GameLogic.
 *
 * @author Francesco-Musio
 * @author yazan-matar
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
	private LinkedList<PBoard> players = new LinkedList<>();
	
	
	private LinkedList<PBoard> recoverTurn = new LinkedList<>();
 	
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
	
	private List<LeaderCards> leadercards = new ArrayList<>(GeneralParameters.numberOfLeaderCards);
	
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
	
	private WoodorRockEffects ongoingWREffect;
	
	private ChoiceLeaderEffect ongoingLCEffect;
	
	private ConfirmHandler requester;
	
	
	/**
	 * Initialize the game.
	 *
	 * @param nplayer
	 *            set the number of players this game has
	 * @param mController
	 *            the m controller
	 */
	public GameLogic(int nplayer,MainController mController, LinkedList<PBoard> players){
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
		insertExcommInBoard();
		notifyLogMainView("Excommunications Inserted in Board.");
//		distributeLC();
//		Collections.shuffle(players); //initial order
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
			
			obj = parser.parse(new FileReader("src/main/java/it/polimi/ingsw/ps18/model/cards/LeaderCards.json"));
	    	jsonObject = (JSONObject) obj;
			for(int i=1; i<=GeneralParameters.numberOfLeaderCards; i++){
				Integer index = new Integer(i);
				this.leadercards.add(new LeaderCards((JSONObject) jsonObject.get(index.toString())));
			} notifyLogMainView("Leader Cards Deck Created.");
	        
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
	 * @return 
	 */
	private void insertExcommInBoard() {

		Collections.shuffle(this.excommcards);
		for(int excommPeriod=1; excommPeriod<=GeneralParameters.numberofExcommCells; excommPeriod++){
			Iterator<Excommunications> itr = excommcards.iterator();
			Excommunications excommcard = itr.next();
			while(itr.hasNext() && excommcard.getPeriod() != excommPeriod){
				excommcard = itr.next();
			}
			this.board.getExcommCells().add(excommcard);
		}
	}
	
	public void distributeLC(){
		Collections.shuffle(leadercards);
		List<LeaderCards> group1 = new ArrayList<>();
		List<LeaderCards> group2 = new ArrayList<>();
		List<LeaderCards> group3 = new ArrayList<>();
		List<LeaderCards> group4 = new ArrayList<>();
		for(int i=0, count=0; i<nplayer*GeneralParameters.numberOfLCperPlayer; i++){
			if(i%GeneralParameters.numberOfLCperPlayer==0){
				count++;
			}
			switch(count){
			case 1:
				group1.add(leadercards.get(i));
				break;
			case 2:
				group2.add(leadercards.get(i));
				break;
			case 3:
				group3.add(leadercards.get(i));
				break;
			case 4:
				group4.add(leadercards.get(i));
				break;
			}
		}
		for(int i=0; i<GeneralParameters.numberOfLCperPlayer; i++){
			int count = 0;
			if(count<nplayer){
				if(i+count>=nplayer){
					int temp = i+count-nplayer;
					System.out.println("gruppo 1");
					this.turnplayer = players.get(temp);
					players.get(temp).takeLeader(group1);
				} else {
					System.out.println("gruppo 1");
					this.turnplayer = players.get(i+count);
					players.get(i + count).takeLeader(group1);
				}
			}
			count++;
			if(count<nplayer){
				if(i+count>=nplayer){
					int temp = i+count-nplayer;
					//in 2 giocatori la funzione genera un index out of bound poichè temp risulta uguale a 2.
					if(temp>=nplayer){
						temp -= 1;
					}
					System.out.println("gruppo 2");
					this.turnplayer = players.get(temp);
					players.get(temp).takeLeader(group2);
				} else {
					System.out.println("gruppo 2");
					this.turnplayer = players.get(i+count);
					players.get(i + count).takeLeader(group2);
				}
			}
			count++;
			if(count<nplayer){
				if(i+count>=nplayer){
					int temp = i+count-nplayer;
					System.out.println("gruppo 3");
					this.turnplayer = players.get(temp);
					players.get(temp).takeLeader(group3);
				} else {
					System.out.println("gruppo 3");
					this.turnplayer = players.get(i+count);
					players.get(i + count).takeLeader(group3);
				}
			}
			count++;
			if(count<nplayer){
				if(i+count>=nplayer){
					int temp = i+count-nplayer;
					System.out.println("gruppo 4");
					this.turnplayer = players.get(temp);
					players.get(temp).takeLeader(group4);
				} else {
					System.out.println("gruppo 4");
					this.turnplayer = players.get(i+count);
					players.get(i + count).takeLeader(group4);
				}
			}
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
			this.recoverTurn.clear();

//			for(PBoard player: this.players){
//				if(player.getPlayercol()!=players.get(0).getPlayercol()){
//					player.getIdleviewthread().start();
//				}
//			}
			LinkedList<PBoard> templist = excommOrder();
			for(PBoard player: this.players){
				for(LeaderCards card: player.getLeadercards()){
					card.setEffectactivated(false);
				}
			}
			for(int playerIndex=0; playerIndex<templist.size(); playerIndex++){
				this.turnplayer = templist.get(playerIndex);
//				if(playerIndex!=0){
//					turnplayer.getIdleviewthread().close();
//				}
				for(PBoard player: this.players){
					if(player.getPlayercol()!=turnplayer.getPlayercol()){
						player.notifyLogPBoardView(toStringGame(player.getPlayercol()));
					}
				}
				notifyActionMainView("Turn Handle Init");
//				turnplayer.getIdleviewthread().start();
			}
			for(int famIndex=1; famIndex<GeneralParameters.nfamperplayer; famIndex++){
				for(int playerIndex=0; playerIndex<nplayer; playerIndex++){
					this.turnplayer = players.get(playerIndex);
					for(PBoard player: this.players){
						if(player.getPlayercol()!=turnplayer.getPlayercol()){
							player.notifyLogPBoardView(toStringGame(player.getPlayercol()));
						}
					}
					notifyActionMainView("Turn Handle Init");
				}
			}
			if(! this.recoverTurn.isEmpty()){
				for(int recover=0; recover<this.recoverTurn.size(); recover++){
					this.turnplayer = this.recoverTurn.get(recover);
					for(PBoard player: this.players){
						if(player.getPlayercol()!=turnplayer.getPlayercol()){
							player.notifyLogPBoardView(toStringGame(player.getPlayercol()));
						}
					}
					notifyActionMainView("Turn Handle Init");
				}
			}

			if(TURN%2==0){		
				for(int playerIndex=0; playerIndex<this.players.size(); playerIndex++){
					this.setCurrentPlayer(this.players.get(playerIndex));
					notifyActionMainController("Verify Church Support");
					
				}
				this.AGE++;
			}
			newOrder();
			this.refreshGame();

		} while (TURN!=GeneralParameters.totalTurns);
		
		List<PBoard> placement = finalScore(players);
		notifyLogMainView(this.toStringPlayers(placement));

		//System.out.println("Do you want to play again? Y|N");
		String answer = input.nextLine();
		if("Y".equalsIgnoreCase(answer)){
			return true;
		}
		return false;
	}
	
	public String toStringGame(int playercol){
		StringBuilder builder = new StringBuilder();
		builder.append("TOWERS:\n");
		for(int i=0; i<board.getTowers().size(); i++){
			builder.append(board.getTowers().get(i).toString(i));
		}
		builder.append("\nMARKET:\n");
		for(int i=0; i<board.getMarketCells().size(); i++){
			builder.append(board.getMarketCells().get(i).toString(i));
		}
		builder.append("\nHARVEST:\n");
		builder.append(board.toStringHarvest());
		builder.append("\nPRODUCTION:\n");
		builder.append(board.toStringProduction());
		builder.append("\nCOUNCIL:\n");
		builder.append(board.toStringCouncil());
		builder.append("\nEXCOMMUNICATIONS:\n");
		builder.append(board.toStringExcomm());
		for(PBoard player: players){
			if(player.getPlayercol()!=playercol){
				builder.append("\n\nPLAYER " + player.getPlayercol() + ":\n");
				builder.append("FAMILY MEMBERS:\n" + player.toStringFams()
				               + "RESOURCES:\n" + player.toStringResources()
				               + "CARDS:\n" + player.toStringCards());
			}
		}
		return builder.toString();
	}
	
	/*
	 * TODO: magari evitare che mi stampi tutta la lista di roba inutile, per il resto funziona
	 */
	public String toStringPlayers(List<PBoard> players){
		StringBuilder builder = new StringBuilder();
		String placement[] = {"Winner", "Second", "Third", "Fourth"};
		
		builder.append("\n-----------------\n");
		builder.append("\nFinal Placement:\n\n");
		for(int playerIndex=0; playerIndex<players.size(); playerIndex++){
			PBoard player = players.get(playerIndex);
			builder.append(placement[playerIndex] + ": player " + player.getPlayercol() 
							+ " with " + player.getResources().getVP() 
							+ " Victory Points!\n");
		}
		return builder.toString();
	}
	
	
	
	public void refreshGame(){
		for(int diceIndex=0; diceIndex<GeneralParameters.numberofDices; diceIndex++){
			this.dices.set(diceIndex, new Dice(diceIndex));
		}
		for(int playerIndex=0; playerIndex<this.players.size(); playerIndex++){
			this.players.get(playerIndex).refreshFMembers(dices);
		}
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
	private List<PBoard> finalScore(List<PBoard> players) {
		for(int playerIndex=0; playerIndex<players.size(); playerIndex++){
			PBoard currentplayer = players.get(playerIndex);
			boolean considerBlueCards = true;
			boolean considerPurpleCards = true;
			boolean considerGreenCards = true;
			for(Excommunications card: currentplayer.getExcommCards()){
				for(ExcommEffects effect: card.getEffects()){
					if("IgnoreCards".equals(effect.getName())){
						if("Blue".equals(((IgnoreCards) effect).getName())){
							considerBlueCards = false;
						} else if("Purple".equals(((IgnoreCards) effect).getName())){
							considerPurpleCards = false;
						} else if("Green".equals(((IgnoreCards) effect).getName())){
							considerGreenCards = false;
						}
					} else if("LoseVPforVP".equals(effect.getName())){
						((LoseVPforVP) effect).activate(currentplayer);
					} else if("LoseVPforMP".equals(effect.getName())){
						((LoseVPforMP) effect).activate(currentplayer);
					} else if("LoseVpforCosts".equals(effect.getName())){
						((LoseVPforCosts) effect).activate(currentplayer);
					} else if("LoseVPforResources".equals(effect.getName())){
						((LoseVPforResources) effect).activate(currentplayer);
					}
				}
			}
			
			
			List<Cards> cards = currentplayer.getCards();
			Iterator<Cards> itr = cards.iterator();
			Cards playerCard = itr.next();
			int greenCount=0;
			int blueCount=0;
			while(itr.hasNext()) {
				if(playerCard.getColor() == 0)
					greenCount++;
			    else if(playerCard.getColor() == 1)
			    	blueCount++;
			    else if(playerCard.getColor() == 3){
			    	if(considerPurpleCards){
			    		HashMapFE map = new HashMapFE();
				    	FinalEffect finalEffect = map.geteffect("AddPV");
				    	finalEffect.activate(currentplayer, this);
			    	}
			    }
			    playerCard = itr.next();
			}
			
			
			if(considerGreenCards){
				HashMapVPGreen greenMap = new HashMapVPGreen();
				Integer greenVP = greenMap.getGenVPGEffect(greenCount);
				currentplayer.getResources().addVP(greenVP);
			}
			
			
			if(considerBlueCards){
				HashMapVPBlue blueMap = new HashMapVPBlue();
				Integer blueVP = blueMap.getGenVPBEffect(blueCount);
				currentplayer.getResources().addVP(blueVP);
			}
			
			
			Stats resources = currentplayer.getResources();
			int totalRes = resources.getCoin() + resources.getRock() + resources.getServants() + resources.getWood();
			currentplayer.getResources().addVP(totalRes/5);
		}
		
		List<PBoard> turnOrder = new LinkedList<>();
		/*
		 * Si salva l'ordine dei giocatori prima di ordinarli in base al punteggio
		 * perche' in caso di pareggio in VP, vince chi e' piu' avanti nell'ordine del turno
		 */

		turnOrder.addAll(players);
		
		for(int playerIndex = 0; playerIndex<turnOrder.size(); playerIndex++){
			PBoard player = turnOrder.get(playerIndex);
			player.setPriorityValue(playerIndex);
		}
		
		
		Collections.sort(players);

		
		//TODO:  dare un'occhiata ai controlli sugli MP che potrebbero non essere corretti per tutte le casistiche
		PBoard winner = players.get(0);
		winner.getResources().addVP(5);
		
		for(int playerIndex=1; playerIndex<players.size()-1; playerIndex++){
		
			PBoard currentplayer = players.get(playerIndex);
			PBoard nextplayer = players.get(playerIndex+1);
			if(winner.getResources().getMP() == currentplayer.getResources().getMP()) {
				currentplayer.getResources().addVP(5);
			}
			else if(nextplayer != null) {
				if(currentplayer.getResources().getMP() == nextplayer.getResources().getMP()){
					if(playerIndex == 1){ 
						/*
						 * perche' se e' superiore a 1 vuol dire che ci sono due che hanno pareggiato al primo posto
						 * e quindi chiunque arrivi secondo non si becca niente per il regolamento
						 */
						currentplayer.getResources().addVP(2);
						nextplayer.getResources().addVP(2);
					}
					else{
						if(winner.getResources().getMP() != players.get(1).getResources().getMP()){
							/*
							 * Se sono uguali, allora ci sono 2 al primo posto e quindi balza
							 * il controllo perche' in questo caso i secondi non prendono punti
							 */
							PBoard second = players.get(1);
							if(second.getResources().getMP() == currentplayer.getResources().getMP()){
//								currentplayer.getResources().addVP(2);
								nextplayer.getResources().addVP(2);
							}
						}
					}
				}
				else{
					if(playerIndex == 1)
						currentplayer.getResources().addVP(2);
				}
			}
		}
		
		for(PBoard player : players){
			if(player.getResources().getVP() <= 0){
				player.getResources().setVp(new VictoryPoints(0));
			}
		}
		
		Collections.sort(players, PBoard.victoryComparator);
			
		for(int i=1; i<players.size(); i++){
			for(int j=i; j>0; j--){
				PBoard currentplayer = players.get(j);
				PBoard previousplayer = players.get(j-1);
				if(currentplayer.getResources().getVP() == previousplayer.getResources().getVP()){
					if(currentplayer.getPriorityValue() < previousplayer.getPriorityValue()){
						Collections.swap(players, j, j-1);
					}
				}
			}
		}
		return players;
	}
	
	public void newOrder(){
		List<Integer> order = new ArrayList<>(nplayer);
		for(CouncilCell cell: this.board.getCouncilCells()){
			int playercolor = cell.getCouncilCellFM().getPlayercol();
			if(! order.contains(playercolor)){
				order.add(playercolor);
			}
		}
		Collections.reverse(order);
		for(Integer playercol: order){
			for(int i=0; i<this.players.size(); i++){
				if(this.players.get(i).getPlayercol() == playercol){
					PBoard temp = this.players.get(i);
					players.remove(i);
					players.addFirst(temp);
				}
			}
		}
	}
	
	private LinkedList<PBoard> excommOrder(){
		LinkedList<PBoard> tempOrder = new LinkedList<>();
		tempOrder.addAll(players);
		List<Integer> toremove = new ArrayList<>();
		for(int i=0; i<this.nplayer; i++){
			PBoard player = tempOrder.get(i);
			for(Excommunications card: player.getExcommCards()){
				for(ExcommEffects effect: card.getEffects()){
					if("MalusValue".equals(effect.getName())){
						if("TurnOrder".equals(((MalusValue) effect).getPlace())){
							toremove.add(i);
						}
					}
				}
			}
		}
		Collections.reverse(toremove);
		for(int i=0; i<toremove.size(); i++){
			this.recoverTurn.addFirst(tempOrder.get((int) toremove.get(i)));
			tempOrder.remove((int) toremove.get(i));
		}
		return tempOrder;
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

	public void setOngoingWREffect(WoodorRockEffects woodorRockEffects) {
		this.ongoingWREffect = woodorRockEffects;
	}

	/**
	 * @return the ongoingWREffect
	 */
	public WoodorRockEffects getOngoingWREffect() {
		return ongoingWREffect;
	}

	/**
	 * @return the ongoingLCEffect
	 */
	public ChoiceLeaderEffect getOngoingLCEffect() {
		return ongoingLCEffect;
	}

	/**
	 * @param ongoingLCEffect the ongoingLCEffect to set
	 */
	public void setOngoingLCEffect(ChoiceLeaderEffect ongoingLCEffect) {
		this.ongoingLCEffect = ongoingLCEffect;
	}

	/**
	 * 
	 */
	public void setBoard(Board board) {
		this.board = board;
	}
		
    /*
	 * @return the requester
	 */
	public ConfirmHandler getRequester() {
		return requester;
	}

	/**
	 * @param requester the requester to set
	 */
	public void setRequester(ConfirmHandler requester) {
		this.requester = requester;
	}

	/**
	 * @return the dices
	 */
	public List<Dice> getDices() {
		return dices;
	}

	/**
	 * 
	 */
	public void setExcommcards(List<Excommunications> excommcards) {
		this.excommcards = excommcards;
		
	}

	/**
	 * 
	 */
	public void setAGE(int AGE) {
		this.AGE=AGE;
		
	}
	
	
	
	
	
	
	
	

}
