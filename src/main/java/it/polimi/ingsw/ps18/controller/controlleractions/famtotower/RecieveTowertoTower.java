package it.polimi.ingsw.ps18.controller.controlleractions.famtotower;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.gameLogic.Action;
import it.polimi.ingsw.ps18.model.gameLogic.FamtoTower;
import it.polimi.ingsw.ps18.model.gameLogic.GameLogic;

public class RecieveTowertoTower implements ActionChoice {
	private int index;

	@Override
	public void act(GameLogic game) {
		Action currentaction = game.getOngoingAction();
		((FamtoTower) currentaction).setChosenTower(index);
		((FamtoTower) currentaction).floorChoice();
		
	}

	/**
	 * @param index the index to set
	 */
	@Override
	public void setIndex(int index) {
		this.index = index;
	}

}
