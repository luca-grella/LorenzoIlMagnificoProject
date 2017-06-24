package it.polimi.ingsw.ps18.controller.controlleractions.famtotower;

import java.util.List;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.board.boardcells.Cell;
import it.polimi.ingsw.ps18.model.board.boardcells.ConcreteTower;
import it.polimi.ingsw.ps18.model.board.boardcells.Tower;
import it.polimi.ingsw.ps18.model.cards.BlueC;
import it.polimi.ingsw.ps18.model.cards.BonusTile;
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

// TODO: Auto-generated Javadoc
/**
 * Sets the ongoing action (placing the Family Member to a Tower Cell) and goes
 * to the Family Member choice.
 *
 * @author yazan-matar
 */
public class FamtoTowerTrigger implements ActionChoice {
	
	/**
	 * Controls if there's at least a Family Member in the current player
	 * Personal Board that can be put in at least one Tower:
	 * <ol>
	 * <li>It finds the Family Member with the greater Action Value and
	 * eventually adds the player cards's action bonuses and all of the player's
	 * servants.
	 * <li>Then it checks the legality of the action with that Family Member for
	 * every cell of the Tower, for every Tower:
	 * <ul>
	 * <li>If the action is legal, the method moves to the Family Member choice.
	 * <li>Else, it returns to the Action choice.
	 * </ul>
	 * </ol>
	 * All of this controls are diversified depending on the Family Member color
	 * (neutral/colored).
	 *
	 * @param game
	 *            the game
	 */
	@Override
	public void act(GameLogic game) {
		PBoard currentplayer = game.getTurnplayer();
		List<Tower> towers = game.getBoard().getTowers();
		
		for(int towerIndex=0; towerIndex<GeneralParameters.numberofBaseTowers; towerIndex++){
			ConcreteTower boardTower = (ConcreteTower) towers.get(towerIndex); 
			List<Cell> towerCells = boardTower.getTowerCells();
			FMember maxFM = new FMember(0, currentplayer.getPlayercol());
			FMember maxNeutralFM = new FMember(0, currentplayer.getPlayercol());
			int maxValue = 0;
			int maxNeutralValue = 0;
			int modifierValue = 0;
			
			for(Cards card: currentplayer.getCards()){
				if(card.hasPermanent()){
					if(card.getColor()==1){
						for(Permanenteffect effect: ((BlueC) card).getPermeffect()){
							switch(towerIndex){
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
					} else if(card.getColor()==-1){
						for(Permanenteffect effect: ((BonusTile) card).getPermeffect()){
							switch(towerIndex){
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
			}
			for(int famIndex=0; famIndex<currentplayer.getFams().size(); famIndex++){
				FMember curFM = currentplayer.getFams().get(famIndex);
				if(curFM!=null){
					if(curFM.getColor() == GeneralParameters.neutralFMColor){
						maxNeutralValue = curFM.getValue() + currentplayer.getResources().getServants();
						if(maxNeutralValue > maxNeutralFM.getValue() ){
							maxNeutralFM.setValue(maxNeutralValue + modifierValue);
							maxNeutralFM.setColor(curFM.getColor());
							/*
							 * Penso sia ridondante, perche' prima ho chiamato il costruttore del FM neutro
							 */
						}
					}
					else{
						maxValue = curFM.getValue() + currentplayer.getResources().getServants();
						if(maxValue > maxFM.getValue() ){
							maxFM.setValue(maxValue + modifierValue);
							maxFM.setColor(curFM.getColor());
						}
					}
				}
			}
			

			if(boardTower.isLegalTower(maxFM)){
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
				if(boardTower.isLegalTower(maxNeutralFM)){
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
		}
		Action action = game.getOngoingAction();
		action.act(game);
	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice#setIndex(int)
	 */
	@Override
	public void setIndex(int i) {
		return;
	}

}
