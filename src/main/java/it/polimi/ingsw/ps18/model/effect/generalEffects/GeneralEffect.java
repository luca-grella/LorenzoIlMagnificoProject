package it.polimi.ingsw.ps18.model.effect.generalEffects;

import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

// TODO: Auto-generated Javadoc
/**
 * The Interface GeneralEffect.
 */
public interface GeneralEffect {
	
	/**
	 * Activate the effect. The method is overriden in all 
	 * the classes that implement this interface
	 * @param player indicates the player which resources are going to be modified
	 * @param game some effects need to save themselves as ongoing effect
	 */
	public void activate(PBoard player, GameLogic game);
	//TODO: teoricamente non bisognerebbe passare il player perchè si può ricavare da game, ma così è possibile attivare effetti su altri giocatori
	
    /**
	 * Set the Parameter that the method "activate" may use in his functioning.
	 *
	 * @param quantity
	 *            indicates usually a multiplier for the methods of the classes
	 *            that inplement this interface
	 */
    public void setQuantity(int quantity);
    
    /**
	 * To string.
	 *
	 * @return the string
	 */
    public String toString();

}
