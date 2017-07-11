package it.polimi.ingsw.ps18.model.effect.generalEffects;

import java.util.List;

import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.effect.finalEffect.FinalEffect;
import it.polimi.ingsw.ps18.model.effect.harvestEffect.HarvestEffect;
import it.polimi.ingsw.ps18.model.effect.prodEffect.ProductionEffect;
import it.polimi.ingsw.ps18.model.effect.quickEffect.QuickEffect;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;


/**
 * The Class AddPVforBlueC.
 */
public class AddPVforBlueC implements FinalEffect, HarvestEffect, ProductionEffect, QuickEffect {
	
	/**
	 * The name.
	 */
	private String name;
	
	/**
	 * The quantity.
	 */
	private int quantity;

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.effect.finalEffect.FinalEffect#activate(it.polimi.ingsw.ps18.model.personalboard.PBoard, it.polimi.ingsw.ps18.model.gamelogic.GameLogic)
	 */
	@Override
	public void activate(PBoard player, GameLogic game) {
		int count = 0;
		List<Cards> cards = player.getCards();
		for(Cards card: cards){
			if(card.getColor()==1){
				count++;
			}
		} (player.getResources()).addVP(count * this.quantity);
	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.effect.finalEffect.FinalEffect#setQuantity(int)
	 */
	@Override
	public void setQuantity(int quantity) {
		this.quantity = quantity;

	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("Gain " + this.quantity + " Victory Point");
		if(quantity != 1){
			builder.append("s");
		}
		builder.append(" for every Blue Card you have.");
		return builder.toString();
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
	 * Gets the quantity.
	 *
	 * @return the quantity
	 */
	public int getQuantity() {
		
		return quantity;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
		
	}

}
