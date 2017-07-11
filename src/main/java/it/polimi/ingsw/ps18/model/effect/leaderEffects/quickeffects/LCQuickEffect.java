package it.polimi.ingsw.ps18.model.effect.leaderEffects.quickeffects;

import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

/**
 * The Interface LCQuickEffect.
 */
public interface LCQuickEffect {
	
	/**
	 * Activate.
	 *
	 * @param player the player
	 * @param game the game
	 */
	public void activate(PBoard player, GameLogic game);
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString();

}
