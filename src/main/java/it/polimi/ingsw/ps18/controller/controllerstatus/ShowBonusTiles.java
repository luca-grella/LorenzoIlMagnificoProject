package it.polimi.ingsw.ps18.controller.controllerstatus;

import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.gamelogic.ShowBoard;

public class ShowBonusTiles implements Status {
	private int index;
	private int color;
	
	@Override
	public void setIndex(int i) {
		this.index = i;
	}
	
	@Override
	public void setColor(int i) {
		this.color = i;
	}

	@Override
	public void act(GameLogic game) {
		ShowBoard showBoard = new ShowBoard(game.getTurnplayer().getpBoardView());
		showBoard.showBonusTiles(game.getBonusTiles());
	}

}
