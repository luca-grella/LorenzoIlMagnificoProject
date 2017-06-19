package it.polimi.ingsw.ps18.controller.controlleractions.famtotower;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.gamelogic.Action;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoCouncil;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoHarvest;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoTower;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.gamelogic.GeneralParameters;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class FamtoTowerTrigger implements ActionChoice {

	@Override
	public void act(GameLogic game) {
		PBoard currentplayer = game.getTurnplayer();
		FMember maxFM = new FMember(0, currentplayer.getPlayercol());
		int maxValue = 0;
		
		for(int famIndex=0; famIndex<currentplayer.getFams().size(); famIndex++){
			maxValue = currentplayer.getFams().get(famIndex).getValue() + currentplayer.getResources().getServants();
			if(maxValue > maxFM.getValue()){
				maxFM.setValue(maxValue);
			}
		}
		/**
		 * TODO: bisogna analizzare ogni cella della torre con il reispettivo valore perchè
		 * il punto è garantire che almeno un familiare del giocatore possa avere accesso ad una cella
		 * della torre. Poi oltre che al valore massimo dei familiari bisogna tener conto anche degli
		 * effetti permanenti delle carte blu.
		 */
		if(maxFM.getValue() > GeneralParameters.minValueTowerCells){
			Action action = new FamtoTower(currentplayer.getpBoardView());
			game.setOngoingAction(action);
			((FamtoTower) action).famchoice();
		}
		else{
			Action action = game.getOngoingAction();
			action.act(game);
		}
	}

	@Override
	public void setIndex(int i) {
		return;
	}

}
