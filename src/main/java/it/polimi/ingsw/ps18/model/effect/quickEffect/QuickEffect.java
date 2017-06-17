package it.polimi.ingsw.ps18.model.effect.quickEffect;

import it.polimi.ingsw.ps18.model.effect.generalEffects.GeneralEffect;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public interface QuickEffect extends GeneralEffect{
	
	/**
	 * Activate the effect. The method is overriden in all 
	 * the classes that implement this interface
	 * @param player indicates the player which resources are going to be modified
	 */
	@Override
	public void activate(PBoard player, GameLogic game);
	
	/**
	 * Set the Parameter that the method "activate" may use in his functioning
	 * @param quantity indicates usually a multiplier for the methods of the classes
	 *        that inplement this interface
	 */
	@Override
	public void setQuantity(int quantity);
	
	@Override
	public String toString();

}
