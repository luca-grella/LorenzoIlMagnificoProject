package it.polimi.ingsw.ps18.controller.controlleractions.famtoharvest;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.cards.BlueC;
import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.effect.permeffects.Permanenteffect;
import it.polimi.ingsw.ps18.model.gamelogic.*;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class ActivateHarvest implements ActionChoice {
	private int index = -1;

	@Override
	public void act(GameLogic game) {
		if(index != -1){
			PBoard currentplayer = game.getTurnplayer();
			Action currentaction = new FamtoHarvest(currentplayer.getpBoardView());
			game.setOngoingAction(currentaction);
			int modifierValue = 0;
			for(Cards card: currentplayer.getCards()){
				if(card.hasPermanent()){
					for(Permanenteffect effect: ((BlueC) card).getPermeffect()){
						if("IncraseFMvalueOnHarvest".equals(effect.getName())){
							modifierValue += effect.getQuantity();
						}
					}
				}
			}
			((FamtoHarvest) currentaction).setActionValue(index + modifierValue);
			((FamtoHarvest) currentaction).activateHarvest(currentplayer, game);
		} else {
			Action currentaction = game.getOngoingAction();
			PBoard currentplayer = game.getTurnplayer();
			((FamtoHarvest) currentaction).activateHarvest(currentplayer, game);
		}

	}

	@Override
	public void setIndex(int i) {
		this.index = i;
	}

}
