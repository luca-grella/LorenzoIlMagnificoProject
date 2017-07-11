package it.polimi.ingsw.ps18.controller.controlleractions.famtocouncil;

import java.util.List;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.board.boardcells.CouncilCell;
import it.polimi.ingsw.ps18.model.cards.Excommunications;
import it.polimi.ingsw.ps18.model.effect.excommEffects.ExcommEffects;
import it.polimi.ingsw.ps18.model.effect.excommEffects.MalusValue;
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
		PBoard currentplayer = game.getTurnplayer();
		if(index==0){
			currentplayer.notifyLogPBoardView("\nUndoing...\n");
			currentplayer.notifyLogPBoardView("\tTurned back to the Action choice\n");
			Action tHandler = new TurnHandler(game.getTurnplayer());
			game.setOngoingAction(tHandler);
			tHandler.act(game);
		} else if(index<0 || index>GeneralParameters.nfamperplayer){
			currentplayer.notifyLogPBoardView("\nError: not a valid input\n");
			currentplayer.notifyLogPBoardView("\tTurned back to the Floor choice\n");
			Action currentaction = game.getOngoingAction();
			((FamtoCouncil) currentaction).famchoice();
		} else {
			index -= 1;
			Action currentaction = game.getOngoingAction();
			int malusServants = 1;
			for(Excommunications card: currentplayer.getExcommCards()){
				for(ExcommEffects effect: card.getEffects()){
					if("MalusValue".equals(effect.getName())){
						if("Servants".equals(((MalusValue) effect).getPlace())){
							malusServants = ((MalusValue) effect).getMalusValue();
							if(malusServants == 0){
								malusServants = 1;
							}
						}
						
					}
				}
			}
			List<FMember> fams = currentplayer.getFams();
			FMember chosenfam = fams.get(index);
			((FamtoCouncil) currentaction).setIndexFamtoRemove(index);
			CouncilCell councilCell = new CouncilCell();
			
			if(chosenfam != null){
				currentplayer.notifyLogPBoardView("\nYou chose to place:\n"
						+ chosenfam.toString());
				((FamtoCouncil) currentaction).servantsChoice(game);
				if(councilCell.isLegalCC(chosenfam.getValue() + (((FamtoCouncil) currentaction).getNumberOfServants() / malusServants))){
					currentplayer.notifyLogPBoardView("\nYou Family Member was correctly placed in the Council:\n");
					currentaction.setChosenFam(chosenfam);
					((FamtoCouncil) currentaction).act(game);
				}
				else{
					currentplayer.notifyLogPBoardView("\nError: you tried to place an Uncolored Family Member without adding Servants\n");
					currentplayer.notifyLogPBoardView("\tTurned back to the Family Member choice\n");
					((FamtoCouncil) currentaction).famchoice();
				}		
			}
			else{
				currentplayer.notifyLogPBoardView("\nError: the chosen Family Member was already used\n");
				currentplayer.notifyLogPBoardView("\tTurned back to the Family Member choice\n");
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
