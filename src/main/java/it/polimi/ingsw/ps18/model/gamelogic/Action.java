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
	public void act(GameLogic game);
	
	/**
	 * Sets the chosen fam.
	 *
	 * @param chosenFam
	 *            the new chosen fam
	 */
	public void setChosenFam(FMember chosenFam);

}
