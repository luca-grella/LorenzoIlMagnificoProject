package it.polimi.ingsw.ps18.controller.controllerstatus;

import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.gamelogic.ShowBoard;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

/**
 * The Class ChosePlayer.
 */
public class ChoosePlayer implements Status {
	private int index;
	private int color;
	/**
	 * @see it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice#act(it.polimi.ingsw.ps18.model.gamelogic.GameLogic)
	 */
	@Override
	public void act(GameLogic game) {
		PBoard caller = new PBoard();
		if(color!=-1){
			for(PBoard player: game.getPlayers()){
				if(player.getPlayercol()==color){
					caller = player;
				}
			}
		} else {
			caller = game.getTurnplayer();
		}
		ShowBoard showBoard = new ShowBoard(caller.getpBoardView());
		showBoard.choosePlayer(color);
	}

	/**
	 * @see it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice#setIndex(int)
	 */
	@Override
	public void setIndex(int i) {
		this.index = i;
	}

	/**
	 * Per test
	 * @return 
	 */
	public int getIndex() {
		return index;
	}

	@Override
	public void setColor(int i) {
		this.color = i;
	}

}
