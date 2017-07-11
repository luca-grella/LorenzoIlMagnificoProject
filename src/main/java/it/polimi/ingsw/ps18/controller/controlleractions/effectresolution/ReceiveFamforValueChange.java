package it.polimi.ingsw.ps18.controller.controlleractions.effectresolution;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.effect.leaderEffects.ChoiceLeaderEffect;
import it.polimi.ingsw.ps18.model.effect.leaderEffects.quickeffects.ChangeFamValue;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

/**
 * The Class ReceiveFamforValueChange.
 */
public class ReceiveFamforValueChange implements ActionChoice {
	
	/** The index. */
	private int index;

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice#act(it.polimi.ingsw.ps18.model.gamelogic.GameLogic)
	 */
	@Override
	public void act(GameLogic game) {
		ChoiceLeaderEffect effect = game.getOngoingLCEffect();
		PBoard currentplayer = game.getTurnplayer();
		if(index==0){
			((ChangeFamValue) effect).activate(currentplayer, game);
		} else if(index<0 || index>currentplayer.getFams().size()){
			currentplayer.notifyLogPBoardView("\nError: not a valid input\n"
					+ "\tPlease choose again");
			((ChangeFamValue) effect).activate(currentplayer, game);
		} else {
			String string[] = {"st", "nd", "rd", "rth"};
			currentplayer.notifyLogPBoardView("\nYou successfully avtivated the Leader Effect on the "
					+ index + string[index] + " Family Member\n");
			index -= 1;
			((ChangeFamValue) effect).setChoice(index);
			effect.continueEffect(currentplayer, game);
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
