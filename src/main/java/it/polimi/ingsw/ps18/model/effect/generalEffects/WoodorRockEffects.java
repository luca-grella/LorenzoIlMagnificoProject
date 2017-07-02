package it.polimi.ingsw.ps18.model.effect.generalEffects;

import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.gamelogic.GeneralParameters;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public interface WoodorRockEffects extends GeneralParameters {
	
	public void activate(PBoard player, GameLogic game);
	
	public void continueEffect(int index);

}
