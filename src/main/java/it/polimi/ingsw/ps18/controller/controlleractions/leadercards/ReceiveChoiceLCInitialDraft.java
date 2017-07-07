package it.polimi.ingsw.ps18.controller.controlleractions.leadercards;

import java.util.List;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.cards.LeaderCards;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class ReceiveChoiceLCInitialDraft implements ActionChoice {
	private int index;

	@Override
	public void act(GameLogic game) {
		PBoard currentplayer = game.getTurnplayer();
		List<LeaderCards> leaders = currentplayer.getTempLC();
		if(index<0 || index>leaders.size()){
			currentplayer.takeLeader(leaders);
		} else {
			currentplayer.continuetakeLeader(index);
		}
	}

	@Override
	public void setIndex(int i) {
		this.index = i;
	}

}
