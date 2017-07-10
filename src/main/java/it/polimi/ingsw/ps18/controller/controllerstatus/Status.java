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
	
	public void setColor(int i);
	
	public void setIndex(int i);

}
