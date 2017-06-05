package it.polimi.ingsw.ps18.controller.controllerstatus;

import it.polimi.ingsw.ps18.model.board.Board;
import it.polimi.ingsw.ps18.model.gameLogic.GameLogic;
import it.polimi.ingsw.ps18.model.gameLogic.ShowBoard;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class ShowMarket implements Status {
	GameLogic game;
	
	public void act(GameLogic game){
		PBoard currentplayer = game.getTurnplayer();
		ShowBoard showBoard = new ShowBoard(currentplayer.getpBoardView());
		Board board = game.getBoard();
		showBoard.showMarket(board.getMarketCells());
	}
	

}
