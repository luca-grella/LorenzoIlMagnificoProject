package it.polimi.ingsw.ps18.controller.controlleractions;

import it.polimi.ingsw.ps18.model.gamelogic.Action;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.gamelogic.TurnHandler;

public class TurnHandleInit implements ActionChoice{
	TurnHandler tHandler;
	
	@Override
	public void act(GameLogic game) {
		Action tHandler = new TurnHandler(game.getTurnplayer());
		game.setOngoingAction(tHandler);
		tHandler.act(game);
		
	}
	
	@Override
	public void setIndex(int i) {
		return;
	}


}
