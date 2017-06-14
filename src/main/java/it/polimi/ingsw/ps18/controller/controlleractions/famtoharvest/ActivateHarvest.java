package it.polimi.ingsw.ps18.controller.controlleractions.famtoharvest;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.gamelogic.*;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class ActivateHarvest implements ActionChoice {
	private int index = -1;

	@Override
	public void act(GameLogic game) {
		if(index != -1){
			PBoard currentplayer = game.getTurnplayer();
			Action currentaction = new FamtoHarvest(currentplayer.getpBoardView());
			game.setOngoingAction(currentaction);
			((FamtoHarvest) currentaction).setActionValue(index);
			((FamtoHarvest) currentaction).activateHarvest(currentplayer);
		} else {
			Action currentaction = game.getOngoingAction();
			PBoard currentplayer = game.getTurnplayer();
			((FamtoHarvest) currentaction).activateHarvest(currentplayer);
		}

	}

	@Override
	public void setIndex(int i) {
		this.index = i;
	}

}
