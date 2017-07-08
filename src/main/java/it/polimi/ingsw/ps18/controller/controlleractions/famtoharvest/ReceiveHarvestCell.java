package it.polimi.ingsw.ps18.controller.controlleractions.famtoharvest;

import java.util.List;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.board.Board;
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

public class ReceiveHarvestCell implements ActionChoice {
	private int index;

	@Override
	public void act(GameLogic game) {
		Action currentaction = game.getOngoingAction();
		if(index == 0){
			((FamtoHarvest) currentaction).famchoice();
		}
		else if(index < 0){
			((FamtoHarvest) currentaction).cellChoice();
		}
		else{
			index-=1;
			
			PBoard currentplayer = game.getTurnplayer();
			Board gameBoard = game.getBoard();
			List<HarvCell> harvCells = gameBoard.getHarvestCells();
			List<Cards> playerCards = currentplayer.getCards();
			HarvCell harvCellNoMalus = gameBoard.getHarvCellNoMalus();
			FMember chosenFam = ((FamtoHarvest) currentaction).getChosenFam();
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
				if(harvCellNoMalus.isEmptyHC() || skipfullspacecontrol){
					if(harvCellNoMalus.isLegalHC(chosenFam.getValue() + modifierValue + ((FamtoHarvest) currentaction).getNumberOfServants() / malusServants)){
						((FamtoHarvest) currentaction).setChosenCell(index);
						currentaction.act(game);
					}
					else{
						((FamtoHarvest) currentaction).famchoice();
					}
				}
				else{
					System.out.println("\n[ReceiveHarvestCell]Pirla e' gia' occupata!\n");
					((FamtoHarvest) currentaction).cellChoice();
				}
			}
			else{ //Se invece ho scelto "2" (che ora vale 1 per aver fatto index-=1 sopra all'inizio)
				if(game.getNplayer() > 2){
					if(gameBoard.isLegalHarv(chosenFam)){
						if(index == 0){
							if(harvCellNoMalus.isEmptyHC() || skipfullspacecontrol){
								if(harvCellNoMalus.isLegalHC(chosenFam.getValue() + modifierValue + ((FamtoHarvest) currentaction).getNumberOfServants() / malusServants)){
									((FamtoHarvest) currentaction).setChosenCell(index);
									currentaction.act(game);
								}
								else
									((FamtoHarvest) currentaction).famchoice();
							}
							else
								((FamtoHarvest) currentaction).cellChoice();
						}
						else{
							HarvCell temp = new HarvCell(GeneralParameters.baseMalusHarvCells);
							if(temp.isLegalHC(chosenFam.getValue() + modifierValue + ((FamtoHarvest) currentaction).getNumberOfServants() / malusServants)){
								((FamtoHarvest) currentaction).setChosenCell(index);
								currentaction.act(game);
							}
							else
								((FamtoHarvest) currentaction).famchoice();
						}
					}	
					else{
						Action action = new TurnHandler(currentplayer);
						game.setOngoingAction(action);
						((TurnHandler) action).act(game);
					}
				}
				else{
					System.out.println("[ReceiveHarvestCell] Coglione se siete in 2 l'harvest ha una cella sola!\n");
					((FamtoHarvest) currentaction).cellChoice();
				}
			}
		}
	}

	@Override
	public void setIndex(int i) {
		this.index = i;
	}

}
