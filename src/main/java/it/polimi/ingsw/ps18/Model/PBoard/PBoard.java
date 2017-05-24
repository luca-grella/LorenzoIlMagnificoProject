package it.polimi.ingsw.ps18.Model.PBoard;

import java.util.ArrayList;
import java.util.List;

import it.polimi.ingsw.ps18.Model.Cards.Cards;
import it.polimi.ingsw.ps18.Model.Effect.QuickEffect.QuickEffect;
import it.polimi.ingsw.ps18.Model.PBoard.Resources.Stats;

public class PBoard {
	private int color;
	private Stats resources;
	private List<Cards> cards = new ArrayList<>();
	
	
	public PBoard(int color){
		this.color = color;
		this.resources = new Stats(2,2,5,2,0,0,0);
	}
	
	
	public void addCard(Cards card){
		this.cards.add(card);
		for(int i=0; i<2; i++){
			QuickEffect effect = card.effects.get(i);
			effect.activate(this);
		}
	}
	
	public void printResources(){
		System.out.println(this.resources.toString());
	}

	/**
	 * @return the color
	 */
	public int getColor() {
		return color;
	}


	/**
	 * @param color the color to set
	 */
	public void setColor(int color) {
		this.color = color;
	}


	/**
	 * @return the resources
	 */
	public Stats getResources() {
		return resources;
	}
	
	

}