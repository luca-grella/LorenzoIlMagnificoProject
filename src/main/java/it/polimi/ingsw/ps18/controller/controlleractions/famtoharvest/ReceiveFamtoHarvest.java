package it.polimi.ingsw.ps18.controller.controlleractions.famtoharvest;

import java.util.List;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.board.boardcells.HarvCell;
import it.polimi.ingsw.ps18.model.gamelogic.Action;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoHarvest;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.gamelogic.GeneralParameters;
import it.polimi.ingsw.ps18.model.gamelogic.TurnHandler;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class ReceiveFamtoHarvest implements ActionChoice {
	int index;

	@Override
	public void act(GameLogic game) {
		PBoard currentplayer = game.getTurnplayer();
		List<FMember> fams = currentplayer.getFams();
		FMember chosenfam = fams.set(index, null);
		List<HarvCell> harvCells = game.getBoard().getHarvestCells();
		Action currentaction = game.getOngoingAction();
		if( ! (harvCells.isEmpty()) ){
			for(int harvIndex=0; harvIndex<harvCells.size(); harvIndex++){
				if( ! (harvCells.get(harvIndex).isLegalHC(chosenfam)) ){ //Se non e' legale esce
					/*
					 * Non posso mandarlo alla famchoice perche' in queste celle basta che ci sia un familiare 
					 * colorato e non ci si puo' piu' accedere
					 * Se lui ha ancora un fam neutro lo rimando al famchoice
					 * Se no, creo un TurnHandler setto a currentaction e chiamo init
					 * 
					*/
					for(int famIndex=0; famIndex<fams.size(); famIndex++){
						if(chosenfam.getColor() == GeneralParameters.neutralFMColor){
							((FamtoHarvest) currentaction).famchoice();
						}
						//else cicla al familiare dopo
					}
//					Questo se fallisce					
					Action action = new TurnHandler(currentplayer);
					game.setOngoingAction(action);
				}
				//else cicla alla cella dopo
			}
			currentaction.setChosenFam(chosenfam);
			((FamtoHarvest) currentaction).act(game);
		}
		else{
			currentaction.setChosenFam(chosenfam);
			((FamtoHarvest) currentaction).act(game);
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
