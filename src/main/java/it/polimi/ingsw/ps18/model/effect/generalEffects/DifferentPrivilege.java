package it.polimi.ingsw.ps18.model.effect.generalEffects;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import it.polimi.ingsw.ps18.model.effect.finalEffect.FinalEffect;
import it.polimi.ingsw.ps18.model.effect.harvestEffect.HarvestEffect;
import it.polimi.ingsw.ps18.model.effect.prodEffect.ProductionEffect;
import it.polimi.ingsw.ps18.model.effect.quickEffect.QuickEffect;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.messagesandlogs.ParamMessage;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

/**
 * The Class DifferentPrivilege.
 */
public class DifferentPrivilege extends Observable implements QuickEffect, HarvestEffect, ProductionEffect, FinalEffect {
	
	/**
	 * The name.
	 */
	private String name = "different privilege";
	
	/**
	 * The quantity.
	 */
	private int quantity;
	
	/**
	 * The previous choices.
	 */
	private List<Integer> previousChoices = new ArrayList<>();
	
	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.effect.quickEffect.QuickEffect#activate(it.polimi.ingsw.ps18.model.personalboard.PBoard, it.polimi.ingsw.ps18.model.gamelogic.GameLogic)
	 */
	@Override
	public void activate(PBoard player, GameLogic game) {
		addObserver(player.getpBoardView());
		while(previousChoices.size() < quantity){
			setChanged();
			game.setOngoingEffect(this);
			notifyObservers(new ParamMessage("PrivilegeChoice",1));
		}
	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.effect.quickEffect.QuickEffect#setQuantity(int)
	 */
	@Override
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("Choose " + this.quantity + " different Privileges");
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

	/**
	 * Gets the previous choices.
	 *
	 * @return the previousChoices
	 */
	public List<Integer> getPreviousChoices() {
		return previousChoices;
	}

	/**
	 * Sets the previous choices.
	 *
	 * @param previousChoices
	 *            the previousChoices to set
	 */
	public void setPreviousChoices(List<Integer> previousChoices) {
		this.previousChoices = previousChoices;
	}
	
	
	

}
