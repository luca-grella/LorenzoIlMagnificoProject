package it.polimi.ingsw.ps18.model.effect.generalEffects;

import java.util.Observable;

import it.polimi.ingsw.ps18.model.effect.finalEffect.FinalEffect;
import it.polimi.ingsw.ps18.model.effect.harvestEffect.HarvestEffect;
import it.polimi.ingsw.ps18.model.effect.prodEffect.ProductionEffect;
import it.polimi.ingsw.ps18.model.effect.quickEffect.QuickEffect;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.messagesandlogs.ActionMessage;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

/**
 * The Class Privilege.
 */
public class Privilege extends Observable implements QuickEffect, HarvestEffect, ProductionEffect, FinalEffect   {
	
	/**
	 * The name.
	 */
	private String name = "privilege";
	
	/**
	 * The quantity.
	 */
	private int quantity;

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.effect.quickEffect.QuickEffect#activate(it.polimi.ingsw.ps18.model.personalboard.PBoard, it.polimi.ingsw.ps18.model.gamelogic.GameLogic)
	 */
	@Override
	public void activate(PBoard player, GameLogic game) {
		addObserver(player.getpBoardView());
		game.setOngoingEffect(this);
		for(int i=0; i<quantity; i++){
			setChanged();
			notifyObservers(new ActionMessage("PrivilegeChoice"));
		}
		
	}
	
	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.effect.quickEffect.QuickEffect#setQuantity(int)
	 */
	@Override
	public void setQuantity(int quantity){
		this.quantity = quantity;
		
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("Choose " + this.quantity + "  Privileges");
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
