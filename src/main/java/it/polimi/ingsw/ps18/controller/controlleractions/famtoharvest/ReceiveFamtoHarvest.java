package it.polimi.ingsw.ps18.controller.controlleractions.famtoharvest;

import java.util.List;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.board.boardcells.HarvCell;
import it.polimi.ingsw.ps18.model.cards.Excommunications;
import it.polimi.ingsw.ps18.model.effect.excommEffects.ExcommEffects;
import it.polimi.ingsw.ps18.model.effect.excommEffects.MalusValue;
import it.polimi.ingsw.ps18.model.gamelogic.Action;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoHarvest;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.gamelogic.GeneralParameters;
import it.polimi.ingsw.ps18.model.gamelogic.TurnHandler;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

/**
 * Receives a Family Member chosen by the current player and moves to the
 * activation of the Harvest Cell.
 *
 * @author yazan-matar
 */
public class ReceiveFamtoHarvest implements ActionChoice {
	
	/**
	 * The index.
	 */
	int index;
	
	
	/**
	 * Controls if the chosen Family Member is empty (meaning that it was
	 * already used in the previous turns):
	 * <ul>
	 * <li>If the Family Member is empty, the method returns to the Family
	 * Member choice.
	 * <li>Else, it moves to the activation of the Harvest Cell.
	 * </ul>
	 *
	 * @param game
	 *            the game
	 */
	@Override
	public void act(GameLogic game) {
		if(index==0){
			Action tHandler = new TurnHandler(game.getTurnplayer());
			game.setOngoingAction(tHandler);
			tHandler.act(game);
		} else if(index<0 || index>GeneralParameters.nfamperplayer){
			Action currentaction = game.getOngoingAction();
			((FamtoHarvest) currentaction).famchoice();
		} else {
			index -= 1;
			Action currentaction = game.getOngoingAction();
			PBoard currentplayer = game.getTurnplayer();
			int malusServants = 1;
			for(Excommunications card: currentplayer.getExcommCards()){
				for(ExcommEffects effect: card.getEffects()){
					if("MalusValue".equals(effect.getName())){
						if("Servants".equals(((MalusValue) effect).getPlace())){
							malusServants = ((MalusValue) effect).getMalusValue();
							if(malusServants == 0){
								malusServants = 1;
							}
						}
						
					}
				}
			}
			List<FMember> fams = currentplayer.getFams();
			FMember chosenfam = fams.get(index);
			((FamtoHarvest) currentaction).setIndexFamtoRemove(index);
			List<HarvCell> harvCells = game.getBoard().getHarvestCells();
			
			if(chosenfam != null){
				((FamtoHarvest) currentaction).servantsChoice(game);
				if( ! (harvCells.isEmpty()) ){
					if(game.getBoard().isLegalHarv(chosenfam)){
						HarvCell harvCell = new HarvCell(GeneralParameters.baseMalusHarvCells);
						if(harvCell.isLegalHC(chosenfam.getValue() + (((FamtoHarvest) currentaction).getNumberOfServants() / malusServants))){
							currentaction.setChosenFam(chosenfam);
							currentaction.act(game);
						}
						else{
							Action action = new TurnHandler(currentplayer);
							game.setOngoingAction(action);
							((TurnHandler) action).act(game);
						}
					}
					else{
						Action action = new TurnHandler(currentplayer);
						game.setOngoingAction(action);
						((TurnHandler) action).act(game);
					}
				}
				else{
					HarvCell harvCell = new HarvCell(0);
					if(harvCell.isLegalHC(chosenfam.getValue() + (((FamtoHarvest) currentaction).getNumberOfServants() / malusServants))){
						currentaction.setChosenFam(chosenfam);
						((FamtoHarvest) currentaction).act(game);
					}
					else{
						Action action = new TurnHandler(currentplayer);
						game.setOngoingAction(action);
						((TurnHandler) action).act(game);
					}
				}
			}
			else{
				((FamtoHarvest) currentaction).famchoice();
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
