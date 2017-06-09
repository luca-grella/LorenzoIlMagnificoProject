package it.polimi.ingsw.ps18.controller.controlleractions.famtoharvest;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.gamelogic.Action;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoHarvest;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class FamtoHarvestTrigger implements ActionChoice {

	@Override
	public void act(GameLogic game) {
		PBoard currentplayer = game.getTurnplayer();
		Action action = new FamtoHarvest(currentplayer.getpBoardView());
		game.setOngoingAction(action);
		((FamtoHarvest) action).famchoice();

	}

	@Override
	public void setIndex(int i) {
		return;
	}

}
