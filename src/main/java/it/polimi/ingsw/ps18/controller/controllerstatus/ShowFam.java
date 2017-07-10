package it.polimi.ingsw.ps18.controller.controllerstatus;

import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.gamelogic.ShowBoard;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;


/**
 * The Class ShowFam.
 */
public class ShowFam implements Status {
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

	/**
	 * @see it.polimi.ingsw.ps18.controller.controllerstatus.Status#act(it.polimi.ingsw.ps18.model.gamelogic.GameLogic)
	 */
	@Override
	public void act(GameLogic game) {
		PBoard currentplayer = game.getTurnplayer();
		ShowBoard showBoard = new ShowBoard(currentplayer.getpBoardView());
		showBoard.showFam(currentplayer);
	}
	
	

}
