package it.polimi.ingsw.ps18.controller.controlleractions;

import it.polimi.ingsw.ps18.model.gameLogic.GameLogic;

public interface ActionChoice {
	
	public void act(GameLogic game);
	
	public void setIndex(int i);

}
