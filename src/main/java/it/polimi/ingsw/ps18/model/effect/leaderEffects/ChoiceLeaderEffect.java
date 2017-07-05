package it.polimi.ingsw.ps18.model.effect.leaderEffects;

import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

/**
 * used to support the activation of certain Leader Cards effects
 * @author admin
 *
 */

public interface ChoiceLeaderEffect {
	
	public void activate(PBoard player, GameLogic game);
	
	public void continueEffect(PBoard player, GameLogic game);

}
