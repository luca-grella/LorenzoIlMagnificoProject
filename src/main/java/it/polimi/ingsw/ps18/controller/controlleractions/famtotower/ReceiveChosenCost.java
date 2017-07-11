package it.polimi.ingsw.ps18.controller.controlleractions.famtotower;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.gamelogic.Action;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoTower;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

/**
 * The Class ReceiveChosenCost.
 */
public class ReceiveChosenCost implements ActionChoice {
	
	/** The index. */
	private int index;

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice#act(it.polimi.ingsw.ps18.model.gamelogic.GameLogic)
	 */
	@Override
	public void act(GameLogic game) {
		Action currentaction = game.getOngoingAction();
		PBoard currentplayer = game.getTurnplayer();
		if(index==0){
			currentplayer.notifyLogPBoardView("\nUndoing...\n");
			currentplayer.notifyLogPBoardView("Turned back to the Floor choice\n");
			((FamtoTower) currentaction).floorChoice(game);
		} else if(index==1 || index==2){
			if(index == 1) {
				currentplayer.notifyLogPBoardView("\nYou chose to pay with Resources\n");
			}
			else {
				currentplayer.notifyLogPBoardView("\nYou chose to pay with Military Points\n");
			}
			((FamtoTower) currentaction).setCostchoice(index);
		}
	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice#setIndex(int)
	 */
	@Override
	public void setIndex(int i) {
		this.index = i;
	}

}
