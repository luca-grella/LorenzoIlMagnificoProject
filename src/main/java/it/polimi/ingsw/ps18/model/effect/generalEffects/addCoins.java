package it.polimi.ingsw.ps18.model.effect.generalEffects;

import it.polimi.ingsw.ps18.model.cards.Excommunications;
import it.polimi.ingsw.ps18.model.effect.excommEffects.MalusResources;
import it.polimi.ingsw.ps18.model.effect.finalEffect.FinalEffect;
import it.polimi.ingsw.ps18.model.effect.harvestEffect.HarvestEffect;
import it.polimi.ingsw.ps18.model.effect.prodEffect.ProductionEffect;
import it.polimi.ingsw.ps18.model.effect.quickEffect.QuickEffect;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;


/**
 * The Class addCoins.
 */
public class addCoins implements QuickEffect, HarvestEffect, ProductionEffect, FinalEffect  {
	
	/**
	 * The name.
	 */
	private String name = "Coin";
	
	/**
	 * The quantity.
	 */
	private int quantity;
	
	/**
	 * Add a quantity of coins to the player's resources.
	 *
	 * @param player
	 *            the player
	 * @param game
	 *            the game
	 * @see QuickEffect,HarvestEffect,ProductionEffect,FinalEffect
	 */
	@Override
	public void activate(PBoard player, GameLogic game) {
		Stats stat = player.getResources();
		Stats totalmalus;
		totalmalus = player.generateExcommMalus();
		int malusCoins = totalmalus.getCoin();
		if(quantity >= malusCoins){
			stat.addCoins(quantity - malusCoins);
		} else {
			stat.addCoins(0);
		}
		
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
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	
}
