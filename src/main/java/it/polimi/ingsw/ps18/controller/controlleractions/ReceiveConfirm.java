package it.polimi.ingsw.ps18.controller.controlleractions;

import it.polimi.ingsw.ps18.model.gamelogic.ConfirmHandler;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;

/**
 * The Class ReceiveConfirm.
 */
public class ReceiveConfirm implements ActionChoice {
	
	/** The index. */
	private int index;

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice#act(it.polimi.ingsw.ps18.model.gamelogic.GameLogic)
	 */
	@Override
	public void act(GameLogic game) {
		if(index==1){
			ConfirmHandler action = game.getRequester();
			action.setConfirm(true);
		} 
		return;
	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice#setIndex(int)
	 */
	@Override
	public void setIndex(int i) {
		this.index = i;
	}

}
