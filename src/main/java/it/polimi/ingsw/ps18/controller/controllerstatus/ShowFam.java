package it.polimi.ingsw.ps18.controller.controllerstatus;

import it.polimi.ingsw.ps18.model.gameLogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalBoard.PBoard;

public class ShowFam implements Status {

	@Override
	public void act(GameLogic game) {
		PBoard currentplayer = game.getTurnplayer();
		currentplayer.toString(currentplayer.getFams());

	}
	
	

}
