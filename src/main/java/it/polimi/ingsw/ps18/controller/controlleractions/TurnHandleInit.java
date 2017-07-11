package it.polimi.ingsw.ps18.controller.controlleractions;

import java.util.List;

import it.polimi.ingsw.ps18.model.gamelogic.Action;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.gamelogic.GeneralParameters;
import it.polimi.ingsw.ps18.model.gamelogic.TurnHandler;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

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
		
		PBoard currentplayer = game.getTurnplayer();
		List<FMember> playerFams = currentplayer.getFams();
		for(FMember fam : playerFams) {
			if(fam.getColor() != GeneralParameters.neutralFMColor) {
				Action tHandler = new TurnHandler(game.getTurnplayer());
				game.setOngoingAction(tHandler);
				tHandler.act(game);
				return;
			}
		}
		if(currentplayer.getResources().getServants() > 0) {
			Action tHandler = new TurnHandler(game.getTurnplayer());
			game.setOngoingAction(tHandler);
			tHandler.act(game);
		}
		else {
			currentplayer.notifyLogPBoardView("You only have a Uncolored Family Member and no Servants\n"
											+ "\tTurn skipped\n");
			return;
		}
		
		
	}
	
	/**
	 * @see it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice#setIndex(int)
	 */
	@Override
	public void setIndex(int i) {
		return;
	}


}
