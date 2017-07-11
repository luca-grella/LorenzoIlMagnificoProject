package it.polimi.ingsw.ps18.model.gamelogic;

import it.polimi.ingsw.ps18.model.personalboard.FMember;

/**
 * The Interface Action.
 */
public interface Action {
	
	/**
	 * Act.
	 *
	 * @param game
	 *            the game
	 */
	public abstract void act(GameLogic game);
	
	/**
	 * Sets the chosen fam.
	 *
	 * @param chosenFam
	 *            the new chosen fam
	 */
	public abstract void setChosenFam(FMember chosenFam);

	/**
	 * Sets the number of servants.
	 *
	 * @param numberOfServants the numberOfServants to set
	 */
	public void setNumberOfServants(int numberOfServants);
	
	

}
