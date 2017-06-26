package it.polimi.ingsw.ps18.controller.controlleractions;

import java.util.List;

import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class ReceiveBonusTile implements ActionChoice {
	private int index;

	@Override
	public void act(GameLogic game) {
		PBoard currentplayer = game.getTurnplayer();
		if(index<=0 || index>game.getBonusTiles().size()){
			currentplayer.ChooseBonusTile();
		} else {
			index -= 1;
			Cards bonusTile = game.getBonusTiles().get(index);
			currentplayer.getCards().add(bonusTile);
			game.getBonusTiles().remove(index);
		}
	}

	@Override
	public void setIndex(int i) {
		this.index = i;
	}

}
