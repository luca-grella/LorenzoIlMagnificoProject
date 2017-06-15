package it.polimi.ingsw.ps18.model.effect.generalEffects;

import java.util.Observable;

import it.polimi.ingsw.ps18.model.effect.finalEffect.FinalEffect;
import it.polimi.ingsw.ps18.model.effect.harvestEffect.HarvestEffect;
import it.polimi.ingsw.ps18.model.effect.prodEffect.ProductionEffect;
import it.polimi.ingsw.ps18.model.effect.quickEffect.QuickEffect;
import it.polimi.ingsw.ps18.model.messages.StatusMessage;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class addWoodorRock extends Observable implements QuickEffect, HarvestEffect, ProductionEffect, FinalEffect  {
	private String name = "Wood or Rock";
	private int quantity;

	/**
	 * Add a quantity of wood or rock to the player's resources
	 * @see QuickEffect,HarvestEffect,ProductionEffect,FinalEffect
	 */
	@Override
	public void activate(PBoard player) {
		addObserver(player.getpBoardView());
		setChanged();
		notifyObservers(new StatusMessage("WoodorRockChoice"));
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString(){
		return "Da scrivere";
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
}
