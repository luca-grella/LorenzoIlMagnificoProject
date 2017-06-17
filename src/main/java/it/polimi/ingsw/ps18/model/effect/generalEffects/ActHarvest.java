package it.polimi.ingsw.ps18.model.effect.generalEffects;

import java.util.Observable;

import it.polimi.ingsw.ps18.model.effect.finalEffect.FinalEffect;
import it.polimi.ingsw.ps18.model.effect.harvestEffect.HarvestEffect;
import it.polimi.ingsw.ps18.model.effect.prodEffect.ProductionEffect;
import it.polimi.ingsw.ps18.model.effect.quickEffect.QuickEffect;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.messages.ParamMessage;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class ActHarvest extends Observable implements FinalEffect, HarvestEffect, ProductionEffect, QuickEffect {
	private String name = "activate harvest";
	private int quantity;
	
	@Override
	public void activate(PBoard player, GameLogic game) {
		addObserver(player.getpBoardView());
		setChanged();
		notifyObservers(new ParamMessage("actHarvest",quantity));
	}

	@Override
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("Trigger an Harvest Action with a Value of " + this.quantity);
		return builder.toString();
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

}
