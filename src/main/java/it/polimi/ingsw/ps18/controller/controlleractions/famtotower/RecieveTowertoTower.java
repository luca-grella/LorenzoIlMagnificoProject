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

public class RecieveTowertoTower implements ActionChoice {
	private int index;

	@Override
	public void act(GameLogic game) {
		Action currentaction = game.getOngoingAction();
		Board gameBoard = game.getBoard();
		List<Tower> boardTowers = gameBoard.getTowers();
		FMember pBoardFM = ((FamtoTower) currentaction).getChosenFam();
		ConcreteTower boardTower = (ConcreteTower) boardTowers.get(index);
		if(boardTower.isLegalT(pBoardFM)){ 
			if(boardTower.isEmptyT()){
				//DONE: Controllo se il valore del familiare è maggiore o uguale a quello della cella
				//TODO: Controllo se la carta è presente nella cella
				
				((FamtoTower) currentaction).setChosenTower(index);
				((FamtoTower) currentaction).floorChoice();
				
			} 
			else {
				PBoard currentPlayer = game.getTurnplayer(); //turnplayer nel mondo di francope significa giocatore corrente
				if((currentPlayer.getResources()).getCoin() >= 3){ //TODO: sistemare in GeneralParameters
					currentPlayer.getResources().addCoins(-3); //TODO: Sistemare in GeneralParameters
					((FamtoTower) currentaction).setChosenTower(index);
					((FamtoTower) currentaction).floorChoice();
				} 
				else {
					((FamtoTower) currentaction).towerChoice();
				}
			}
				
		} else {
			((FamtoTower) currentaction).towerChoice();
		}
		
		/*
		 * Controllo, se fallisce il controllo richiamo towerchoice
		 * ((FamtoTower) currentaction).towerChoice();
		 * se va a buon fine controllo le monete, da game.getturnPlayer
		 * Se fallisce, richiama towerchoice
		 * se ha successo, allora  fa setchosentower etc
		 */
//		((FamtoTower) currentaction).setChosenTower(index);
//		((FamtoTower) currentaction).floorChoice();
		

	}

	/**
	 * @param index the index to set
	 */
	@Override
	public void setIndex(int index) {
		this.index = index;
	}

}
