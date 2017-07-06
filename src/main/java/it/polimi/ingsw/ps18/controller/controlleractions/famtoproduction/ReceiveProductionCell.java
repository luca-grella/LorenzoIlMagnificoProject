package it.polimi.ingsw.ps18.controller.controlleractions.famtoproduction;

import java.util.List;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.board.Board;
import it.polimi.ingsw.ps18.model.board.boardcells.ProdCell;
import it.polimi.ingsw.ps18.model.cards.BlueC;
import it.polimi.ingsw.ps18.model.cards.BonusTile;
import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.cards.Excommunications;
import it.polimi.ingsw.ps18.model.effect.excommEffects.ExcommEffects;
import it.polimi.ingsw.ps18.model.effect.excommEffects.MalusValue;
import it.polimi.ingsw.ps18.model.effect.permeffects.Permanenteffect;
import it.polimi.ingsw.ps18.model.gamelogic.Action;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoProduction;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.gamelogic.GeneralParameters;
import it.polimi.ingsw.ps18.model.gamelogic.TurnHandler;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class ReceiveProductionCell implements ActionChoice{

	private int index;
	
	
	@Override
	public void act(GameLogic game) {
		Action currentaction = game.getOngoingAction();
		if(index == 0){
			((FamtoProduction) currentaction).famchoice();
		}
		else if(index < 0){
			((FamtoProduction) currentaction).cellChoice();
		}
		else{
			index-=1;
			
			PBoard currentplayer = game.getTurnplayer();
			Board gameBoard = game.getBoard();
			List<Cards> playerCards = currentplayer.getCards();
			ProdCell prodCellNoMalus = gameBoard.getProdCellNoMalus();
			FMember chosenFam = ((FamtoProduction) currentaction).getChosenFam();
			
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
				if(prodCellNoMalus.isEmptyPC()){
					if(prodCellNoMalus.isLegalPC(chosenFam.getValue() + modifierValue + ((FamtoProduction) currentaction).getNumberOfServants() / malusServants)){
						((FamtoProduction) currentaction).setChosenCell(index);
						currentaction.act(game);
					}
					else{
						((FamtoProduction) currentaction).famchoice();
					}
				}
				else{
					System.out.println("\n[ReceiveProductionCell]Pirla e' gia' occupata!\n");
					((FamtoProduction) currentaction).cellChoice();
				}
			}
			else{ //Se invece ho scelto "2" (che ora vale 1 per aver fatto index-=1 sopra all'inizio)
				if(game.getNplayer() > 2){
					if(gameBoard.isLegalProd(chosenFam)){
						if(index == 0){
							if(prodCellNoMalus.isEmptyPC()){
								if(prodCellNoMalus.isLegalPC(chosenFam.getValue() + modifierValue + ((FamtoProduction) currentaction).getNumberOfServants() / malusServants)){
									((FamtoProduction) currentaction).setChosenCell(index);
									currentaction.act(game);
								}
								else
									((FamtoProduction) currentaction).famchoice();
							}
							else
								((FamtoProduction) currentaction).cellChoice();
						}
						else{
							ProdCell temp = new ProdCell(GeneralParameters.baseMalusProdCells);
							if(temp.isLegalPC(chosenFam.getValue() + modifierValue + ((FamtoProduction) currentaction).getNumberOfServants() / malusServants)){
								((FamtoProduction) currentaction).setChosenCell(index);
								currentaction.act(game);
							}
							else
								((FamtoProduction) currentaction).famchoice();
						}
					}	
					else{
						Action action = new TurnHandler(currentplayer);
						game.setOngoingAction(action);
						((TurnHandler) action).act(game);
					}
				}
				else{
					System.out.println("[ReceiveProductionCell] Coglione se siete in 2 la production ha una cella sola!\n");
					((FamtoProduction) currentaction).cellChoice();
				}
			}	
		}
	}

	@Override
	public void setIndex(int i) {
		this.index = i;
	}

}
