package it.polimi.ingsw.ps18.model.effect.prodEffect;

import it.polimi.ingsw.ps18.model.personalBoard.PBoard;

public interface ProductionEffect {
	
	/**
	 * Activate the effect. The method is overriden in all 
	 * the classes that implement this interface
	 * @param player indicates the player which resources are going to be modified
	 */
	public void activate(PBoard player);
    
	/**
	 * Set the Parameter that the method "activate" may use in his functioning
	 * @param quantity indicates usually a multiplier for the methods of the classes
	 *        that inplement this interface
	 */
	public void setQuantity(int quantity);
	
	public String toString();

}
