package it.polimi.ingsw.ps18.controller.controlleractions.famtomarket;

import java.util.List;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.gameLogic.Action;
import it.polimi.ingsw.ps18.model.gameLogic.FamtoMarket;
import it.polimi.ingsw.ps18.model.gameLogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class RecieveFamtoMarket implements ActionChoice {
	int index;

	@Override
	public void act(GameLogic game) {
		PBoard currentplayer = game.getTurnplayer();
		List<FMember> fams = currentplayer.getFams();
		FMember chosenfam = fams.set(index, null);
		Action currentaction = game.getOngoingAction();
		currentaction.setChosenFam(chosenfam);
		((FamtoMarket) currentaction).cellChoice();

	}

	/**
	 * @param index the index to set
	 */
	@Override
	public void setIndex(int index) {
		this.index = index;
	}

}
