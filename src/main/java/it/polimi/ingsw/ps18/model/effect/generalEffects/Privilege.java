package it.polimi.ingsw.ps18.model.effect.generalEffects;

import java.util.Observable;

import it.polimi.ingsw.ps18.model.effect.finalEffect.FinalEffect;
import it.polimi.ingsw.ps18.model.effect.harvestEffect.HarvestEffect;
import it.polimi.ingsw.ps18.model.effect.prodEffect.ProductionEffect;
import it.polimi.ingsw.ps18.model.effect.quickEffect.QuickEffect;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.messages.ActionMessage;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class Privilege extends Observable implements QuickEffect, HarvestEffect, ProductionEffect, FinalEffect   {
	private String name = "privilege";
	private int quantity;

	@Override
	public void activate(PBoard player, GameLogic game) {
		addObserver(player.getpBoardView());
		game.setOngoingEffect(this);
		for(int i=0; i<quantity; i++){
			setChanged();
			notifyObservers(new ActionMessage("PrivilegeChoice"));
		}
		
	}
	
	@Override
	public void setQuantity(int quantity){
		this.quantity = quantity;
		
	}
	
	
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("Choose " + this.quantity + "  Privileges");
		return builder.toString();
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
     
}
