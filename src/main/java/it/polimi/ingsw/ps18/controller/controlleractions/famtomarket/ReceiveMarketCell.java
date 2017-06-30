package it.polimi.ingsw.ps18.controller.controlleractions.famtomarket;

import java.util.List;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.board.Board;
import it.polimi.ingsw.ps18.model.board.boardcells.MarketCell;
import it.polimi.ingsw.ps18.model.gamelogic.Action;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoMarket;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.gamelogic.GeneralParameters;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

/**
 * The Class ReceiveMarketCell.
 */
public class ReceiveMarketCell implements ActionChoice{
	
	/**
	 * The index.
	 */
	private int index;

	/**
	 * @see it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice#act(it.polimi.ingsw.ps18.model.gamelogic.GameLogic)
	 */
	@Override
	public void act(GameLogic game) {
		Action currentaction = game.getOngoingAction();
		if(index==0){
			((FamtoMarket) currentaction).famchoice();
		} else if(index<0 || index>GeneralParameters.numberofMarketCells){
			((FamtoMarket) currentaction).cellChoice(game);
		} else {
			index -= 1;
			Board gameBoard = game.getBoard();
			List<MarketCell> boardMarketCells = gameBoard.getMarketCells();
			MarketCell boardMarketCell = boardMarketCells.get(index);
			FMember pBoardFM = ((FamtoMarket) currentaction).getChosenFam();
			if(boardMarketCell.isEmptyMC()){
				if(boardMarketCell.isLegalMC(pBoardFM.getValue() + ((FamtoMarket) currentaction).getNumberOfServants())){
					((FamtoMarket) currentaction).setChosenCell(index);
					currentaction.act(game);
				}
				else
					((FamtoMarket) currentaction).cellChoice(game);
			}
		}
	}

	/**
	 * Sets the index.
	 *
	 * @param index
	 *            the index to set
	 */
	@Override
	public void setIndex(int index) {
		this.index = index;
	}

}
