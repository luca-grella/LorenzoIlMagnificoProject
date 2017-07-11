package it.polimi.ingsw.ps18.controller.controllerstatus;

import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.gamelogic.ShowBoard;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

/**
 * The Class ShowServants.
 */
public class ShowServants implements Status{
	
	/** The index. */
	private int index;
	
	/** The color. */
	private int color;
	
	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.controller.controllerstatus.Status#setIndex(int)
	 */
	@Override
	public void setIndex(int i) {
		this.index = i;
	}
	
	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.controller.controllerstatus.Status#setColor(int)
	 */
	@Override
	public void setColor(int i) {
		this.color = i;
	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.controller.controllerstatus.Status#act(it.polimi.ingsw.ps18.model.gamelogic.GameLogic)
	 */
	@Override
	public void act(GameLogic game) {
		PBoard currentplayer = game.getTurnplayer();
		ShowBoard showBoard = new ShowBoard(currentplayer.getpBoardView());
		showBoard.showServants(currentplayer);
	}

}
