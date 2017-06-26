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

// TODO: Auto-generated Javadoc
/**
 * The Class ReceiveFamtoMarket.
 */
public class ReceiveFamtoMarket implements ActionChoice {
	
	/**
	 * The index.
	 */
	int index;

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice#act(it.polimi.ingsw.ps18.model.gamelogic.GameLogic)
	 */
	@Override
	public void act(GameLogic game) {
		if(index==0){
			Action tHandler = new TurnHandler(game.getTurnplayer());
			game.setOngoingAction(tHandler);
			tHandler.act(game);
		} else if(index<0 || index>GeneralParameters.nfamperplayer){
			Action currentaction = game.getOngoingAction();
			((FamtoMarket) currentaction).famchoice();
		} else {
			index -= 1;
			Action currentaction = game.getOngoingAction();
			PBoard currentplayer = game.getTurnplayer();
			List<FMember> fams = currentplayer.getFams();
			FMember chosenfam = fams.get(index);
			((FamtoMarket) currentaction).setIndexFamtoRemove(index);
			if(chosenfam != null){
				currentaction.setChosenFam(chosenfam);
				((FamtoMarket) currentaction).cellChoice();
			}
			else{
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
