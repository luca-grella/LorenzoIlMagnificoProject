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

	/** The index. */
	int index;
	
	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice#act(it.polimi.ingsw.ps18.model.gamelogic.GameLogic)
	 */
	@Override
	public void act(GameLogic game) {
		Action currentaction = game.getOngoingAction();
		currentaction.setNumberOfServants(index);	
	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice#setIndex(int)
	 */
	@Override
	public void setIndex(int i) {
		this.index = i;
	}

	/**
	 * Gets the index.
	 *
	 * @return the index
	 */
	public int getIndex() {
		
		return index;
	}
	
}
