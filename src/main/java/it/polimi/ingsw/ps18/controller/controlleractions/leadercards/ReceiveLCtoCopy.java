package it.polimi.ingsw.ps18.controller.controlleractions.leadercards;

import java.util.List;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.cards.LeaderCards;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class ReceiveLCtoCopy implements ActionChoice {
	private int index;

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

	@Override
	public void setIndex(int i) {
		this.index = i;
	}

}
