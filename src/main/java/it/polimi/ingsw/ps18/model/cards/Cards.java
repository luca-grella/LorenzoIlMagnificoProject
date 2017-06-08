package it.polimi.ingsw.ps18.model.cards;

import java.util.ArrayList;
import java.util.List;

import it.polimi.ingsw.ps18.model.effect.quickEffect.QuickEffect;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

public abstract class Cards {
	private long ID;
	private String name;
	private long period;
	private long color;
	private Stats cardCost;
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
	public long getID() {
		return ID;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(long iD) {
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
	public long getPeriod() {
		return period;
	}

	/**
	 * @param period the period to set
	 */
	public void setPeriod(long period) {
		this.period = period;
	}

	/**
	 * @return the color
	 */
	public long getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(long color) {
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
