package it.polimi.ingsw.ps18.controller.controllerstatus;

import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;

/**
 * The Interface Status.
 */
public interface Status {
	
	/**
	 * Act.
	 *
	 * @param game
	 *            the game
	 */
	public void act(GameLogic game);
	
	/**
	 * Sets the color.
	 *
	 * @param i the new color
	 */
	public void setColor(int i);
	
	/**
	 * Sets the index.
	 *
	 * @param i the new index
	 */
	public void setIndex(int i);

}
