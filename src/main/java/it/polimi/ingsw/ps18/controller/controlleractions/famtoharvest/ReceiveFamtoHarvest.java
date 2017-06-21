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


/**
 * 
 * @author yaz
 *
 */
public class ReceiveFamtoHarvest implements ActionChoice {
	int index;
	
	@Override
	public void act(GameLogic game) {
		Action currentaction = game.getOngoingAction();
		PBoard currentplayer = game.getTurnplayer();
		List<FMember> fams = currentplayer.getFams();
		FMember chosenfam = fams.get(index);
		((FamtoHarvest) currentaction).setIndexFamtoRemove(index);
		List<HarvCell> harvCells = game.getBoard().getHarvestCells();
		
		if( ! (harvCells.isEmpty()) ){
			if(game.getBoard().isLegalHarv(chosenfam)){
				HarvCell harvCell = new HarvCell(GeneralParameters.baseMalusHarvCells);
				if(harvCell.isLegalHC(chosenfam)){
					currentaction.setChosenFam(chosenfam);
					((FamtoHarvest) currentaction).act(game);
				}
				else{
					//Entra qui soltanto se il familiare era legale, ma il suo valore non era sufficiente rispetto a quello della cella
					Action action = new TurnHandler(currentplayer);
					game.setOngoingAction(action);
				}
			}
			else{
				//Se e' illegale, forse puo' ancora inserire un familiare neutro
				for(int famIndex=0; famIndex<fams.size(); famIndex++){
					if(chosenfam.getColor() == GeneralParameters.neutralFMColor){
						((FamtoHarvest) currentaction).famchoice();
						return;
					}
					//else cicla al familiare dopo
				}
				//Se non ha alcun familiare neutro, esci
				Action action = new TurnHandler(currentplayer);
				game.setOngoingAction(action);
				//Ci vorrebbe un messaggio di errore, sia qui che in tutte le altre classi del controller

			}
		}
		//L'ArrayList e' vuoto, procedi
		else{
			HarvCell harvCell = new HarvCell(0); //malus=0
			if(harvCell.isLegalHC(chosenfam)){
				currentaction.setChosenFam(chosenfam);
				((FamtoHarvest) currentaction).act(game);
			}
			else{
				Action action = new TurnHandler(currentplayer);
				game.setOngoingAction(action);
			}
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
