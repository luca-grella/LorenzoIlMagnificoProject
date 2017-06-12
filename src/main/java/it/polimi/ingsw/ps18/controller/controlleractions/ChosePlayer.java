package it.polimi.ingsw.ps18.controller.controlleractions;

import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.gamelogic.ShowBoard;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class ChosePlayer implements ActionChoice {

	@Override
	public void act(GameLogic game) {
		PBoard currentplayer = game.getTurnplayer();
		ShowBoard showBoard = new ShowBoard(currentplayer.getpBoardView());
		showBoard.choosePlayer();
	}

	@Override
	public void setIndex(int i) {
		return;
	}

}
