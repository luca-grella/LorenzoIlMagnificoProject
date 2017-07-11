package it.polimi.ingsw.ps18.controller.controlleractions.famtomarket;

import java.util.List;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.gamelogic.Action;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoMarket;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.gamelogic.GeneralParameters;
import it.polimi.ingsw.ps18.model.gamelogic.TurnHandler;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

/**
 * The Class ReceiveFamtoMarket.
 */
public class ReceiveFamtoMarket implements ActionChoice {
	
	/**
	 * The index.
	 */
	int index;

	/**
	 * Act.
	 *
	 * @param game the game
	 * @see it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice#act(it.polimi.ingsw.ps18.model.gamelogic.GameLogic)
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
		} else if(index<0 || index>GeneralParameters.nfamperplayer){
			currentplayer.notifyLogPBoardView("\nError: not a valid input\n");
			currentplayer.notifyLogPBoardView("\tTurned back to the Family Member choice\n");
			Action currentaction = game.getOngoingAction();
			((FamtoMarket) currentaction).famchoice();
		} else {
			index -= 1;
			Action currentaction = game.getOngoingAction();
			List<FMember> fams = currentplayer.getFams();
			FMember chosenfam = fams.get(index);
			((FamtoMarket) currentaction).setIndexFamtoRemove(index);
			if(chosenfam != null){
				currentplayer.notifyLogPBoardView("\nYou chose to place:\n"
						+ chosenfam.toString());
				currentaction.setChosenFam(chosenfam);
				((FamtoMarket) currentaction).cellChoice(game);
			}
			else{
				currentplayer.notifyLogPBoardView("\nError: the chosen Family Member was already used\n");
				currentplayer.notifyLogPBoardView("\tTurned back to the Family Member choice\n");
				((FamtoMarket) currentaction).famchoice();
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
