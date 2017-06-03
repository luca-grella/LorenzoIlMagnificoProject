package it.polimi.ingsw.ps18.controller.controlleractions;

import it.polimi.ingsw.ps18.model.gameLogic.GameLogic;
import it.polimi.ingsw.ps18.model.gameLogic.TurnHandler;

public class TurnHandleInit implements ActionChoice{
	TurnHandler tHandler;

	@Override
	public void act(GameLogic game) {
		tHandler = new TurnHandler(game.getTurnplayer());
		tHandler.init();
		
	}

}
