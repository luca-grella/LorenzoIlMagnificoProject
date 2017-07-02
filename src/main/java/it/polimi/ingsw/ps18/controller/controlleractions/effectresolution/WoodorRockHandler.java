package it.polimi.ingsw.ps18.controller.controlleractions.effectresolution;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.effect.generalEffects.GeneralEffect;
import it.polimi.ingsw.ps18.model.effect.generalEffects.WoodorRockEffects;
import it.polimi.ingsw.ps18.model.effect.prodEffect.ConvertResorResinResources;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;

/**
 * The Class WoodorRockHandler.
 */
public class WoodorRockHandler implements ActionChoice {
	
	/**
	 * The index.
	 */
	private int index;

	/**
	 * @see it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice#act(it.polimi.ingsw.ps18.model.gamelogic.GameLogic)
	 */
	@Override
	public void act(GameLogic game) {
		WoodorRockEffects currenteffect = game.getOngoingWREffect();
		currenteffect.continueEffect(index, game.getTurnplayer(), game);
	}

	/**
	 * @see it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice#setIndex(int)
	 */
	@Override
	public void setIndex(int i) {
		this.index = i;
	}

	/**
	 * Per test
	 */
	public int getIndex() {

		return index;
	}

}
