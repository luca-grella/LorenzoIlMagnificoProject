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
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

/**
 * Receives the tower's index chosen by the current player.
 * 
 * @author yazan-matar
 *
 */
public class ReceiveTowertoTower implements ActionChoice {
	
	/**
	 * The index.
	 */
	private int index;
	
	/**
	 * if this method's controls work, the player goes to the floor choice else,
	 * he returns to the tower choice.
	 *
	 * @param game
	 *            <br>
	 *            instance of the game setup and flow
	 */
	@Override
	public void act(GameLogic game) {
		Action currentaction = game.getOngoingAction();
		if(index==0){
			if(((FamtoTower) currentaction).isCanGoBacktoFamChoice()){
				((FamtoTower) currentaction).famchoice();
			} else {
				((FamtoTower) currentaction).towerChoice();
			}
		} else if(index<0 || index>GeneralParameters.numberofBaseTowers){
			((FamtoTower) currentaction).towerChoice();
		} else {
			index -= 1;
			Stats totalCostPreview = new Stats(0,0,0,0,0,0,0);
			Board gameBoard = game.getBoard();
			List<Tower> boardTowers = gameBoard.getTowers();
			FMember pBoardFM = ((FamtoTower) currentaction).getChosenFam();
			ConcreteTower boardTower = (ConcreteTower) boardTowers.get(index);
			PBoard currentplayer = game.getTurnplayer();
			
			if(boardTower.isFullTower()){
				((FamtoTower) currentaction).towerChoice();
			}
			else{
				if(boardTower.isLegalTower(pBoardFM)){ 
					if(boardTower.isEmptyTower()){
						if(currentplayer.hasSpace(index)){
							((FamtoTower) currentaction).setChosenTower(index);
							((FamtoTower) currentaction).floorChoice(game);
						}
						else{
							((FamtoTower) currentaction).towerChoice();
						}		
					} 
					else {
						if((currentplayer.getResources()).getCoin() >= GeneralParameters.towerFee){
							if(currentplayer.hasSpace(index)){
								totalCostPreview.addCoins(GeneralParameters.towerFee);
								((FamtoTower) currentaction).setTotalCostPreview(totalCostPreview);
								((FamtoTower) currentaction).setChosenTower(index);
								((FamtoTower) currentaction).floorChoice(game);
							}					
							else{
								((FamtoTower) currentaction).towerChoice();
		
							}
						} 
						else {
							((FamtoTower) currentaction).towerChoice();	
						}
					}
				} 
				else {
					((FamtoTower) currentaction).towerChoice();
				}
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
