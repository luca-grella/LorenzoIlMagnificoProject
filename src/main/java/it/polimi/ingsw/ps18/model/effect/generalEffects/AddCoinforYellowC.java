package it.polimi.ingsw.ps18.model.effect.generalEffects;

import java.util.List;

import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.effect.finalEffect.FinalEffect;
import it.polimi.ingsw.ps18.model.effect.harvestEffect.HarvestEffect;
import it.polimi.ingsw.ps18.model.effect.prodEffect.ProductionEffect;
import it.polimi.ingsw.ps18.model.effect.quickEffect.QuickEffect;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class AddCoinforYellowC implements FinalEffect, HarvestEffect, ProductionEffect, QuickEffect {
	private String name;
	private int quantity;

	@Override
	public void activate(PBoard player, GameLogic game) {
		int count = 0;
		List<Cards> cards = player.getCards();
		for(Cards card: cards){
			if(card.getColor()==2){
				count++;
			}
		} (player.getResources()).addCoins(count * this.quantity);
	}

	@Override
	public void setQuantity(int quantity) {
		this.quantity = quantity;

	}
	
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("Gain " + this.quantity + " Coins for every Yellow Card you have.");
		return builder.toString();
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

}
