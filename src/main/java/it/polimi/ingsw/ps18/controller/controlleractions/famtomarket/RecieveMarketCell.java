package it.polimi.ingsw.ps18.controller.controlleractions.famtomarket;

import java.util.List;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.board.Board;
import it.polimi.ingsw.ps18.model.board.boardcells.MarketCell;
import it.polimi.ingsw.ps18.model.gamelogic.Action;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoMarket;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class RecieveMarketCell implements ActionChoice{
	private int index;

	@Override
	public void act(GameLogic game) {
		Action currentaction = game.getOngoingAction();
		Board gameBoard = game.getBoard();
		List<MarketCell> boardMarketCells = gameBoard.getMarketCells();
		MarketCell boardMarketCell = boardMarketCells.get(index);
		PBoard currentPlayer = game.getTurnplayer();
		FMember pBoardFM = ((FamtoMarket) currentaction).getChosenFam();
		if(boardMarketCell.isEmptyMC()){
			if(boardMarketCell.isLegalMC(pBoardFM)){
				((FamtoMarket) currentaction).setChosenCell(index);
				currentaction.act(game);
			}
			else
				((FamtoMarket) currentaction).cellChoice();
			
		}
	}

	/**
	 * @param index the index to set
	 */
	@Override
	public void setIndex(int index) {
		this.index = index;
	}

}
