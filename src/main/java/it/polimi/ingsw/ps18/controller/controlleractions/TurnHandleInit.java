package it.polimi.ingsw.ps18.controller.controlleractions;

import it.polimi.ingsw.ps18.model.gamelogic.Action;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.gamelogic.TurnHandler;

/**
 * The Class TurnHandleInit.
 */
public class TurnHandleInit implements ActionChoice{
	
	/**
	 * The t handler.
	 */
	TurnHandler tHandler;
	
	/**
	 * @see it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice#act(it.polimi.ingsw.ps18.model.gamelogic.GameLogic)
	 */
	@Override
	public void act(GameLogic game) {
		Action tHandler = new TurnHandler(game.getTurnplayer());
		game.setOngoingAction(tHandler);
		tHandler.act(game);
		
	}
	
	/**
	 * @see it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice#setIndex(int)
	 */
	@Override
	public void setIndex(int i) {
		return;
	}


}
