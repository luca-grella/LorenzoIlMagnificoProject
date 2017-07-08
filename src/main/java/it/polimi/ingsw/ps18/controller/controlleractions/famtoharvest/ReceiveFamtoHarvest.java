package it.polimi.ingsw.ps18.controller.controlleractions.famtoharvest;

import java.util.List;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.board.boardcells.HarvCell;
import it.polimi.ingsw.ps18.model.cards.BlueC;
import it.polimi.ingsw.ps18.model.cards.BonusTile;
import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.cards.Excommunications;
import it.polimi.ingsw.ps18.model.cards.LeaderCards;
import it.polimi.ingsw.ps18.model.effect.excommEffects.ExcommEffects;
import it.polimi.ingsw.ps18.model.effect.excommEffects.MalusValue;
import it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects.LCPermEffect;
import it.polimi.ingsw.ps18.model.effect.permeffects.Permanenteffect;
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
			List<Cards> playerCards = currentplayer.getCards();
			HarvCell harvCellNoMalus = game.getBoard().getHarvCellNoMalus();
			boolean skipfullspacecontrol = false;
			for(LeaderCards card: currentplayer.getLeadercards()){
				if(card.isActive()){
					for(LCPermEffect effect: card.getPermEffects()){
						if("VariousModifier".equals(effect.getName())){
							if("SkipFullSpaceControl".equals(effect.getShortDescription())){
								skipfullspacecontrol = true;
							}
						}
					}
				}
			}
			
			int modifierValue = 0;
			for(Cards card: playerCards){
				if(card.hasPermanent()){
					if(card.getColor()==1){
						for(Permanenteffect effect: ((BlueC) card).getPermeffect()){
							if("Harvest".equals(effect.getName())){
								modifierValue += effect.getQuantity();
							}
						}
					} else if(card.getColor()==-1){
						for(Permanenteffect effect: ((BonusTile) card).getPermeffect()){
							if("Harvest".equals(effect.getName())){
								modifierValue += effect.getQuantity();
							}
						}
					}
				}
			}
			
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
			
			FMember chosenfam = currentplayer.getFams().get(index);
			((FamtoHarvest) currentaction).setIndexFamtoRemove(index);
			
			if(chosenfam != null){				
				if(game.getBoard().isLegalHarv(chosenfam)){
					((FamtoHarvest) currentaction).servantsChoice(game);
					
					if(harvCellNoMalus.isEmptyHC() || skipfullspacecontrol){
						if(harvCellNoMalus.isLegalHC(chosenfam.getValue() + modifierValue + (((FamtoHarvest) currentaction).getNumberOfServants() / malusServants))){
							currentaction.setChosenFam(chosenfam);
							((FamtoHarvest) currentaction).cellChoice();
							return;
						}
						else{
							((FamtoHarvest) currentaction).famchoice();
						}
					}
					HarvCell harvCellMalus = new HarvCell(GeneralParameters.baseMalusHarvCells);
					if(harvCellMalus.isLegalHC(chosenfam.getValue() + modifierValue + (((FamtoHarvest) currentaction).getNumberOfServants() / malusServants))){
						currentaction.setChosenFam(chosenfam);
						((FamtoHarvest) currentaction).cellChoice();
						return;
					}
					else{
						((FamtoHarvest) currentaction).famchoice();
					}
				}
				else{
					((FamtoHarvest) currentaction).famchoice();
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
