package it.polimi.ingsw.ps18.controller.controlleractions.famtotower;

import java.util.List;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.board.boardcells.ConcreteTower;
import it.polimi.ingsw.ps18.model.board.boardcells.Tower;
import it.polimi.ingsw.ps18.model.gamelogic.Action;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoTower;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.gamelogic.GeneralParameters;
import it.polimi.ingsw.ps18.model.gamelogic.ShowBoard;
import it.polimi.ingsw.ps18.model.gamelogic.TurnHandler;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;


/**
 * Receives a Family Member chosen by the current player and moves to the Tower choice.
 * 
 * @author yazan-matar
 *
 */
public class ReceiveFamtoTower implements ActionChoice {
	
	/**
	 * The index.
	 */
	int index;
	
	/**
	 * Controls if the chosen Family Member is empty (meaning that it was
	 * already used in the previous turns):
	 * <ul>
	 * <li>If the Family Member is empty, the method returns to the Family
	 * Member choice.
	 * <li>Else, it moves to the Tower choice.
	 * </ul>
	 *
	 * @param game
	 *            the game
	 */
	@Override
	public void act(GameLogic game) {
		PBoard currentplayer = game.getTurnplayer();
		if(index==0){
			currentplayer.notifyLogPBoardView("\nUndoing...\n");
			currentplayer.notifyLogPBoardView("\tTurned back to the Action choice\n");
			Action tHandler = new TurnHandler(game.getTurnplayer());
			game.setOngoingAction(tHandler);
			tHandler.act(game);
		}
		else if(index<0 || index>GeneralParameters.nfamperplayer){
			currentplayer.notifyLogPBoardView("\nError: not a valid input\n");
			currentplayer.notifyLogPBoardView("\tTurned back to the Family Member choice\n");
			Action currentaction = game.getOngoingAction();
			((FamtoTower) currentaction).famchoice();
		} 
		else {
			index -= 1;
			Action currentaction = game.getOngoingAction();
			List<FMember> fams = currentplayer.getFams();
			((FamtoTower) currentaction).setIndexFamtoRemove(index);
			FMember chosenfam = fams.get(index);
			
			if(chosenfam == null){
				currentplayer.notifyLogPBoardView("\nError: the chosen Family Member was already used\n");
				currentplayer.notifyLogPBoardView("\tTurned back to the Family Member choice\n");
				((FamtoTower) currentaction).famchoice();
			}
			else{
				currentplayer.notifyLogPBoardView("\nYou chose to place:\n"
							+ chosenfam.toString());
				currentaction.setChosenFam(chosenfam);
				((FamtoTower) currentaction).towerChoice();
			}
		}
	}

	/**
	 * Sets the index.
	 *
	 * @param index
	 *            the index to set
	 */
	@Override
	public void setIndex(int index) {
		this.index = index;
	}

	
	

}
