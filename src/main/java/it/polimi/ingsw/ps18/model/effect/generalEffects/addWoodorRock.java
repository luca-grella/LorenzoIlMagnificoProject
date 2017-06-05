package it.polimi.ingsw.ps18.model.effect.generalEffects;

import it.polimi.ingsw.ps18.model.effect.finalEffect.FinalEffect;
import it.polimi.ingsw.ps18.model.effect.harvestEffect.HarvestEffect;
import it.polimi.ingsw.ps18.model.effect.prodEffect.ProductionEffect;
import it.polimi.ingsw.ps18.model.effect.quickEffect.QuickEffect;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class addWoodorRock implements QuickEffect, HarvestEffect, ProductionEffect, FinalEffect  {
	private String name = "Wood or Rock";
	private int quantity;

	/**
	 * Add a quantity of wood or rock to the player's resources
	 * @see QuickEffect,HarvestEffect,ProductionEffect,FinalEffect
	 */
	@Override
	public void activate(PBoard player) {
		//Stats stat = player.getStats();
		
		//TODO: scelta fra wood o rock
//		stat.addWood(quantity);
//		stat.addRock(quantity);
		
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
}
