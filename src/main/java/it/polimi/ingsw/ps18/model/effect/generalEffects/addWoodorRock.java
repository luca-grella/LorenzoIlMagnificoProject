package it.polimi.ingsw.ps18.model.effect.generalEffects;

import java.util.Observable;

import it.polimi.ingsw.ps18.model.effect.finalEffect.FinalEffect;
import it.polimi.ingsw.ps18.model.effect.harvestEffect.HarvestEffect;
import it.polimi.ingsw.ps18.model.effect.prodEffect.ProductionEffect;
import it.polimi.ingsw.ps18.model.effect.quickEffect.QuickEffect;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.messages.StatusMessage;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

// TODO: Auto-generated Javadoc
/**
 * The Class addWoodorRock.
 */
public class addWoodorRock extends Observable implements QuickEffect, HarvestEffect, ProductionEffect, FinalEffect  {
	
	/**
	 * The name.
	 */
	private String name = "Wood or Rock";
	
	/**
	 * The quantity.
	 */
	private int quantity;

	/**
	 * Add a quantity of wood or rock to the player's resources.
	 *
	 * @param player
	 *            the player
	 * @param game
	 *            the game
	 * @see QuickEffect,HarvestEffect,ProductionEffect,FinalEffect
	 */
	@Override
	public void activate(PBoard player, GameLogic game) {
		addObserver(player.getpBoardView());
		game.setOngoingEffect(this);
		setChanged();
		notifyObservers(new StatusMessage("WoodorRockChoice"));
	}

	/**
	 * Gets the quantity.
	 *
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Sets the quantity.
	 *
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		return "Da scrivere";
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
}
