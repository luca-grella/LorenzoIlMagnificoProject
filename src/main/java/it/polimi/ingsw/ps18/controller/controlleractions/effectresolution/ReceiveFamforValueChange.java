package it.polimi.ingsw.ps18.controller.controlleractions.effectresolution;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.effect.leaderEffects.ChoiceLeaderEffect;
import it.polimi.ingsw.ps18.model.effect.leaderEffects.quickeffects.ChangeFamValue;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class ReceiveFamforValueChange implements ActionChoice {
	private int index;

	@Override
	public void act(GameLogic game) {
		ChoiceLeaderEffect effect = game.getOngoingLCEffect();
		PBoard currentplayer = game.getTurnplayer();
		if(index==0){
			//TODO: tornare indietro
		} else if(index<0 || index>currentplayer.getFams().size()){
			((ChangeFamValue) effect).activate(currentplayer, game);
		} else {
			((ChangeFamValue) effect).setChoice(index);
			effect.continueEffect(currentplayer, game);
		}
	}

	@Override
	public void setIndex(int i) {
		this.index = i;
	}

}
