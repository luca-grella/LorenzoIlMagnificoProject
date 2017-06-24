package it.polimi.ingsw.ps18.model.effect.generalEffects;

import java.util.List;

import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.effect.finalEffect.FinalEffect;
import it.polimi.ingsw.ps18.model.effect.harvestEffect.HarvestEffect;
import it.polimi.ingsw.ps18.model.effect.prodEffect.ProductionEffect;
import it.polimi.ingsw.ps18.model.effect.quickEffect.QuickEffect;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

// TODO: Auto-generated Javadoc
/**
 * The Class AddCoinforGreenC.
 *
 * @author admin
 */
public class AddCoinforGreenC implements FinalEffect, HarvestEffect, ProductionEffect, QuickEffect {
	
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
			if(card.getColor()==0){
				count++;
			}
		} (player.getResources()).addCoins(count * this.quantity);
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
		builder.append("Gain " + this.quantity + " Coins for every Green Card you have.");
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

}
