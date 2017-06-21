package it.polimi.ingsw.ps18.controller.controlleractions.famtotower;

import java.util.List;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.board.boardcells.Cell;
import it.polimi.ingsw.ps18.model.board.boardcells.ConcreteTower;
import it.polimi.ingsw.ps18.model.board.boardcells.Tower;
import it.polimi.ingsw.ps18.model.cards.BlueC;
import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.effect.permeffects.Permanenteffect;
import it.polimi.ingsw.ps18.model.gamelogic.Action;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoCouncil;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoHarvest;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoTower;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.gamelogic.GeneralParameters;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

/**
 * Receiv
 * @author yazan-matar
 *
 */
public class FamtoTowerTrigger implements ActionChoice {

	@Override
	public void act(GameLogic game) {
		PBoard currentplayer = game.getTurnplayer();
		FMember maxFM = new FMember(0, currentplayer.getPlayercol());
		FMember maxNeutralFM = new FMember(0, currentplayer.getPlayercol());
		List<Tower> towers = game.getBoard().getTowers();
		int maxValue = 0;
		int maxNeutralValue = 0;
		
		int modifierValue = 0;
		for(Cards card: currentplayer.getCards()){
			if(card.hasPermanent()){
				for(Permanenteffect effect: ((BlueC) card).getPermeffect()){
					if("IncraseFMvalueOnHarvest".equals(effect.getName())){
						modifierValue += effect.getQuantity();
					}
				}
			}
		}
		
		for(int famIndex=0; famIndex<currentplayer.getFams().size(); famIndex++){
			FMember curFM = currentplayer.getFams().get(famIndex);
			if(curFM.getColor() == GeneralParameters.neutralFMColor){
				maxNeutralValue = curFM.getValue() + currentplayer.getResources().getServants() + modifierValue;
				if(maxNeutralValue > maxNeutralFM.getValue() ){
					maxNeutralFM.setValue(maxNeutralValue);
					maxNeutralFM.setColor(curFM.getColor()); //penso sia ridondante, perche' prima ho chiamato il costruttore del FM neutro
					//PERO' STICAZZI
				}
			}
			else{
				maxValue = curFM.getValue() + currentplayer.getResources().getServants() + modifierValue;
				if(maxValue > maxFM.getValue() ){
					maxFM.setValue(maxValue);
					maxFM.setColor(curFM.getColor());
				}
			}
		}
		
		for(int towerIndex=0; towerIndex<GeneralParameters.numberofBaseTowers; towerIndex++){
			ConcreteTower boardTower = (ConcreteTower) towers.get(towerIndex); 
			List<Cell> towerCells = boardTower.getTowerCells();

			if(boardTower.isLegalT(maxFM)){
				for(int cellIndex=0; cellIndex<GeneralParameters.numberofCells; cellIndex++){ //Valutare se mettere towerCells.size
					Cell towerCell = towerCells.get(cellIndex);
					if(towerCell.isEmptyTC()){
						if(maxFM.getValue() > towerCell.getCellValue()){
							Action action = new FamtoTower(currentplayer.getpBoardView());
							game.setOngoingAction(action);
							((FamtoTower) action).famchoice();
							return;
						}
					}
				}
			}
			else{
				if(boardTower.isLegalT(maxNeutralFM)){
					for(int cellIndex=0; cellIndex<GeneralParameters.numberofCells; cellIndex++){
						Cell towerCell = towerCells.get(cellIndex);
						if(towerCell.isEmptyTC()){
							if(maxFM.getValue() > towerCell.getCellValue()){
								Action action = new FamtoTower(currentplayer.getpBoardView());
								game.setOngoingAction(action);
								((FamtoTower) action).famchoice();
								return;
							}
						}
					}
				}
			}
			Action action = game.getOngoingAction();
			action.act(game);	
		}
		/*
		 * TODO: bisogna analizzare ogni cella della torre con il rispettivo valore perchè
		 * il punto è garantire che almeno un familiare del giocatore possa avere accesso ad una cella
		 * della torre. Poi oltre che al valore massimo dei familiari bisogna tener conto anche degli
		 * effetti permanenti delle carte blu.
		 * --------------------------------------------------------------------------
		 * "Non te preoccupà"(cit)
		 */
	}

	@Override
	public void setIndex(int i) {
		return;
	}

}
