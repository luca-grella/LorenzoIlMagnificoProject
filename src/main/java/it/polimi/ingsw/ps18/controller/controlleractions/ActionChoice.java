package it.polimi.ingsw.ps18.controller.controlleractions;

import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;

public interface ActionChoice {
	
	public void act(GameLogic game);
	
	public void setIndex(int i);

}
