package it.polimi.ingsw.ps18.controller.controlleractions.famtotower;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.gamelogic.Action;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoTower;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class ReceiveChosenCost implements ActionChoice {
	private int index;

	@Override
	public void act(GameLogic game) {
		Action currentaction = game.getOngoingAction();
		PBoard currentplayer = game.getTurnplayer();
		if(index==0){
			((FamtoTower) currentaction).floorChoice(game);
		} else if(index<0 || index>2){
			((FamtoTower) currentaction).setCostchoice(index);
		}
	}

	@Override
	public void setIndex(int i) {
		this.index = i;
	}

}
