package it.polimi.ingsw.ps18.model.effect.generalEffects;

import java.util.Observable;

import it.polimi.ingsw.ps18.model.cards.Excommunications;
import it.polimi.ingsw.ps18.model.effect.excommEffects.MalusValue;
import it.polimi.ingsw.ps18.model.effect.finalEffect.FinalEffect;
import it.polimi.ingsw.ps18.model.effect.harvestEffect.HarvestEffect;
import it.polimi.ingsw.ps18.model.effect.leaderEffects.quickeffects.LCQuickEffect;
import it.polimi.ingsw.ps18.model.effect.prodEffect.ProductionEffect;
import it.polimi.ingsw.ps18.model.effect.quickEffect.QuickEffect;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.messagesandlogs.ParamMessage;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

/**
 * The Class ActProduction.
 */
public class ActProduction extends Observable implements FinalEffect, HarvestEffect, ProductionEffect, QuickEffect, LCQuickEffect {
	
	/**
	 * The name.
	 */
	private String name = "activate production";
	
	/**
	 * The quantity.
	 */
	private int quantity;
	
	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.effect.finalEffect.FinalEffect#activate(it.polimi.ingsw.ps18.model.personalboard.PBoard, it.polimi.ingsw.ps18.model.gamelogic.GameLogic)
	 */
	@Override
	public void activate(PBoard player, GameLogic game) {
		addObserver(player.getpBoardView());
		int malusValue = 0;
		for(int i=0; i<player.getExcommCards().size(); i++){
			Excommunications card = player.getExcommCards().get(i);
			for(int j=0; j<card.getEffects().size(); j++){
				if("MalusValue".equals(card.getEffects().get(j).getName())){
					if("Production".equals(((MalusValue) card.getEffects().get(j)).getPlace())){
						malusValue += ((MalusValue) card.getEffects().get(j)).getMalusValue();
					}
				}
			}
		}
		if(quantity >= malusValue){
			setChanged();
			notifyObservers(new ParamMessage("actProduction",quantity - malusValue));
		} else {
			setChanged();
			notifyObservers(new ParamMessage("actProduction",0));
		}
	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.effect.finalEffect.FinalEffect#setQuantity(int)
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
		builder.append("Trigger a Production Action with a Value of " + this.quantity);
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
	 * @return
	 */
	public int getQuantity() {
		
		return quantity;
	}
}