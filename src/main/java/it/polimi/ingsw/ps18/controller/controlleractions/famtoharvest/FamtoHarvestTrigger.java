package it.polimi.ingsw.ps18.controller.controlleractions.famtoharvest;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.board.boardcells.HarvCell;
import it.polimi.ingsw.ps18.model.cards.BlueC;
import it.polimi.ingsw.ps18.model.cards.BonusTile;
import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.cards.LeaderCards;
import it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects.LCPermEffect;
import it.polimi.ingsw.ps18.model.effect.permeffects.Permanenteffect;
import it.polimi.ingsw.ps18.model.gamelogic.Action;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoHarvest;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.gamelogic.GeneralParameters;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;


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
		FMember maxFM = new FMember(0, currentplayer.getPlayercol(), currentplayer);
		FMember maxNeutralFM = new FMember(0, currentplayer.getPlayercol(), currentplayer);
		HarvCell harvCellNoMalus =  game.getBoard().getHarvCellNoMalus();
		
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
			if(maxFM.getValue() == 0){
				maxFM = null;
			}
			if(maxNeutralFM.getValue() == 0){
				maxNeutralFM = null;
			}
			
			
			if(game.getBoard().isLegalHarv(maxFM)){
				if(harvCellNoMalus.isEmptyHC() || skipfullspacecontrol){
					if(maxFM != null){
						if(harvCellNoMalus.isLegalHC(maxFM.getValue())){
							currentplayer.notifyLogPBoardView("\n[Harvest]The action is legal\n"
									+ "\tYou can proceed\n");
							Action action = new FamtoHarvest(currentplayer.getpBoardView());
							game.setOngoingAction(action);
							((FamtoHarvest) action).famchoice();
							return;
						}
						else{
							currentplayer.notifyLogPBoardView("\n[Harvest]The action is not legal\n"
									+ "Choose another action\n");
							Action action = game.getOngoingAction();
							action.act(game); 
							return;
						}
					}
					else{
						currentplayer.notifyLogPBoardView("\n[Harvest]The action is not legal\n"
								+ "Choose another action\n");
						Action action = game.getOngoingAction();
						action.act(game); 
						return;
					}
					
				}
				HarvCell harvCellMalus = new HarvCell(GeneralParameters.baseMalusHarvCells);
				if(maxFM != null){
					if(harvCellMalus.isLegalHC(maxFM.getValue())){ 
						currentplayer.notifyLogPBoardView("\n[Harvest]The action is legal\n"
								+ "\tYou can proceed\n");
						Action action = new FamtoHarvest(currentplayer.getpBoardView());
						game.setOngoingAction(action);
						((FamtoHarvest) action).famchoice();
						return;
					}
					else{
						currentplayer.notifyLogPBoardView("\n[Harvest]The action is not legal\n"
								+ "Choose another action\n");
						Action action = game.getOngoingAction();
						action.act(game); 
						return;
					}
				}
				else{
					currentplayer.notifyLogPBoardView("\n[Harvest]The action is not legal\n"
							+ "Choose another action\n");
					Action action = game.getOngoingAction();
					action.act(game); 
					return;
				}
				
			}
			
			if(game.getBoard().isLegalHarv(maxNeutralFM)){
				if(harvCellNoMalus.isEmptyHC() || skipfullspacecontrol){
					if(maxNeutralFM != null){
						if(harvCellNoMalus.isLegalHC(maxNeutralFM.getValue())){
							currentplayer.notifyLogPBoardView("\n[Harvest]The action is legal\n"
									+ "\tYou can proceed\n");
							Action action = new FamtoHarvest(currentplayer.getpBoardView());
							game.setOngoingAction(action);
							((FamtoHarvest) action).famchoice();
							return;
						}
						else{
							currentplayer.notifyLogPBoardView("\n[Harvest]The action is not legal\n"
									+ "Choose another action\n");
							Action action = game.getOngoingAction();
							action.act(game); 
							return;
						}
					}
					else{
						currentplayer.notifyLogPBoardView("\n[Harvest]The action is not legal\n"
								+ "Choose another action\n");
						Action action = game.getOngoingAction();
						action.act(game); 
						return;
					}
					
				}
				HarvCell harvCellMalus = new HarvCell(GeneralParameters.baseMalusHarvCells);
				if(maxNeutralFM != null){
					if(harvCellMalus.isLegalHC(maxNeutralFM.getValue())){ 
						currentplayer.notifyLogPBoardView("\n[Harvest]The action is legal\n"
								+ "\tYou can proceed\n");
						Action action = new FamtoHarvest(currentplayer.getpBoardView());
						game.setOngoingAction(action);
						((FamtoHarvest) action).famchoice();
						return;
					}
					else{
						currentplayer.notifyLogPBoardView("\n[Harvest]The action is not legal\n"
								+ "Choose another action\n");
						Action action = game.getOngoingAction();
						action.act(game); 
						return;
					}
				}
				else{
					currentplayer.notifyLogPBoardView("\n[Harvest]The action is not legal\n"
							+ "Choose another action\n");
					Action action = game.getOngoingAction();
					action.act(game); 
					return;
				}
			}
			currentplayer.notifyLogPBoardView("\n[Harvest]The action is not legal\n"
					+ "Choose another action\n");
			Action action = game.getOngoingAction();
			action.act(game); 
		}
		else if(game.getNplayer() == 2){
			int maxValue = 0;
			int maxNeutralValue = 0;
			
			
			if(game.getBoard().getHarvCellNoMalus().isEmptyHC() || skipfullspacecontrol){
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
				if(maxFM.getValue() == 0){
					maxFM = null;
				}
				if(maxNeutralFM.getValue() == 0){
					maxNeutralFM = null;
				}
				
				if(harvCellNoMalus.isEmptyHC() || skipfullspacecontrol){
					if(maxFM != null){
						if(harvCellNoMalus.isLegalHC(maxFM.getValue())){ 
							currentplayer.notifyLogPBoardView("\n[Harvest]The action is legal\n"
									+ "\tYou can proceed\n");
							Action action = new FamtoHarvest(currentplayer.getpBoardView());
							game.setOngoingAction(action);
							((FamtoHarvest) action).famchoice();
							return;
						}
					}
					else{
						currentplayer.notifyLogPBoardView("\n[Harvest]The action is not legal\n"
								+ "Choose another action\n");
						Action action = game.getOngoingAction();
						action.act(game); 
						return;
					}
					if(maxNeutralFM != null){
						if(harvCellNoMalus.isLegalHC(maxNeutralFM.getValue())){ 
							currentplayer.notifyLogPBoardView("\n[Harvest]The action is legal\n"
									+ "\tYou can proceed\n");
							Action action = new FamtoHarvest(currentplayer.getpBoardView());
							game.setOngoingAction(action);
							((FamtoHarvest) action).famchoice();
							return;
						}
					}
					else{
						currentplayer.notifyLogPBoardView("\n[Harvest]The action is not legal\n"
								+ "Choose another action\n");
						Action action = game.getOngoingAction();
						action.act(game); 
						return;
					}
					currentplayer.notifyLogPBoardView("\n[Harvest]The action is not legal\n"
							+ "Choose another action\n");
					Action action = game.getOngoingAction();
					action.act(game);
				}
				
			}
			else{
				currentplayer.notifyLogPBoardView("\n[Harvest]The action is not legal\n"
						+ "Choose another action\n");
				Action action = game.getOngoingAction();
				action.act(game); 
			}
		}
	}

	/**
	 * Sets the index.
	 *
	 * @param i the new index
	 * @see it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice#setIndex(int)
	 */
	@Override
	public void setIndex(int i) {
		return;
	}

}
