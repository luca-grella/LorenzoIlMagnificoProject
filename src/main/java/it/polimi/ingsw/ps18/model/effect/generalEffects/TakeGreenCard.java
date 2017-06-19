package it.polimi.ingsw.ps18.model.effect.generalEffects;

import java.util.Observable;

import it.polimi.ingsw.ps18.model.effect.finalEffect.FinalEffect;
import it.polimi.ingsw.ps18.model.effect.harvestEffect.HarvestEffect;
import it.polimi.ingsw.ps18.model.effect.prodEffect.ProductionEffect;
import it.polimi.ingsw.ps18.model.effect.quickEffect.QuickEffect;
import it.polimi.ingsw.ps18.model.gamelogic.Action;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoTower;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.messages.ActionMessage;
import it.polimi.ingsw.ps18.model.messages.ParamMessage;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class TakeGreenCard extends Observable implements FinalEffect, HarvestEffect, ProductionEffect, QuickEffect {
	private String name = "Take a Card from the Green Tower";
	private int quantity;
	
	@Override
	public void activate(PBoard player, GameLogic game) {
		addObserver(player.getpBoardView());
		Action action = new FamtoTower(player.getpBoardView());
		game.setOngoingAction(action);
		((FamtoTower) action).setChosenFam(new FMember(quantity));
		((FamtoTower) action).setChosenTower(0);
		setChanged();
		notifyObservers(new ParamMessage("Floor Choice",0));		
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
	
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("Take a card from the Green Tower with an Action Value of " + this.quantity);
		return builder.toString();
	}

}
