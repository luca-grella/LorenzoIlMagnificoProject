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
 * Receives a Family Member chosen by the current player and moves to the activation of the Harvest Cell
 * 
 * @author yazan-matar
 *
 */
public class ReceiveFamtoHarvest implements ActionChoice {
	int index;
	
	
	/**
	 * Controls if the chosen Family Member is empty (meaning that it was already used in the previous turns):
	 * <ul> 
	 * 	<li> If the Family Member is empty, the method returns to the Family Member choice.
	   	<li> Else, it moves to the activation of the Harvest Cell.
	 * </ul>
	 */
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
