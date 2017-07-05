package it.polimi.ingsw.ps18.model.effect.leaderEffects.quickeffects;

import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public interface LCQuickEffect {
	
	public void activate(PBoard player, GameLogic game);
	
	public String toString();

}
