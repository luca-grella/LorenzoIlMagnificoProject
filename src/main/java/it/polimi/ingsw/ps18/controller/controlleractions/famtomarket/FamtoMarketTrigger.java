package it.polimi.ingsw.ps18.controller.controlleractions.famtomarket;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.gameLogic.Action;
import it.polimi.ingsw.ps18.model.gameLogic.FamtoMarket;
import it.polimi.ingsw.ps18.model.gameLogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class FamtoMarketTrigger implements ActionChoice {

	@Override
	public void act(GameLogic game) {
		PBoard currentplayer = game.getTurnplayer();
		Action action = new FamtoMarket(currentplayer.getpBoardView());
		game.setOngoingAction(action);
		((FamtoMarket) action).famchoice();

	}

	@Override
	public void setIndex(int i) {
		return;

	}

}
