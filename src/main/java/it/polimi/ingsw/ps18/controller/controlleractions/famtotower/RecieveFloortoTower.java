package it.polimi.ingsw.ps18.controller.controlleractions.famtotower;

import java.util.List;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.board.Board;
import it.polimi.ingsw.ps18.model.board.boardcells.ConcreteTower;
import it.polimi.ingsw.ps18.model.board.boardcells.Tower;
import it.polimi.ingsw.ps18.model.gamelogic.Action;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoTower;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class RecieveFloortoTower implements ActionChoice {
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
		
		//TODO: dato che ora la classe Cell è PUBBLICA, forse si possono evitare sti getter
		if( ! (((boardTower.getTowerCells()).get(index)).isEmptyTC())){ 
			/*
			 * Vecchio controllo che mi tengo buono nel caso in cui lo spostamento dei metodi al model dia problemi
			 * P.S: Ovviamente sta dando problemi
			 */
			
//			if(pBoardFM.getValue() >= ((boardTower.getTowerCells()).get(index)).getValue()){
//				if(((boardTower.getTowerCells()).get(index)).getCellCard() == null){
//					((FamtoTower) currentaction).floorChoice();
//				}
//				else{
//					((FamtoTower) currentaction).setChosenFloor(index);
//					currentaction.act(game);
//				}
//			}
			
			if(((boardTower.getTowerCells()).get(index)).isLegalTC(pBoardFM)){
//				if((currentPlayer.getResources()).){
//				TODO: SCRIVERE UN METODO CHE CONFRONTI LE RISORSE DEL GIOCATORE CON LE RISORSE RICHIESTE DALLA CARTA
//				}
				((FamtoTower) currentaction).setChosenFloor(index);
				currentaction.act(game);
			}
			else
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
