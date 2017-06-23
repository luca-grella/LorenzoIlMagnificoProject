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
		
		if(chosenfam != null){
			if( ! (harvCells.isEmpty()) ){
				if(game.getBoard().isLegalHarv(chosenfam)){
					HarvCell harvCell = new HarvCell(GeneralParameters.baseMalusHarvCells);
					if(harvCell.isLegalHC(chosenfam)){
						currentaction.setChosenFam(chosenfam);
						((FamtoHarvest) currentaction).act(game);
					}
					else{
						Action action = new TurnHandler(currentplayer);
						game.setOngoingAction(action);
					}
				}
				else{
					for(int famIndex=0; famIndex<fams.size(); famIndex++){
						if(chosenfam.getColor() == GeneralParameters.neutralFMColor){
							((FamtoHarvest) currentaction).famchoice();
							return;
						}
					}
					Action action = new TurnHandler(currentplayer);
					game.setOngoingAction(action);
				}
			}
			else{
				HarvCell harvCell = new HarvCell(0);
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
		else{
			((FamtoHarvest) currentaction).famchoice();
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
