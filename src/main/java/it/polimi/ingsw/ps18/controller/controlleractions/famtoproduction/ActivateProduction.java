package it.polimi.ingsw.ps18.controller.controlleractions.famtoproduction;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.gamelogic.Action;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoProduction;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class ActivateProduction implements ActionChoice {
	private int index = -1;

	@Override
	public void act(GameLogic game) {
		if(index != -1){
			PBoard currentplayer = game.getTurnplayer();
			Action currentaction = new FamtoProduction(currentplayer.getpBoardView());
			game.setOngoingAction(currentaction);
			((FamtoProduction) currentaction).setActionValue(index);
			((FamtoProduction) currentaction).activateProduction(currentplayer);
		} else {
			Action currentaction = game.getOngoingAction();
			PBoard currentplayer = game.getTurnplayer();
			((FamtoProduction) currentaction).activateProduction(currentplayer);
		}

	}

	@Override
	public void setIndex(int i) {
		this.index = i;
	}

}
