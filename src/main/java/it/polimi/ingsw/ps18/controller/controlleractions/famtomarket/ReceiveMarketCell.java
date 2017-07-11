package it.polimi.ingsw.ps18.controller.controlleractions.famtomarket;

import java.util.List;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.board.Board;
import it.polimi.ingsw.ps18.model.board.boardcells.MarketCell;
import it.polimi.ingsw.ps18.model.cards.Excommunications;
import it.polimi.ingsw.ps18.model.cards.LeaderCards;
import it.polimi.ingsw.ps18.model.effect.excommEffects.ExcommEffects;
import it.polimi.ingsw.ps18.model.effect.excommEffects.MalusValue;
import it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects.LCPermEffect;
import it.polimi.ingsw.ps18.model.gamelogic.Action;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoMarket;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.gamelogic.GeneralParameters;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

/**
 * The Class ReceiveMarketCell.
 */
public class ReceiveMarketCell implements ActionChoice{
	
	/**
	 * The index.
	 */
	private int index;

	/**
	 * Act.
	 *
	 * @param game the game
	 * @see it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice#act(it.polimi.ingsw.ps18.model.gamelogic.GameLogic)
	 */
	@Override
	public void act(GameLogic game) {
		PBoard currentplayer = game.getTurnplayer();
		Action currentaction = game.getOngoingAction();
		if(index==0){
			currentplayer.notifyLogPBoardView("\tUndoing...\n");
			currentplayer.notifyLogPBoardView("\tTurned back to the Family Member choice\n");
			((FamtoMarket) currentaction).famchoice();
		} else if(index<0 || index>GeneralParameters.numberofMarketCells){
			currentplayer.notifyLogPBoardView("\nError: not a valid input\n");
			currentplayer.notifyLogPBoardView("\tTurned back to the Cell choice\n");
			((FamtoMarket) currentaction).cellChoice(game);
		} else {
			index -= 1;
			Board gameBoard = game.getBoard();
			int malusServants = 1;
			for(Excommunications card: game.getTurnplayer().getExcommCards()){
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
			boolean skipfullspacecontrol = false;
			for(LeaderCards card: game.getTurnplayer().getLeadercards()){
				if(card.isActive()){
					for(LCPermEffect effect: card.getPermEffects()){
						if("VariousModifier".equals(effect.getName())){
							if("SkipFullSpaceControl".equals(effect.getShortDescription())){
								skipfullspacecontrol = true;
							}
						}
					}
				}
			}
			List<MarketCell> boardMarketCells = gameBoard.getMarketCells();
			MarketCell boardMarketCell = boardMarketCells.get(index);
			FMember pBoardFM = ((FamtoMarket) currentaction).getChosenFam();
			if(boardMarketCell.isEmptyMC() || skipfullspacecontrol){
				if(boardMarketCell.isLegalMC(pBoardFM.getValue() + (((FamtoMarket) currentaction).getNumberOfServants() / malusServants))){
					((FamtoMarket) currentaction).setChosenCell(index);
					currentaction.act(game);
				}
				else{
					currentplayer.notifyLogPBoardView("\nError: you tried to place an Uncolored Family Member without adding Servants\n");
					currentplayer.notifyLogPBoardView("\tTurned back to the Family Member choice\n");
					((FamtoMarket) currentaction).famchoice();
				}
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
