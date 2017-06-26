package it.polimi.ingsw.ps18.model.personalboard;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.cards.Excommunications;
import it.polimi.ingsw.ps18.model.gamelogic.Dice;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.gamelogic.GeneralParameters;
import it.polimi.ingsw.ps18.model.messagesandlogs.ActionMessage;
import it.polimi.ingsw.ps18.model.messagesandlogs.LogMessage;
import it.polimi.ingsw.ps18.model.messagesandlogs.StatusMessage;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;
import it.polimi.ingsw.ps18.view.PBoardView;

/**
 * The Class PBoard.
 */
public class PBoard extends Observable {
	
	/**
	 * The p board view.
	 */
	PBoardView pBoardView;
	
	/**
	 * The playercol.
	 */
	private int playercol;
	
	/**
	 * The resources.
	 */
	private Stats resources;
	
	/**
	 * The cards.
	 */
	private List<Cards> cards = new ArrayList<>();
	
	/**
	 * the excomm Cards
	 */
	private List<Excommunications> excommCards = new ArrayList<>();
	/**
	 * The fams.
	 */
	private List<FMember> fams = new ArrayList<>(GeneralParameters.nfamperplayer);
	
	
	public PBoard(int playercol){
		this.playercol = playercol;
	}
	
	public void completePBoardSetup(List<Dice> dices, MainController mcontroller, List<Cards> BonusTiles){
		notifyLogPBoardView("Setup PBoard Player Number " + playercol + " Initiated.");
		pBoardView = new PBoardView(mcontroller);
		addObserver(pBoardView);
//		this.resources = new Stats(2,2,5,2,0,0,0);
		this.resources = new Stats(9,9,9,9,9,9,9);
		for(int i=0; i<dices.size(); i++){
			this.fams.add(new FMember(dices.get(i), playercol));
		} this.fams.add(new FMember(0,playercol));
		notifyActionPBoardView("ChooseBonusTile");
		notifyLogPBoardView("Setup PBoard Player Number " + playercol + " Terminated.");
		
	}
	
	/**
	 * Instantiates a new p board.
	 *
	 * @param playercol
	 *            the playercol
	 * @param dices
	 *            the dices
	 */
	public PBoard(int playercol, List<Dice> dices){
		this.playercol = playercol;
		this.resources = new Stats(2,2,5,2,0,0,0);
		for(int i=0; i<dices.size(); i++){
			this.fams.add(new FMember(dices.get(i), playercol));
		} this.fams.add(new FMember(0,playercol));
	}
	
	/**
	 * Instantiates a new p board.
	 */
	public PBoard(){
		pBoardView = null;
		playercol = 0;
		resources = null;
		cards = null;
		fams = null;
	}
	
	/**
	 * Act harvest.
	 */
	public void actHarvest() {
		notifyStatusPBoardView("actHarvest");
	}
	
	/**
	 * Act production.
	 */
	public void actProduction() {
		notifyStatusPBoardView("actProduction");
	}
	
	/**
	 * Adds the card.
	 *
	 * @param card
	 *            the card
	 * @param game
	 *            the game
	 */
	public void addCard(Cards card, GameLogic game) {
		if(cards.add(card)){
			card.activateQEffects(this,game);
		}
		
	}
	
	/**
	 * Checks for space.
	 *
	 * @param cardColor
	 *            the card color
	 * @return true, if successful
	 */
	public boolean hasSpace(int cardColor){
		if(cards.isEmpty())
			return true;
		else{
			int colorCount = 0;
			
			for(int cardIndex=0; cardIndex<this.cards.size(); cardIndex++){
				if((cards.get(cardIndex)).getColor() == cardColor){
					colorCount++;
				}
			}
			if(cardColor != 0){
				if(colorCount < 6)
					return true;
				else
					return false;
			}
			/*
			 * TODO: Else molto meccanico, se possibile sistemare
			 */
			else{
				int futureCount = colorCount+1;
				if(futureCount<=2){
					return true;
				} else if(futureCount == 3){
					if((this.getResources()).getMP() >= 3){
						return true;
					}
				} else if(futureCount == 4){
					if((this.getResources()).getMP() >= 7){
						return true;
					}
				} else if(futureCount == 5){
				    if((this.getResources()).getMP() >= 12){
						return true;
					}
				} else if(futureCount == 6){
				    if((this.getResources()).getMP() >= 18){
						return true;
					}
				} 
				return false;
			}
		}
	}
	
	/**
	 * V P calc.
	 *
	 * @return the int
	 */
	public int vPCalc(){
		return playercol;
		
	}
	
	/**
	 * To string fams.
	 */
	public void toStringFams(){
		StringBuilder builder = new StringBuilder();
		List<FMember> fams = this.getFams();
		builder.append("-----------------\n");
		for(int i=0; i<this.fams.size(); i++){
			if((fams.get(i))!=null){
				FMember fam = fams.get(i);
				builder.append("Family Member " + i + ":\n");
				builder.append(fam.toString());
				builder.append("\n\n");
			} else {
				builder.append("Family Member Already Used\n\n.");
			}
		} builder.append("-----------------\n");
		notifyLogPBoardView(builder.toString());
	}
	
	/**
	 * To string resources.
	 *
	 * @return the string
	 */
	public String toStringResources(){
		StringBuilder builder = new StringBuilder();
		builder.append("Resources of player " + this.playercol + "\n");
		builder.append(this.resources.toString());
		return builder.toString();
		}
	
	/**
	 * To string cards.
	 *
	 * @return the string
	 */
	public String toStringCards(){
		StringBuilder builder = new StringBuilder();
		List<Cards> cards = this.getCards();
		int count;
		builder.append("Cards of player " + this.playercol + ":\n-----------------\n");
		
		builder.append("Bonus Tiles:\n");
		count = 1;
		for(Cards card: cards){
			if(card.getColor()==-1){
				builder.append(card.toString(count));
				count++;
			}
		}
		builder.append("\n-----------------\nGreen Cards:\n");
		count = 1;
		for(Cards card: cards){
			if(card.getColor()==0){
				builder.append(card.toString(count));
				count++;
			}
		}
		builder.append("\n-----------------\nBlue Cards:\n");
		count = 1;
		for(Cards card: cards){
			if(card.getColor()==1){
				builder.append(card.toString(count));
				count++;
			}
		}
		builder.append("\n-----------------\nYellow Cards:\n");
		count = 1;
		for(Cards card: cards){
			if(card.getColor()==2){
				builder.append(card.toString(count));
				count++;
			}
		}
		builder.append("\n-----------------\nPurple Cards:\n");
		count = 1;
		for(Cards card: cards){
			if(card.getColor()==3){
				builder.append(card.toString(count));
				count++;
			}
		}
		builder.append("\n-----------------\n");
		return builder.toString();
	}
	
	/**
	 * Notify log P board view.
	 *
	 * @param msg
	 *            the msg
	 */
	private void notifyLogPBoardView(String msg){
		setChanged();
		notifyObservers(new LogMessage(msg));
	}
	
	/**
	 * Notify status P board view.
	 *
	 * @param msg
	 *            the msg
	 */
	private void notifyStatusPBoardView(String msg){
		setChanged();
		notifyObservers(new StatusMessage(msg));
	}
	
	private void notifyActionPBoardView(String msg){
		setChanged();
		notifyObservers(new ActionMessage(msg));
	}

	/**
	 * Gets the p board view.
	 *
	 * @return the pBoardView
	 */
	public PBoardView getpBoardView() {
		return pBoardView;
	}

	/**
	 * Gets the playercol.
	 *
	 * @return the playercol
	 */
	public int getPlayercol() {
		return playercol;
	}

	/**
	 * Sets the playercol.
	 *
	 * @param playercol
	 *            the playercol to set
	 */
	public void setPlayercol(int playercol) {
		this.playercol = playercol;
	}

	/**
	 * Gets the resources.
	 *
	 * @return the resources
	 */
	public Stats getResources() {
		return resources;
	}

	/**
	 * Sets the resources.
	 *
	 * @param resources
	 *            the resources to set
	 */
	public void setResources(Stats resources) {
		this.resources = resources;
	}

	/**
	 * Gets the cards.
	 *
	 * @return the cards
	 */
	public List<Cards> getCards() {
		return cards;
	}

	/**
	 * Sets the cards.
	 *
	 * @param cards
	 *            the cards to set
	 */
	public void setCards(List<Cards> cards) {
		this.cards = cards;
	}

	/**
	 * Gets the fams.
	 *
	 * @return the fams
	 */
	public List<FMember> getFams() {
		return fams;
	}

	/**
	 * Sets the fams.
	 *
	 * @param fams
	 *            the fams to set
	 */
	public void setFams(List<FMember> fams) {
		this.fams = fams;
	}

	/**
	 * @return the excommCards
	 */
	public List<Excommunications> getExcommCards() {
		return excommCards;
	}
	
	

}