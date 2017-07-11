package it.polimi.ingsw.ps18.controller.controlleractions.leadercards.discard;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.cards.LeaderCards;
import it.polimi.ingsw.ps18.model.effect.generalEffects.Privilege;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

/**
 * The Class ReceiveDiscardChoice.
 */
public class ReceiveDiscardChoice implements ActionChoice {
	
	/** The index. */
	private int index;

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice#act(it.polimi.ingsw.ps18.model.gamelogic.GameLogic)
	 */
	@Override
	public void act(GameLogic game) {
		PBoard currentplayer = game.getTurnplayer();
		if(index==0){
			return;
		} else if(index<0 || index>currentplayer.getSupportforLC().size()){
			currentplayer.discardLC();
		} else {
			index -= 1;
			LeaderCards card = currentplayer.getSupportforLC().get(index);
			if(! card.isActive()){
				currentplayer.getLeadercards().remove(card);
				Privilege privilege = new Privilege();
				privilege.setQuantity(1);
				privilege.activate(currentplayer, game);
			} else {
				currentplayer.discardLC();
			}
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
