package it.polimi.ingsw.ps18.controller.controlleractions.famtotower;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.gameLogic.Action;
import it.polimi.ingsw.ps18.model.gameLogic.FamtoTower;
import it.polimi.ingsw.ps18.model.gameLogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class FamtoTowerTrigger implements ActionChoice {

	@Override
	public void act(GameLogic game) {
		PBoard currentplayer = game.getTurnplayer();
		Action action = new FamtoTower(currentplayer.getpBoardView());
		game.setOngoingAction(action);
		((FamtoTower) action).famchoice();
		

	}

	@Override
	public void setIndex(int i) {
		return;
	}

}
