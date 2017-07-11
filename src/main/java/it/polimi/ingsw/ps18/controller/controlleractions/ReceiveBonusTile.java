package it.polimi.ingsw.ps18.controller.controlleractions;

import java.util.List;

import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

/**
 * The Class ReceiveBonusTile.
 */
public class ReceiveBonusTile implements ActionChoice {
	
	/** The index. */
	private int index;

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice#act(it.polimi.ingsw.ps18.model.gamelogic.GameLogic)
	 */
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

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice#setIndex(int)
	 */
	@Override
	public void setIndex(int i) {
		this.index = i;
	}

	/**
	 * Per test.
	 *
	 * @return the index
	 */
	public int getIndex() {
		
		return index;
	}

}
