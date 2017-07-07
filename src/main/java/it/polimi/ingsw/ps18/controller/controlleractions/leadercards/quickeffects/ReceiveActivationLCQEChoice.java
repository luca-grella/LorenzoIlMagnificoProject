package it.polimi.ingsw.ps18.controller.controlleractions.leadercards.quickeffects;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class ReceiveActivationLCQEChoice implements ActionChoice {
	private int index;

	@Override
	public void act(GameLogic game) {
		if(index==2){
			return;
		} else {
			PBoard currentplayer = game.getTurnplayer();
			currentplayer.getSupportforLC().add(currentplayer.getCurrentcard());
		}
	}

	@Override
	public void setIndex(int i) {
		this.index = i;
	}

}
