package it.polimi.ingsw.ps18.controller.controlleractions;

import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;

/**
 * The Interface ActionChoice.
 */
public interface ActionChoice {
	
	/**
	 * Act.
	 *
	 * @param game
	 *            the game
	 */
	public void act(GameLogic game);
	
	/**
	 * Sets the index.
	 *
	 * @param i
	 *            the new index
	 */
	public void setIndex(int i);

}
