package it.polimi.ingsw.ps18.model.personalboard;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.gamelogic.Dice;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.gamelogic.GeneralParameters;
import it.polimi.ingsw.ps18.model.messages.ActionMessage;
import it.polimi.ingsw.ps18.model.messages.LogMessage;
import it.polimi.ingsw.ps18.model.messages.StatusMessage;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;
import it.polimi.ingsw.ps18.view.PBoardView;

public class PBoard extends Observable {
	PBoardView pBoardView;
	private int playercol;
	private Stats resources;
	private List<Cards> cards = new ArrayList<>();
	private List<FMember> fams = new ArrayList<>(GeneralParameters.nfamperplayer);
	
	
	public PBoard(int playercol, List<Dice> dices, MainController mcontroller){
		pBoardView = new PBoardView(mcontroller);
		addObserver(pBoardView);
		notifyLogPBoardView("Setup PBoard Player Number " + playercol + " Initiated.");
		this.playercol = playercol;
//		this.resources = new Stats(2,2,5,2,0,0,0);
		this.resources = new Stats(9,9,9,9,9,9,9);
		for(int i=0; i<dices.size(); i++){
			this.fams.add(new FMember(dices.get(i), playercol));
		} this.fams.add(new FMember(0,playercol));
		notifyLogPBoardView("Setup PBoard Player Number " + playercol + " Terminated.");
	}
	
	public PBoard(int playercol, List<Dice> dices){
		this.playercol = playercol;
		this.resources = new Stats(2,2,5,2,0,0,0);
		for(int i=0; i<dices.size(); i++){
			this.fams.add(new FMember(dices.get(i), playercol));
		} this.fams.add(new FMember(0,playercol));
	}
	
	public void actHarvest() {
		notifyStatusPBoardView("actHarvest");
	}
	
	public void actProduction() {
		notifyStatusPBoardView("actProduction");
	}
	
	public void addCard(Cards card, GameLogic game) {
		if(cards.add(card)){
			card.activateQEffects(this,game);
		}
		
	}
	public boolean hasSpace(int cardColor){
		if(cards.isEmpty())
			return true;
		else{
			int colorCount = 0;
			int playerMP = resources.getMP();
			
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
	
	public int vPCalc(){
		return playercol;
		
	}
	
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
	
	public String toStringResources(){
		StringBuilder builder = new StringBuilder();
		builder.append("Resources of player " + this.playercol + "\n");
		builder.append(this.resources.toString());
		return builder.toString();
		}
	
	public String toStringCards(){
		StringBuilder builder = new StringBuilder();
		List<Cards> cards = this.getCards();
		int count;
		builder.append("Cards of player " + this.playercol + ":\n-----------------\n");
		builder.append("Green Cards:\n");
		count = 1;
		for(Cards card: cards){
			if(card.getColor()==0){
				builder.append(card.toString(count));
			}
		}
		builder.append("\n-----------------\nBlue Cards:\n");
		count = 1;
		for(Cards card: cards){
			if(card.getColor()==1){
				builder.append(card.toString(count));
			}
		}
		builder.append("\n-----------------\nYellow Cards:\n");
		count = 1;
		for(Cards card: cards){
			if(card.getColor()==2){
				builder.append(card.toString(count));
			}
		}
		builder.append("\n-----------------\nPurple Cards:\n");
		count = 1;
		for(Cards card: cards){
			if(card.getColor()==3){
				builder.append(card.toString(count));
			}
		}
		return builder.toString();
	}
	
	private void notifyLogPBoardView(String msg){
		setChanged();
		notifyObservers(new LogMessage(msg));
	}
	
	private void notifyStatusPBoardView(String msg){
		setChanged();
		notifyObservers(new StatusMessage(msg));
	}

	/**
	 * @return the pBoardView
	 */
	public PBoardView getpBoardView() {
		return pBoardView;
	}

	/**
	 * @return the playercol
	 */
	public int getPlayercol() {
		return playercol;
	}

	/**
	 * @param playercol the playercol to set
	 */
	public void setPlayercol(int playercol) {
		this.playercol = playercol;
	}

	/**
	 * @return the resources
	 */
	public Stats getResources() {
		return resources;
	}

	/**
	 * @param resources the resources to set
	 */
	public void setResources(Stats resources) {
		this.resources = resources;
	}

	/**
	 * @return the cards
	 */
	public List<Cards> getCards() {
		return cards;
	}

	/**
	 * @param cards the cards to set
	 */
	public void setCards(List<Cards> cards) {
		this.cards = cards;
	}

	/**
	 * @return the fams
	 */
	public List<FMember> getFams() {
		return fams;
	}

	/**
	 * @param fams the fams to set
	 */
	public void setFams(List<FMember> fams) {
		this.fams = fams;
	}

}