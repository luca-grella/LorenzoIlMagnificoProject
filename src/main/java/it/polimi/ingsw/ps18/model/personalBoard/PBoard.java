package it.polimi.ingsw.ps18.model.personalBoard;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Scanner;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.gameLogic.Dice;
import it.polimi.ingsw.ps18.model.gameLogic.GeneralParameters;
import it.polimi.ingsw.ps18.model.messages.LogMessage;
import it.polimi.ingsw.ps18.model.personalBoard.resources.Stats;
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
		this.resources = new Stats(2,2,5,2,0,0,0);
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
	
	private void notifyLogPBoardView(String msg){
		setChanged();
		notifyObservers(new LogMessage(msg));
	}
	
	
	public Stats getStats(){
		return this.resources;
	}
	
	
	public void addCard(Cards card){
		System.out.println("Risorse pre attivazione carta.");
		System.out.println(this.toString(this.getStats()));
		cards.add(card);
		System.out.println("Attivazione effetto della carta. Risorse post attivazione");
		card.activateQEffects(this);
		System.out.println(this.toString(this.getStats()));
	}
	
	public void privilege(){
		
	}
	
	public int vPCalc(){
		return playercol;
		
	}
	
	public void toString(List<FMember> fams){
		StringBuilder builder = new StringBuilder();
		builder.append("-----------------\n");
		for(int i=0; i<GeneralParameters.nfamperplayer; i++){
			FMember fam = fams.get(i);
			builder.append(i + ". Color: " + fam.getColor() + "Value: " + fam.getValue() + "\n");
		} builder.append("-----------------\n");
		notifyLogPBoardView(builder.toString());
	}
	
	public String toString(Stats resources){
		StringBuilder builder = new StringBuilder();
		builder.append("-----------------\n");
		builder.append("Wood: " + resources.getWood() + "\n");
		builder.append("Rock: " + resources.getRock() + "\n");
		builder.append("Coin: " + resources.getCoin() + "\n");
		builder.append("Servant: " + resources.getServants() + "\n");
		builder.append("FP: " + resources.getFP() + "\n");
		builder.append("MP: " + resources.getMP() + "\n");
		builder.append("VP: " + resources.getVP() + "\n");
		builder.append("-----------------\n");
		return builder.toString();
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