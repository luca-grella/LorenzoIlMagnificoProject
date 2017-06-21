package it.polimi.ingsw.ps18.controller.controlleractions.famtotower;

import java.util.ArrayList;
import java.util.List;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.board.Board;
import it.polimi.ingsw.ps18.model.board.boardcells.ConcreteTower;
import it.polimi.ingsw.ps18.model.board.boardcells.Tower;
import it.polimi.ingsw.ps18.model.cards.BlueC;
import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.effect.permeffects.Permanenteffect;
import it.polimi.ingsw.ps18.model.gamelogic.Action;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoTower;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.gamelogic.GeneralParameters;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

public class ReceiveFloortoTower implements ActionChoice {
	private int index;

	@Override
	public void act(GameLogic game) {
		Action currentaction = game.getOngoingAction();
		Board gameBoard = game.getBoard();
		List<Tower> boardTowers = gameBoard.getTowers();
		FamtoTower towerIndex = (FamtoTower) game.getOngoingAction();
		ConcreteTower boardTower = (ConcreteTower)boardTowers.get(towerIndex.getChosenTower());
		PBoard currentplayer = game.getTurnplayer();
		FMember chosenfam = ((FamtoTower) currentaction).getChosenFam();
		Stats cardStats = (((boardTower.getTowerCells()).get(index)).getCellCard()).getCardCost();
		Stats totalCostPreview = ((FamtoTower) currentaction).getTotalCostPreview();
		List<Cards> playerCards = currentplayer.getCards();
		
		int modifierValue = 0;
		for(Cards card: playerCards){
			if(card.hasPermanent()){
				for(Permanenteffect effect: ((BlueC) card).getPermeffect()){
					switch(towerIndex.getChosenTower()){
					case 0:
						if("Green".equals(effect.getName())){
							modifierValue += effect.getQuantity();
						}
						break;
					case 1:
						if("Blue".equals(effect.getName())){
							modifierValue += effect.getQuantity();
						}
						break;
					case 2:
						if("Yellow".equals(effect.getName())){
							modifierValue += effect.getQuantity();
						}
						break;
					case 3:
						if("Purple".equals(effect.getName())){
							modifierValue += effect.getQuantity();
						}
						break;
					}
				}
			}
		}
		
		if((((boardTower.getTowerCells()).get(index)).isEmptyTC())){ 
			if(((boardTower.getTowerCells()).get(index)).isLegalTC(chosenfam.getValue() + modifierValue)){	
				//creare un giocatore farlocco e attivare gli effetti della cella e fare l'ultimo controllo su di lui
				PBoard temp = new PBoard();
				temp.setResources(currentplayer.getResources());
				boardTower.getTowerCells().get(index).activateQEffects(temp, game);
				totalCostPreview.addStats(cardStats);
				if((temp.getResources().enoughStats(totalCostPreview))){
					((FamtoTower) currentaction).setChosenFloor(index);
					currentaction.act(game);
				}
				else{
					((FamtoTower) currentaction).floorChoice();
				}
			}
			else{
				((FamtoTower) currentaction).floorChoice();
			}
		}
	    else {
	    	((FamtoTower) currentaction).floorChoice();
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
