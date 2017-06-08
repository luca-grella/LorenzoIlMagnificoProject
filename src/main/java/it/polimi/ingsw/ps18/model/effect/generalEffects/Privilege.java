package it.polimi.ingsw.ps18.model.effect.generalEffects;

import java.util.HashMap;
import java.util.Map;

import it.polimi.ingsw.ps18.model.effect.finalEffect.FinalEffect;
import it.polimi.ingsw.ps18.model.effect.harvestEffect.HarvestEffect;
import it.polimi.ingsw.ps18.model.effect.prodEffect.ProductionEffect;
import it.polimi.ingsw.ps18.model.effect.quickEffect.QuickEffect;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class Privilege implements QuickEffect, HarvestEffect, ProductionEffect, FinalEffect   {
	private String name = "privilege";
	private int quantity;

	@Override
	public void activate(PBoard player) {
		System.out.println("poi se vede");
		//scelta privilegio + attivazione
		
	}
	
	@Override
	public void setQuantity(int quantity){
		this.quantity = quantity;
		
	}
	
	
	@Override
	public String toString(){
		return "Da scrivere";
	}
     
}
