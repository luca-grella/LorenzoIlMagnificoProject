package it.polimi.ingsw.ps18.model.effect.generalEffects;

import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.gamelogic.GeneralParameters;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

/**
 * The Interface WoodorRockEffects.
 */
public interface WoodorRockEffects extends GeneralParameters {
	
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
	 * @param index the index
	 * @param player the player
	 * @param game the game
	 */
	public void continueEffect(int index, PBoard player, GameLogic game);

}
