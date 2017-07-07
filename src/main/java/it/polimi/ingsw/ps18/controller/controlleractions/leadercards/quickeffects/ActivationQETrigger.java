package it.polimi.ingsw.ps18.controller.controlleractions.leadercards.quickeffects;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class ActivationQETrigger implements ActionChoice {
	private int index;

	@Override
	public void act(GameLogic game) {
		PBoard currentplayer = game.getTurnplayer();
		currentplayer.activateLCQE(game);
	}

	@Override
	public void setIndex(int i) {
		this.index = i;
	}

}
