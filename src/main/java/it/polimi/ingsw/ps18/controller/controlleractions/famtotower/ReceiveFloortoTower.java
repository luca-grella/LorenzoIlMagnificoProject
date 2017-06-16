package it.polimi.ingsw.ps18.controller.controlleractions.famtotower;

import java.util.List;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.board.Board;
import it.polimi.ingsw.ps18.model.board.boardcells.ConcreteTower;
import it.polimi.ingsw.ps18.model.board.boardcells.Tower;
import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.gamelogic.Action;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoTower;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.gamelogic.GeneralParameters;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

public class ReceiveFloortoTower implements ActionChoice {
	private int index;

	@Override
	public void act(GameLogic game) {
		Action currentaction = game.getOngoingAction();
		Board gameBoard = game.getBoard();
		List<Tower> boardTowers = gameBoard.getTowers();
		FamtoTower towerIndex = (FamtoTower) game.getOngoingAction();
		ConcreteTower boardTower = (ConcreteTower)boardTowers.get(towerIndex.getChosenTower());
		PBoard currentPlayer = game.getTurnplayer();
		FMember pBoardFM = ((FamtoTower) currentaction).getChosenFam();
		Stats neededStats = (((boardTower.getTowerCells()).get(index)).getCellCard()).getCardCost();
		List<Cards> playerCards = currentPlayer.getCards();
		
		
		if((((boardTower.getTowerCells()).get(index)).isEmptyTC())){ 
			if(((boardTower.getTowerCells()).get(index)).isLegalTC(pBoardFM)){
				
				if((currentPlayer.getResources().enoughStats(neededStats))){
					((FamtoTower) currentaction).setChosenFloor(index);
					currentaction.act(game);
				}
				else{
					((FamtoTower) currentaction).floorChoice();
				}
			}else{
				((FamtoTower) currentaction).floorChoice();
			}}
		 else {
			((FamtoTower) currentaction).floorChoice();
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
