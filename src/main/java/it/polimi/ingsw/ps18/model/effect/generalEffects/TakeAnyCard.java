package it.polimi.ingsw.ps18.model.effect.generalEffects;

import it.polimi.ingsw.ps18.model.effect.finalEffect.FinalEffect;
import it.polimi.ingsw.ps18.model.effect.harvestEffect.HarvestEffect;
import it.polimi.ingsw.ps18.model.effect.prodEffect.ProductionEffect;
import it.polimi.ingsw.ps18.model.effect.quickEffect.QuickEffect;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class TakeAnyCard implements FinalEffect, HarvestEffect, ProductionEffect, QuickEffect {
	private String name = "Take any Card";
	private int quantity;
	
	@Override
	public void activate(PBoard player) {
		
	}

	@Override
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

}
