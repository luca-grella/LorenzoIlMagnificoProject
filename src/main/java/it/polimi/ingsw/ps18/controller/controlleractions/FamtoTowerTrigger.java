package it.polimi.ingsw.ps18.controller.controlleractions;

import it.polimi.ingsw.ps18.model.gameLogic.FamtoTower;
import it.polimi.ingsw.ps18.model.gameLogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalBoard.PBoard;

public class FamtoTowerTrigger implements ActionChoice {

	@Override
	public void act(GameLogic game) {
		PBoard currentplayer = game.getTurnplayer();
		FamtoTower action = new FamtoTower(currentplayer.getpBoardView());
		action.famchoice();
		

	}

}
