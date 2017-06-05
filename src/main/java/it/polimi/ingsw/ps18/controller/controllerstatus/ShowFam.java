package it.polimi.ingsw.ps18.controller.controllerstatus;

import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class ShowFam implements Status {

	@Override
	public void act(GameLogic game) {
		PBoard currentplayer = game.getTurnplayer();
		currentplayer.toString(currentplayer.getFams());

	}
	
	

}
