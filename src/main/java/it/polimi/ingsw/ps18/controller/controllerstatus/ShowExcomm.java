package it.polimi.ingsw.ps18.controller.controllerstatus;

import it.polimi.ingsw.ps18.model.board.Board;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.gamelogic.ShowBoard;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class ShowExcomm implements Status {
	
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
		Board board = game.getBoard();
		showBoard.ShowExcomm(board);
	}

}
