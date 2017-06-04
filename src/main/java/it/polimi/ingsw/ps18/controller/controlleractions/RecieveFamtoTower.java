package it.polimi.ingsw.ps18.controller.controlleractions;

import java.util.List;

import it.polimi.ingsw.ps18.model.gameLogic.Action;
import it.polimi.ingsw.ps18.model.gameLogic.FamtoTower;
import it.polimi.ingsw.ps18.model.gameLogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalBoard.FMember;
import it.polimi.ingsw.ps18.model.personalBoard.PBoard;

public class RecieveFamtoTower implements ActionChoice {
	int index;

	@Override
	public void act(GameLogic game) {
		PBoard currentplayer = game.getTurnplayer();
		List<FMember> fams = currentplayer.getFams();
		FMember chosenfam = fams.get(index);
		Action currentaction = game.getOngoingAction();
		((FamtoTower) currentaction).setChosenFam(chosenfam);
		((FamtoTower) currentaction).towerChoice();

	}

	/**
	 * @param index the index to set
	 */
	@Override
	public void setIndex(int index) {
		this.index = index;
	}

	
	
	

}
