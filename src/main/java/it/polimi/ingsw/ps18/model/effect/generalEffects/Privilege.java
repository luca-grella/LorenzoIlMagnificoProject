package it.polimi.ingsw.ps18.model.effect.generalEffects;

import java.util.Observable;

import it.polimi.ingsw.ps18.model.effect.finalEffect.FinalEffect;
import it.polimi.ingsw.ps18.model.effect.harvestEffect.HarvestEffect;
import it.polimi.ingsw.ps18.model.effect.prodEffect.ProductionEffect;
import it.polimi.ingsw.ps18.model.effect.quickEffect.QuickEffect;
import it.polimi.ingsw.ps18.model.messages.StatusMessage;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class Privilege extends Observable implements QuickEffect, HarvestEffect, ProductionEffect, FinalEffect   {
	private String name = "privilege";
	private int quantity;

	@Override
	public void activate(PBoard player) {
		addObserver(player.getpBoardView());
		setChanged();
		notifyObservers(new StatusMessage("PrivilegeChoice"));
		
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
