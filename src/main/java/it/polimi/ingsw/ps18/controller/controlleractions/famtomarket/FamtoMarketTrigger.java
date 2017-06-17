package it.polimi.ingsw.ps18.controller.controlleractions.famtomarket;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.gamelogic.Action;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoMarket;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoProduction;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.gamelogic.GeneralParameters;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class FamtoMarketTrigger implements ActionChoice {

	@Override
	public void act(GameLogic game) {
		PBoard currentplayer = game.getTurnplayer();
		FMember maxFM = new FMember(null, currentplayer.getPlayercol());
		
		if(game.getNplayer() >= 2){
			for(int famIndex=0; famIndex<currentplayer.getFams().size(); famIndex++){
				maxFM.setValue(currentplayer.getFams().get(famIndex).getValue() + currentplayer.getResources().getServants());
				
				if(maxFM.getValue() > GeneralParameters.baseValueMarketCells){
					Action action = new FamtoMarket(currentplayer.getpBoardView());
					game.setOngoingAction(action);
					((FamtoMarket) action).famchoice();
				}
			}
			Action action = game.getOngoingAction();
			action.act(game); 
		}
	}

	@Override
	public void setIndex(int i) {
		return;

	}

}
