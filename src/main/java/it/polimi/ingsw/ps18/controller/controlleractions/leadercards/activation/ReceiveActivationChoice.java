package it.polimi.ingsw.ps18.controller.controlleractions.leadercards.activation;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.cards.LeaderCards;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class ReceiveActivationChoice implements ActionChoice {
	private int index;

	@Override
	public void act(GameLogic game) {
		PBoard currentplayer = game.getTurnplayer();
		if(index==1){
			LeaderCards card = currentplayer.getCurrentcard();
			currentplayer.getSupportforLC().add(card);
		}
	}

	@Override
	public void setIndex(int i) {
		this.index = i;
	}

}
