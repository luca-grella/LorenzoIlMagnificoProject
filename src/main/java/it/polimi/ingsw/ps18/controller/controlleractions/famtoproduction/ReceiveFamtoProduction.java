package it.polimi.ingsw.ps18.controller.controlleractions.famtoproduction;

import java.util.List;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.board.boardcells.HarvCell;
import it.polimi.ingsw.ps18.model.board.boardcells.ProdCell;
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
			List<Cards> playerCards = currentplayer.getCards();
			ProdCell prodCellNoMalus = game.getBoard().getProdCellNoMalus();
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
							if("Production".equals(effect.getName())){
								modifierValue += effect.getQuantity();
							}
						}
					} else if(card.getColor()==-1){
						for(Permanenteffect effect: ((BonusTile) card).getPermeffect()){
							if("Production".equals(effect.getName())){
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
			((FamtoProduction) currentaction).setIndexFamtoRemove(index);
			
			if(chosenfam != null){
				if(game.getBoard().isLegalProd(chosenfam)){
					((FamtoProduction) currentaction).servantsChoice(game);
					if(prodCellNoMalus.isEmptyPC() || skipfullspacecontrol){
						if(prodCellNoMalus.isLegalPC(chosenfam.getValue() + modifierValue + (((FamtoProduction) currentaction).getNumberOfServants() / malusServants))){
							currentaction.setChosenFam(chosenfam);
							((FamtoProduction) currentaction).cellChoice();
							return;
						}
						else{
							((FamtoProduction) currentaction).famchoice();
						}
					}
					HarvCell harvCellMalus = new HarvCell(GeneralParameters.baseMalusHarvCells);
					if(harvCellMalus.isLegalHC(chosenfam.getValue() + modifierValue + (((FamtoProduction) currentaction).getNumberOfServants() / malusServants))){
						currentaction.setChosenFam(chosenfam);
						((FamtoProduction) currentaction).cellChoice();
						return;
					}
					else{
						((FamtoProduction) currentaction).famchoice();
					}
				}
				else{
					System.out.println("\n[ReceiveFamtoProduction] Azione illegale!\n");
					((FamtoProduction) currentaction).famchoice();

				}
			}
			else{
				System.out.println("\n[ReceiveFamtoProduction] Familiare gia' utilizzato\n");
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
