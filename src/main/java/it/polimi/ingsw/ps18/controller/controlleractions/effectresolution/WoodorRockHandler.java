package it.polimi.ingsw.ps18.controller.controlleractions.effectresolution;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.effect.generalEffects.GeneralEffect;
import it.polimi.ingsw.ps18.model.effect.prodEffect.ConvertResorResinResources;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;

public class WoodorRockHandler implements ActionChoice {
	private int index;

	@Override
	public void act(GameLogic game) {
		GeneralEffect currenteffect = game.getOngoingEffect();
		((ConvertResorResinResources) currenteffect).pay(game.getTurnplayer(), index);
	}

	@Override
	public void setIndex(int i) {
		this.index = i;
	}

}
