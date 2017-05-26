package it.polimi.ingsw.ps18.model.personalBoard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.effect.quickEffect.QuickEffect;
import it.polimi.ingsw.ps18.model.gameLogic.Dice;
import it.polimi.ingsw.ps18.model.gameLogic.GeneralParameters;
import it.polimi.ingsw.ps18.model.personalBoard.resources.Stats;

public class PBoard {
	private int playercol;
	private Stats resources;
	private List<Cards> cards = new ArrayList<>();
	private List<FMember> fams = new ArrayList<>(4);
	
	
	public PBoard(int playercol, List<Dice> dices){
		this.playercol = playercol;
		this.resources = new Stats(2,2,5,2,0,0,0);
		for(int i=0; i<dices.size(); i++){
			this.fams.add(new FMember(dices.get(i), playercol));
		} this.fams.add(new FMember(0,playercol));
		
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
	
	public FMember chooseFam(Scanner input){
		System.out.println("I familiari a tua disposizione sono:");
		System.out.println(this.toString(this.fams));
		System.out.println("Scegli il familiare.");
		int choice = input.nextInt();
		return this.fams.get(choice);
	}
	
	public void privilege(){
		
	}
	
	public String toString(List<FMember> fams){
		StringBuilder builder = new StringBuilder();
		builder.append("-----------------\n");
		for(int i=0; i<GeneralParameters.nfamperplayer; i++){
			FMember fam = fams.get(i);
			builder.append(i + ". Color: " + fam.getColor() + "Value: " + fam.getValue() + "\n");
		} builder.append("-----------------\n");
		return builder.toString();
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
	
	
	

}