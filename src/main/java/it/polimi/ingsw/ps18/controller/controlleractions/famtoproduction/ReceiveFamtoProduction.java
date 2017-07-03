package it.polimi.ingsw.ps18.controller.controlleractions.famtoproduction;

import java.util.List;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.board.boardcells.HarvCell;
import it.polimi.ingsw.ps18.model.board.boardcells.ProdCell;
import it.polimi.ingsw.ps18.model.cards.Excommunications;
import it.polimi.ingsw.ps18.model.effect.excommEffects.ExcommEffects;
import it.polimi.ingsw.ps18.model.effect.excommEffects.MalusValue;
import it.polimi.ingsw.ps18.model.gamelogic.Action;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoHarvest;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoProduction;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.gamelogic.GeneralParameters;
import it.polimi.ingsw.ps18.model.gamelogic.TurnHandler;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

/**
 * Receives a Family Member chosen by the current player and moves to the
 * actiovation of the Production Cell.
 *
 * @author yazan-matar
 */
public class ReceiveFamtoProduction implements ActionChoice {
	
	/**
	 * The index.
	 */
	private int index;
	
	
	/**
	 * Controls if the chosen Family Member is empty (meaning that it was
	 * already used in the previous turns):
	 * <ul>
	 * <li>If the Family Member is empty, the method returns to the Family
	 * Member choice.
	 * <li>Else, it moves to the activation of the Production Cell.
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
			((FamtoProduction) currentaction).famchoice();
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
			((FamtoProduction) currentaction).setIndexFamtoRemove(index);
			List <ProdCell> prodCells = game.getBoard().getProductionCells();
			if(chosenfam != null){
				((FamtoProduction) currentaction).servantsChoice(game);
				if( ! (prodCells.isEmpty()) ){
					if(game.getBoard().isLegalProd(chosenfam)){
						ProdCell prodCell = new ProdCell(GeneralParameters.baseMalusProdCells);
						if(prodCell.isLegalPC(chosenfam.getValue() + (((FamtoProduction) currentaction).getNumberOfServants() / malusServants))){
							currentaction.setChosenFam(chosenfam);
							((FamtoProduction) currentaction).act(game);
						}
						else{
							Action action = new TurnHandler(currentplayer);
							game.setOngoingAction(action);
							action.act(game);
						}
					}
					else{
						Action action = new TurnHandler(currentplayer);
						game.setOngoingAction(action);
						action.act(game);
					}
				}
				else{
					ProdCell prodCell = new ProdCell(0);
					if(prodCell.isLegalPC(chosenfam.getValue() + (((FamtoProduction) currentaction).getNumberOfServants() / malusServants))){
						currentaction.setChosenFam(chosenfam);
						((FamtoProduction) currentaction).act(game);
					}
					else{
						Action action = new TurnHandler(currentplayer);
						game.setOngoingAction(action);
						action.act(game);
					}
				}
			}
			else{
				((FamtoProduction) currentaction).famchoice();
			}
		}
		
	}

	/**
	 * @see it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice#setIndex(int)
	 */
	@Override
	public void setIndex(int i) {
		this.index = i;
	}

}
