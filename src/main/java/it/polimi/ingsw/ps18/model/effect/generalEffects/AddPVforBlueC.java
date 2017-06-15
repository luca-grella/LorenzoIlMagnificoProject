package it.polimi.ingsw.ps18.model.effect.generalEffects;

import java.util.List;

import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.effect.finalEffect.FinalEffect;
import it.polimi.ingsw.ps18.model.effect.harvestEffect.HarvestEffect;
import it.polimi.ingsw.ps18.model.effect.prodEffect.ProductionEffect;
import it.polimi.ingsw.ps18.model.effect.quickEffect.QuickEffect;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class AddPVforBlueC implements FinalEffect, HarvestEffect, ProductionEffect, QuickEffect {
	private String name;
	private int quantity;

	@Override
	public void activate(PBoard player) {
		int count = 0;
		List<Cards> cards = player.getCards();
		for(Cards card: cards){
			if(card.getColor()==1){
				count++;
			}
		} (player.getResources()).addVP(count * this.quantity);
	}

	@Override
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
