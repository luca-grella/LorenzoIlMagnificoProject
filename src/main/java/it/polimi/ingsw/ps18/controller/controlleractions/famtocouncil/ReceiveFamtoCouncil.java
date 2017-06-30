package it.polimi.ingsw.ps18.controller.controlleractions.famtocouncil;

import java.util.List;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.board.boardcells.CouncilCell;
import it.polimi.ingsw.ps18.model.gamelogic.Action;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoCouncil;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.gamelogic.GeneralParameters;
import it.polimi.ingsw.ps18.model.gamelogic.TurnHandler;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

/**
 * The Class ReceiveFamtoCouncil.
 *
 * @author yaz
 */
public class ReceiveFamtoCouncil implements ActionChoice {
    
    /**
	 * The index.
	 */
    int index;

	/**
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
			((FamtoCouncil) currentaction).famchoice();
		} else {
			index -= 1;
			Action currentaction = game.getOngoingAction();
			PBoard currentplayer = game.getTurnplayer();
			List<FMember> fams = currentplayer.getFams();
			FMember chosenfam = fams.get(index);
			((FamtoCouncil) currentaction).setIndexFamtoRemove(index);
			CouncilCell councilCell = new CouncilCell();
			
			if(chosenfam != null){
				((FamtoCouncil) currentaction).servantsChoice(game);
				if(councilCell.isLegalCC(chosenfam.getValue() + ((FamtoCouncil) currentaction).getNumberOfServants()) ){
					currentaction.setChosenFam(chosenfam);
					((FamtoCouncil) currentaction).act(game);
				}
				else{
					((FamtoCouncil) currentaction).famchoice();
				}		
			}
			else{
				((FamtoCouncil) currentaction).famchoice();
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
