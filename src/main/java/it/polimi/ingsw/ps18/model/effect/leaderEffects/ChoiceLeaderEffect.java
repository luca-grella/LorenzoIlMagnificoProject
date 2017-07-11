package it.polimi.ingsw.ps18.model.effect.leaderEffects;

import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

/**
 * used to support the activation of certain Leader Cards effects.
 *
 * @author admin
 */

public interface ChoiceLeaderEffect {
	
	/**
	 * Activate.
	 *
	 * @param player the player
	 * @param game the game
	 */
	public void activate(PBoard player, GameLogic game);
	
	/**
	 * Continue effect.
	 *
	 * @param player the player
	 * @param game the game
	 */
	public void continueEffect(PBoard player, GameLogic game);

}
