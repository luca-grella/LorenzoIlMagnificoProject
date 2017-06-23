package it.polimi.ingsw.ps18.controller.controlleractions.famtoharvest;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.board.boardcells.HarvCell;
import it.polimi.ingsw.ps18.model.cards.BlueC;
import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.effect.permeffects.Permanenteffect;
import it.polimi.ingsw.ps18.model.gamelogic.Action;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoCouncil;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoHarvest;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.gamelogic.GeneralParameters;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;


/**
 * 
 * @author yaz
 *
 */
public class FamtoHarvestTrigger implements ActionChoice {

	@Override
	public void act(GameLogic game) {
		PBoard currentplayer = game.getTurnplayer();
		FMember maxFM = new FMember(0, currentplayer.getPlayercol());
		FMember maxNeutralFM = new FMember(0, currentplayer.getPlayercol());
		int modifierValue = 0;
		
		for(Cards card: currentplayer.getCards()){
			if(card.hasPermanent()){
				for(Permanenteffect effect: ((BlueC) card).getPermeffect()){
					if("Harvest".equals(effect.getName())){
						modifierValue += effect.getQuantity();
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
				HarvCell harvCell = new HarvCell(GeneralParameters.baseMalusHarvCells);
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

	@Override
	public void setIndex(int i) {
		return;
	}

}
