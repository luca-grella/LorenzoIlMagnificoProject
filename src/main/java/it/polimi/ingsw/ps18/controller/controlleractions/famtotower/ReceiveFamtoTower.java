package it.polimi.ingsw.ps18.controller.controlleractions.famtotower;

import java.util.List;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.board.boardcells.ConcreteTower;
import it.polimi.ingsw.ps18.model.board.boardcells.Tower;
import it.polimi.ingsw.ps18.model.gamelogic.Action;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoTower;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;


/**
 * Receives a Family Member chosen by the current player and moves to the Tower choice.
 * 
 * @author yazan-matar
 *
 */
public class ReceiveFamtoTower implements ActionChoice {
	int index;
	/**
	 * Controls if the chosen Family Member is empty (meaning that it was already used in the previous turns):
	 * <ul> 
	 * 	<li> If the Family Member is empty, the method returns to the Family Member choice.
	   	<li> Else, it moves to the Tower choice.
	 * </ul>
	 */
	@Override
	public void act(GameLogic game) {
		Action currentaction = game.getOngoingAction();
		PBoard currentplayer = game.getTurnplayer();
		List<FMember> fams = currentplayer.getFams();
		((FamtoTower) currentaction).setIndexFamtoRemove(index);
		FMember chosenfam = fams.get(index);
		
		if(chosenfam == null){
			((FamtoTower) currentaction).famchoice();
		}
		else{
			currentaction.setChosenFam(chosenfam);
			((FamtoTower) currentaction).towerChoice();
		}
	}

	/**
	 * @param index the index to set
	 */
	@Override
	public void setIndex(int index) {
		this.index = index;
	}

	
	

}
