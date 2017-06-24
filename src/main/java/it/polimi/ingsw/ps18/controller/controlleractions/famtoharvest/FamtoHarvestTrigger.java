package it.polimi.ingsw.ps18.controller.controlleractions.famtoharvest;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.board.boardcells.HarvCell;
import it.polimi.ingsw.ps18.model.cards.BlueC;
import it.polimi.ingsw.ps18.model.cards.BonusTile;
import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.effect.permeffects.Permanenteffect;
import it.polimi.ingsw.ps18.model.gamelogic.Action;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoHarvest;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.gamelogic.GeneralParameters;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;


// TODO: Auto-generated Javadoc
/**
 * Sets the ongoing action (placing the Family Member to a Harvest Cell) and
 * goes to the Family Member choice.
 *
 * @author yazan-matar
 */
public class FamtoHarvestTrigger implements ActionChoice {
	
	/**
	 * Controls if there's at least a Family Member in the current player
	 * Personal Board that can be put in at least one Harvest Cell (with or
	 * without the malus value):
	 * <ol>
	 * <li>It finds the Family Member with the greater Action Value and
	 * eventually adds the player cards's action bonuses and all of the player's
	 * servants.
	 * <li>Then it checks the legality of the action with that Family Member for
	 * every cell of the Harvest:
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
		FMember maxFM = new FMember(0, currentplayer.getPlayercol());
		FMember maxNeutralFM = new FMember(0, currentplayer.getPlayercol());
		int modifierValue = 0;
		
		for(Cards card: currentplayer.getCards()){
			if(card.hasPermanent()){
				if(card.getColor()==1){
					for(Permanenteffect effect: ((BlueC) card).getPermeffect()){
						//TODO: INCRASE NELLA LINGUA DI FRANCO SIGNIFICA INCREASE: MODIFICARE LE SETTORDICI CLASSI CON SCRITTO INCRASE
						//COMPRESI I NOMI DELLE FOTTUTE CLASSI
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
		
		if(game.getNplayer() > 2){
			int maxValue = 0;
			int maxNeutralValue = 0;
			for(int famIndex=0; famIndex<currentplayer.getFams().size(); famIndex++){
				FMember curFM = currentplayer.getFams().get(famIndex);
				if(curFM!=null){
					if(curFM.getColor() == GeneralParameters.neutralFMColor){
						maxNeutralValue = curFM.getValue() + currentplayer.getResources().getServants();
						if(maxNeutralValue > maxNeutralFM.getValue() ){
							maxNeutralFM.setValue(maxNeutralValue + modifierValue);
							maxNeutralFM.setColor(curFM.getColor());
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
			//In quanto l'accesso e' sequenziale
			if(game.getBoard().getHarvestCells().isEmpty()){
				HarvCell harvCell = new HarvCell(0); //TODO: generalparameters
				if(harvCell.isLegalHC(maxFM)){ 
					Action action = new FamtoHarvest(currentplayer.getpBoardView());
					game.setOngoingAction(action);
					((FamtoHarvest) action).famchoice();
				}
				else{
					Action action = game.getOngoingAction();
					action.act(game); 
				}
			}
			else{
				if(game.getBoard().isLegalHarv(maxFM)){
					HarvCell harvCell = new HarvCell(GeneralParameters.baseMalusHarvCells);
					if(harvCell.isLegalHC(maxFM)){ 
						Action action = new FamtoHarvest(currentplayer.getpBoardView());
						game.setOngoingAction(action);
						((FamtoHarvest) action).famchoice();
					}
				}
				else if(game.getBoard().isLegalHarv(maxNeutralFM)){
					HarvCell harvCell = new HarvCell(GeneralParameters.baseMalusHarvCells);
					if(harvCell.isLegalHC(maxNeutralFM)){ 
						Action action = new FamtoHarvest(currentplayer.getpBoardView());
						game.setOngoingAction(action);
						((FamtoHarvest) action).famchoice();
					}
				}
				else{
					Action action = game.getOngoingAction();
					action.act(game); 
				}
			}
		}
		else if(game.getNplayer() == 2){
			int maxValue = 0;
			if((((game.getBoard()).getHarvestCells()).isEmpty())){
				
				for(int famIndex=0; famIndex<currentplayer.getFams().size(); famIndex++){
					maxValue = currentplayer.getFams().get(famIndex).getValue() + currentplayer.getResources().getServants();
					if(maxValue > maxFM.getValue()){
						maxFM.setValue(maxValue + modifierValue);
					}
				}
				if(maxFM.getValue() > GeneralParameters.baseValueHarvCells){
					Action action = new FamtoHarvest(currentplayer.getpBoardView());
					game.setOngoingAction(action);
					((FamtoHarvest) action).famchoice();
				}
				else{
					Action action = game.getOngoingAction();
					action.act(game);
				}
			}
			else{
				Action action = game.getOngoingAction();
				action.act(game); 
			}
		}
	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice#setIndex(int)
	 */
	@Override
	public void setIndex(int i) {
		return;
	}

}
