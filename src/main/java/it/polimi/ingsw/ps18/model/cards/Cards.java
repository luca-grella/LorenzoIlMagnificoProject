package it.polimi.ingsw.ps18.model.cards;

import java.util.ArrayList;
import java.util.List;

import it.polimi.ingsw.ps18.model.effect.quickEffect.QuickEffect;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

// TODO: Auto-generated Javadoc
/**
 * The Class Cards.
 */
public abstract class Cards {
	
	/**
	 * The id.
	 */
	private long ID;
	
	/**
	 * The name.
	 */
	private String name;
	
	/**
	 * The period.
	 */
	private long period;
	
	/**
	 * The color.
	 */
	private long color;
	
	/**
	 * The card cost.
	 */
	private Stats cardCost;
	
	/**
	 * The effects.
	 */
	protected List<QuickEffect> effects = new ArrayList<>(); 
	
	
	/**
	 * Activate Q effects.
	 *
	 * @param player
	 *            the player
	 * @param game
	 *            the game
	 */
	public void activateQEffects(PBoard player, GameLogic game){
		for(int i = 0 ; i < this.effects.size() ; i++){
			QuickEffect qeffect = this.effects.get(i);
			qeffect.activate(player, game);
		}
	}
	
	/**
	 * Checks for harvest.
	 *
	 * @return true, if successful
	 */
	public abstract boolean hasHarvest();
	
	/**
	 * Checks for production.
	 *
	 * @return true, if successful
	 */
	public abstract boolean hasProduction();
	
	/**
	 * Checks for final.
	 *
	 * @return true, if successful
	 */
	public abstract boolean hasFinal();
	
	/**
	 * Checks for permanent.
	 *
	 * @return true, if successful
	 */
	public abstract boolean hasPermanent();
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public abstract String toString();
	
	/**
	 * To string.
	 *
	 * @param count
	 *            the count
	 * @return the string
	 */
	public abstract String toString(int count);

	/**
	 * Gets the id.
	 *
	 * @return the iD
	 */
	public long getID() {
		return ID;
	}

	/**
	 * Sets the id.
	 *
	 * @param iD
	 *            the iD to set
	 */
	public void setID(long iD) {
		ID = iD;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the period.
	 *
	 * @return the period
	 */
	public long getPeriod() {
		return period;
	}

	/**
	 * Sets the period.
	 *
	 * @param period
	 *            the period to set
	 */
	public void setPeriod(long period) {
		this.period = period;
	}

	/**
	 * Gets the color.
	 *
	 * @return the color
	 */
	public long getColor() {
		return color;
	}

	/**
	 * Sets the color.
	 *
	 * @param color
	 *            the color to set
	 */
	public void setColor(long color) {
		this.color = color;
	}

	/**
	 * Gets the effects.
	 *
	 * @return the effects
	 */
	public List<QuickEffect> getEffects() {
		return effects;
	}

	/**
	 * Sets the effects.
	 *
	 * @param effects
	 *            the effects to set
	 */
	public void setEffects(List<QuickEffect> effects) {
		this.effects = effects;
	}

	/**
	 * Gets the card cost.
	 *
	 * @return the cardCost
	 */
	public Stats getCardCost() {
		return cardCost;
	}

	/**
	 * Sets the card cost.
	 *
	 * @param cardCost
	 *            the cardCost to set
	 */
	public void setCardCost(Stats cardCost) {
		this.cardCost = cardCost;
	}
	
	

}
