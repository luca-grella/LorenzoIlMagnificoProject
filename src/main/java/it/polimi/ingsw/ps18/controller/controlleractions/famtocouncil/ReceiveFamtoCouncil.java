package it.polimi.ingsw.ps18.controller.controlleractions.famtocouncil;

import java.util.List;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.board.boardcells.CouncilCell;
import it.polimi.ingsw.ps18.model.gamelogic.Action;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoCouncil;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;


/**
 * 
 * @author yaz
 *
 */
public class ReceiveFamtoCouncil implements ActionChoice {
    int index;

	@Override
	public void act(GameLogic game) {
		PBoard currentplayer = game.getTurnplayer();
		List<FMember> fams = currentplayer.getFams();
		FMember chosenfam = fams.get(index);
		Action currentaction = game.getOngoingAction();
		CouncilCell councilCell = new CouncilCell();
		if(chosenfam != null){
			if(councilCell.isLegalCC(chosenfam) ){
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
		
	/**
	 * @param index the index to set
	 */
	@Override
	public void setIndex(int index) {
		this.index = index;
	}

}
