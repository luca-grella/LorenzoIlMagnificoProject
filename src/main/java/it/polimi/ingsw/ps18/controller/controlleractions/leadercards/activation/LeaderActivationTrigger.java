package it.polimi.ingsw.ps18.controller.controlleractions.leadercards.activation;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class LeaderActivationTrigger implements ActionChoice {
	private int index;

	@Override
	public void act(GameLogic game) {
		PBoard currentplayer = game.getTurnplayer();
		if(currentplayer.getLeadercards().isEmpty()){
			return;
		}
		currentplayer.activateLeader(game);
	}

	@Override
	public void setIndex(int i) {
		this.index = i;
	}

}
