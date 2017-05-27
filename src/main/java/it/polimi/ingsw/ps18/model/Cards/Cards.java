package it.polimi.ingsw.ps18.model.cards;

import java.util.ArrayList;
import java.util.List;

import it.polimi.ingsw.ps18.model.effect.quickEffect.QuickEffect;
import it.polimi.ingsw.ps18.model.personalBoard.PBoard;
import it.polimi.ingsw.ps18.model.personalBoard.resources.Stats;

public abstract class Cards {
	private int ID;
	private String name;
	private int period;
	private int color;
	private Stats cardCost = new Stats(0,0,0,0,0,0,0);
	protected List<QuickEffect> effects = new ArrayList<>(); 
	
	public void activateQEffects(PBoard player){
		for(int i = 0 ; i < this.effects.size() ; i++){
			QuickEffect qeffect = this.effects.get(i);
			qeffect.activate(player);
		}
	}

	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the period
	 */
	public int getPeriod() {
		return period;
	}

	/**
	 * @param period the period to set
	 */
	public void setPeriod(int period) {
		this.period = period;
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
	 * @return the effects
	 */
	public List<QuickEffect> getEffects() {
		return effects;
	}

	/**
	 * @param effects the effects to set
	 */
	public void setEffects(List<QuickEffect> effects) {
		this.effects = effects;
	}

	/**
	 * @return the cardCost
	 */
	public Stats getCardCost() {
		return cardCost;
	}

	/**
	 * @param cardCost the cardCost to set
	 */
	public void setCardCost(Stats cardCost) {
		this.cardCost = cardCost;
	}
	
	

}
