package it.polimi.ingsw.ps18.controller.controlleractions.famtocouncil;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.gamelogic.Action;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoCouncil;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class FamtoCouncilTrigger implements ActionChoice {

	@Override
	public void act(GameLogic game) {
		PBoard currentplayer = game.getTurnplayer();
		Action action = new FamtoCouncil(currentplayer.getpBoardView());
		game.setOngoingAction(action);
		((FamtoCouncil) action).famchoice();
		
	}

	@Override
	public void setIndex(int i) {
		return;
	}

}
