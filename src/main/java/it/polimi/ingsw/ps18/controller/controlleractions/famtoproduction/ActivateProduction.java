package it.polimi.ingsw.ps18.controller.controlleractions.famtoproduction;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.cards.BlueC;
import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.effect.permeffects.Permanenteffect;
import it.polimi.ingsw.ps18.model.gamelogic.Action;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoProduction;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class ActivateProduction implements ActionChoice {
	private int index = -1;

	@Override
	public void act(GameLogic game) {
		if(index != -1){
			PBoard currentplayer = game.getTurnplayer();
			Action currentaction = new FamtoProduction(currentplayer.getpBoardView());
			game.setOngoingAction(currentaction);
			int modifierValue = 0;
			for(Cards card: currentplayer.getCards()){
				if(card.hasPermanent()){
					for(Permanenteffect effect: ((BlueC) card).getPermeffect()){
						if("IncraseFMvalueOnProduction".equals(effect.getName())){
							modifierValue += effect.getQuantity();
						}
					}
				}
			}
			((FamtoProduction) currentaction).setActionValue(index + modifierValue);
			((FamtoProduction) currentaction).activateProduction(currentplayer, game);
		} else {
			Action currentaction = game.getOngoingAction();
			PBoard currentplayer = game.getTurnplayer();
			((FamtoProduction) currentaction).activateProduction(currentplayer, game);
		}

	}

	@Override
	public void setIndex(int i) {
		this.index = i;
	}

}
