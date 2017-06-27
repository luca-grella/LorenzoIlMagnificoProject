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
 * Sets the ongoing action (placing the Family Member to a Council Cell) and
 * goes to the Family Member choice.
 *
 * @author yazan-matar
 */
public class FamtoCouncilTrigger implements ActionChoice {
	
	/**
	 * Controls if there's at least a Family Member in the current player
	 * Personal Board that can be put in a Council Cell:
	 * <ol>
	 * <li>It finds the Family Member with the greater Action Value and
	 * eventually adds the player cards's action bonuses and all of the player's
	 * servants.
	 * <li>Then it checks the legality of the action with that Family Member for
	 * every cell of the Council:
	 * <ul>
	 * <li>If the action is legal, the method moves to the Family Member choice.
	 * <li>Else, it returns to the Action choice.
	 * </ul>
	 * </ol>
	 * All of this controls are diversified depending on the Family Member color
	 * (neutral/colored).
	 *
	 * @param game
	 *            the game
	 */
	@Override
	public void act(GameLogic game) {
		PBoard currentplayer = game.getTurnplayer();
		FMember maxFM = new FMember(0, currentplayer.getPlayercol());
		int maxValue = 0;
		
		for(int famIndex=0; famIndex<currentplayer.getFams().size(); famIndex++){
			FMember curFM = currentplayer.getFams().get(famIndex);
			if(curFM != null){
				maxValue = currentplayer.getFams().get(famIndex).getValue() + currentplayer.getResources().getServants();
				if(maxValue > maxFM.getValue()){
					maxFM.setValue(maxValue);
				}
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

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice#setIndex(int)
	 */
	@Override
	public void setIndex(int i) {
		return;
	}

}
