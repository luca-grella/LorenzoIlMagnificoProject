package it.polimi.ingsw.ps18.model.effect.generalEffects;

import it.polimi.ingsw.ps18.model.effect.finalEffect.FinalEffect;
import it.polimi.ingsw.ps18.model.effect.harvestEffect.HarvestEffect;
import it.polimi.ingsw.ps18.model.effect.prodEffect.ProductionEffect;
import it.polimi.ingsw.ps18.model.effect.quickEffect.QuickEffect;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class DifferentPrivilege implements QuickEffect, HarvestEffect, ProductionEffect, FinalEffect {
	private String name = "different privilege";
	private int quantity;
	
	@Override
	public void activate(PBoard player) {

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
