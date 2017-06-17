package it.polimi.ingsw.ps18.model.effect.generalEffects;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import it.polimi.ingsw.ps18.model.effect.finalEffect.FinalEffect;
import it.polimi.ingsw.ps18.model.effect.harvestEffect.HarvestEffect;
import it.polimi.ingsw.ps18.model.effect.prodEffect.ProductionEffect;
import it.polimi.ingsw.ps18.model.effect.quickEffect.QuickEffect;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.messages.ParamMessage;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class DifferentPrivilege extends Observable implements QuickEffect, HarvestEffect, ProductionEffect, FinalEffect {
	private String name = "different privilege";
	private int quantity;
	private List<Integer> previousChoices = new ArrayList<>();
	
	@Override
	public void activate(PBoard player, GameLogic game) {
		addObserver(player.getpBoardView());
		while(previousChoices.size() < quantity){
			setChanged();
			game.setOngoingEffect(this);
			notifyObservers(new ParamMessage("PrivilegeChoice",1));
		}
	}

	@Override
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("Choose " + this.quantity + " different Privileges");
		return builder.toString();
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the previousChoices
	 */
	public List<Integer> getPreviousChoices() {
		return previousChoices;
	}

	/**
	 * @param previousChoices the previousChoices to set
	 */
	public void setPreviousChoices(List<Integer> previousChoices) {
		this.previousChoices = previousChoices;
	}
	
	
	

}
