package it.polimi.ingsw.ps18.controller.controlleractions.famtoproduction;

import java.util.List;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.board.Board;
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
 * The Class ReceiveProductionCell.
 */
public class ReceiveProductionCell implements ActionChoice{

	/** The index. */
	private int index;
	
	
	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice#act(it.polimi.ingsw.ps18.model.gamelogic.GameLogic)
	 */
	@Override
	public void act(GameLogic game) {
		PBoard currentplayer = game.getTurnplayer();
		Action currentaction = game.getOngoingAction();
		if(index == 0){
			currentplayer.notifyLogPBoardView("\tUndoing...\n");
			currentplayer.notifyLogPBoardView("\tTurned back to the Family Member choice\n");
			((FamtoProduction) currentaction).famchoice();
		}
		else if(index < 0){
			currentplayer.notifyLogPBoardView("\nError: not a valid input\n");
			currentplayer.notifyLogPBoardView("\tTurned back to the Cell choice\n");
			((FamtoProduction) currentaction).cellChoice();
		}
		else{
			index-=1;
			Board gameBoard = game.getBoard();
			List<Cards> playerCards = currentplayer.getCards();
			ProdCell prodCellNoMalus = gameBoard.getProdCellNoMalus();
			FMember chosenFam = ((FamtoProduction) currentaction).getChosenFam();
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
			for(Excommunications card: game.getTurnplayer().getExcommCards()){
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
			
			if(index == 0){
				if(prodCellNoMalus.isEmptyPC() || skipfullspacecontrol){
					currentplayer.notifyLogPBoardView("\nYou chose to access the Production Cell without malus\n");
					if(prodCellNoMalus.isLegalPC(chosenFam.getValue() + modifierValue + ((FamtoProduction) currentaction).getNumberOfServants() / malusServants)){
						((FamtoProduction) currentaction).setChosenCell(index);
						currentaction.act(game);
					}
					else{
						currentplayer.notifyLogPBoardView("\nThe chosen Family Member doesn't have enough Action Value:\n"
								+ "Please choose another one\n");
						((FamtoProduction) currentaction).famchoice();
					}
				}
				else{
					currentplayer.notifyLogPBoardView("\nYou can't access this Cell:\n");
					currentplayer.notifyLogPBoardView("The chosen Cell was already occupied!\n");
					((FamtoProduction) currentaction).cellChoice();
				}
			}
			else{
				if(game.getNplayer() > 2){
					if(gameBoard.isLegalProd(chosenFam)){
						if(index == 0){
							if(prodCellNoMalus.isEmptyPC() || skipfullspacecontrol){
								currentplayer.notifyLogPBoardView("\nYou chose to access the Production Cell without malus\n");
								if(prodCellNoMalus.isLegalPC(chosenFam.getValue() + modifierValue + ((FamtoProduction) currentaction).getNumberOfServants() / malusServants)){
									((FamtoProduction) currentaction).setChosenCell(index);
									currentaction.act(game);
								}
								else{
									currentplayer.notifyLogPBoardView("\nThe chosen Family Member doesn't have enough Action Value:\n"
											+ "Please choose another one\n");
									((FamtoProduction) currentaction).famchoice();
								}
							}
							else{
								currentplayer.notifyLogPBoardView("\nYou can't access this Cell:\n");
								currentplayer.notifyLogPBoardView("The chosen Cell was already occupied!\n");
								((FamtoProduction) currentaction).cellChoice();
							}
						}
						else{
							currentplayer.notifyLogPBoardView("\nYou chose to access the Production Zone with malus\n");
							ProdCell temp = new ProdCell(GeneralParameters.baseMalusProdCells);
							if(temp.isLegalPC(chosenFam.getValue() + modifierValue + ((FamtoProduction) currentaction).getNumberOfServants() / malusServants)){
								((FamtoProduction) currentaction).setChosenCell(index);
								currentaction.act(game);
							}
							else{
								currentplayer.notifyLogPBoardView("\nThe chosen Family Member doesn't have enough Action Value:\n"
										+ "Please choose another one\n");
								((FamtoProduction) currentaction).famchoice();
							}
						}
					}	
					else{
						currentplayer.notifyLogPBoardView("\nThe action is not legal\n"
								+ "Please choose another action\n");
						Action action = new TurnHandler(currentplayer);
						game.setOngoingAction(action);
						((TurnHandler) action).act(game);
					}
				}
				else{
					currentplayer.notifyLogPBoardView("\nYou can't access the Production Zone unless there are four players in a Game\n");
					((FamtoProduction) currentaction).cellChoice();
				}
			}	
		}
	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice#setIndex(int)
	 */
	@Override
	public void setIndex(int i) {
		this.index = i;
	}

}
