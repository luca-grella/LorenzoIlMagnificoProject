package it.polimi.ingsw.ps18.controller.controlleractions.leadercards;

import java.util.List;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.cards.LeaderCards;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

/**
 * The Class ReceiveLCtoCopy.
 */
public class ReceiveLCtoCopy implements ActionChoice {
	
	/** The index. */
	private int index;

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice#act(it.polimi.ingsw.ps18.model.gamelogic.GameLogic)
	 */
	@Override
	public void act(GameLogic game) {
		PBoard currentplayer = game.getTurnplayer();
		if(index<0 || index>currentplayer.getSecondsupportforLC().size()){
			currentplayer.copyLC(game);
		} else {
			List<LeaderCards> support = currentplayer.getSecondsupportforLC();
			LeaderCards chosenCard = support.get(index);
			LeaderCards currentcard = currentplayer.getCurrentcard();
			currentcard.setQuickEffects(chosenCard.getQuickEffects());
			currentcard.setPermEffects(chosenCard.getPermEffects());
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
