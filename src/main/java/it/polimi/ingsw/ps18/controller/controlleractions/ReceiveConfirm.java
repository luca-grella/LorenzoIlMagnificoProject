package it.polimi.ingsw.ps18.controller.controlleractions;

import it.polimi.ingsw.ps18.model.gamelogic.ConfirmHandler;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;

public class ReceiveConfirm implements ActionChoice {
	private int index;

	@Override
	public void act(GameLogic game) {
		if(index==1){
			ConfirmHandler action = game.getRequester();
			action.setConfirm(true);
		} 
		return;
	}

	@Override
	public void setIndex(int i) {
		this.index = i;
	}

}
