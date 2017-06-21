package it.polimi.ingsw.ps18.controller.controlleractions.famtocouncil;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.gamelogic.Action;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoCouncil;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoTower;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.gamelogic.GeneralParameters;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

/**
 * 
 * @author yaz
 *
 */
public class FamtoCouncilTrigger implements ActionChoice {

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
		if(maxFM.getValue() > GeneralParameters.baseValueCouncilCells){
			Action action = new FamtoCouncil(currentplayer.getpBoardView());
			game.setOngoingAction(action);
			((FamtoCouncil) action).famchoice();
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
