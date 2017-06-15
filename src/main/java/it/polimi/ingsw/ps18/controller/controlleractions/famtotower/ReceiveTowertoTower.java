package it.polimi.ingsw.ps18.controller.controlleractions.famtotower;

import java.util.ArrayList;
import java.util.List;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.board.Board;
import it.polimi.ingsw.ps18.model.board.boardcells.ConcreteTower;
import it.polimi.ingsw.ps18.model.board.boardcells.Tower;
import it.polimi.ingsw.ps18.model.gamelogic.Action;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoTower;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.gamelogic.GeneralParameters;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class ReceiveTowertoTower implements ActionChoice {
	private int index;

	@Override
	public void act(GameLogic game) {
		Action currentaction = game.getOngoingAction();
		Board gameBoard = game.getBoard();
		List<Tower> boardTowers = gameBoard.getTowers();
		FMember pBoardFM = ((FamtoTower) currentaction).getChosenFam();
		ConcreteTower boardTower = (ConcreteTower) boardTowers.get(index);
		PBoard currentPlayer = game.getTurnplayer(); //turnplayer nel mondo di francope significa giocatore corrente

		if(boardTower.isLegalT(pBoardFM)){ 
			if(boardTower.isEmptyT()){
				if(currentPlayer.hasSpace(index)){
					((FamtoTower) currentaction).setChosenTower(index);
					((FamtoTower) currentaction).floorChoice();
				}
				else{
					((FamtoTower) currentaction).towerChoice();
				}
				
			} 
			else {
				if((currentPlayer.getResources()).getCoin() >= GeneralParameters.towerFee){
					if(currentPlayer.hasSpace(index)){
						((FamtoTower) currentaction).setChosenTower(index);
						((FamtoTower) currentaction).floorChoice();
					}					
					else{
						((FamtoTower) currentaction).towerChoice();

					}
				} 
				else {
					((FamtoTower) currentaction).towerChoice();
				}
			}
				
		} else {
			((FamtoTower) currentaction).towerChoice();
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
