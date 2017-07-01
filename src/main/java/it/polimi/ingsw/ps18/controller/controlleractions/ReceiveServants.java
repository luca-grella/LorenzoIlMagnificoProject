package it.polimi.ingsw.ps18.controller.controlleractions;

import it.polimi.ingsw.ps18.model.gamelogic.Action;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoTower;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
/**
 * Sets the number of servants that the player wants to add to the current FMember action value.
 * @author yazan-matar
 *
 */
public class ReceiveServants implements ActionChoice {

	int index;
	
	@Override
	public void act(GameLogic game) {
		Action currentaction = game.getOngoingAction();
		currentaction.setNumberOfServants(index);	
	}

	@Override
	public void setIndex(int i) {
		this.index = i;
	}

	/**
	 * @return 
	 * @return
	 */
	public int getIndex() {
		
		return index;
	}
	
}
