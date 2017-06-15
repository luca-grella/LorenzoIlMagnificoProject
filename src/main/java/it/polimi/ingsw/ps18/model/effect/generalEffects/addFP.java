package it.polimi.ingsw.ps18.model.effect.generalEffects;

import it.polimi.ingsw.ps18.model.effect.finalEffect.FinalEffect;
import it.polimi.ingsw.ps18.model.effect.harvestEffect.HarvestEffect;
import it.polimi.ingsw.ps18.model.effect.prodEffect.ProductionEffect;
import it.polimi.ingsw.ps18.model.effect.quickEffect.QuickEffect;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

public class addFP implements QuickEffect, HarvestEffect, ProductionEffect, FinalEffect  {
	private String name = "Faith Points";
	private int quantity;

	/**
	 * Add a quantity of Faith Points to the player's resources
	 * @see QuickEffect,HarvestEffect,ProductionEffect,FinalEffect
	 */
	@Override
	public void activate(PBoard player) {
		Stats stat = player.getResources();
		stat.addFP(quantity);
		
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
		if(quantity>=0){
			if(quantity == 1){
				return "add " + quantity + " " + name;
			} else if(quantity==0 || quantity>1){
				return "add " + quantity + " " + name + "s";
			}
		} else {
			if(quantity == -1){
				return "detract " + quantity + " " + name;
			} else {
				return "detract " + quantity + " " + name + "s";
			}
		}
		return "Error";
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
}
