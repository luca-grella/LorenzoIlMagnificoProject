package it.polimi.ingsw.ps18.Model.PBoard;

import java.util.ArrayList;

import it.polimi.ingsw.ps18.Model.Cards.Cards;
import it.polimi.ingsw.ps18.Model.Effect.QuickEffect.QuickEffect;
import it.polimi.ingsw.ps18.Model.PBoard.Resources.Stats;

public class PBoard {
	private Stats resources;
	private ArrayList<Cards> cards = new ArrayList<Cards>();
	
	
	public PBoard(){
		this.resources = new Stats(0,0,0,0,0,0,0);
	}
	
	
	public Stats getStats(){
		return this.resources;
	}
	
	
	public synchronized void addCard(Cards card){
		cards.add(card);
		for(int i = 0 ; i < 2 ; i++){
			QuickEffect qeffect = card.effects.get(i);
			qeffect.activate(this);
		}
	}
	
	public synchronized void printRes(PBoard player){
		System.out.println("Coins: " + player.resources.getCoin());
		System.out.println("Wood: " + player.resources.getWood());
		System.out.println("Rock: " + player.resources.getRock());
		System.out.println("Servants: " + player.resources.getServants());
		System.out.println("FP: " + player.resources.getFP());
		System.out.println("MP: " + player.resources.getMP());
		System.out.println("VP: " + player.resources.getVP());
	}
	

}