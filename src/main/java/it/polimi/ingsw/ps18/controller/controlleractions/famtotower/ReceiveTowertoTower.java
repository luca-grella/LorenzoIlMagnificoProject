package it.polimi.ingsw.ps18.controller.controlleractions.famtotower;

import java.util.ArrayList;
import java.util.List;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.board.Board;
import it.polimi.ingsw.ps18.model.board.boardcells.ConcreteTower;
import it.polimi.ingsw.ps18.model.board.boardcells.Tower;
import it.polimi.ingsw.ps18.model.cards.LeaderCards;
import it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects.LCPermEffect;
import it.polimi.ingsw.ps18.model.gamelogic.Action;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoTower;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.gamelogic.GeneralParameters;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

/**
 * Receives the tower's index chosen by the current player.
 * 
 * @author yazan-matar
 *
 */
public class ReceiveTowertoTower implements ActionChoice {
	
	/**
	 * The index.
	 */
	private int index;
	
	/**
	 * if this method's controls work, the player goes to the floor choice else,
	 * he returns to the tower choice.
	 *
	 * @param game
	 *            <br>
	 *            instance of the game setup and flow
	 */
	@Override
	public void act(GameLogic game) {
		Action currentaction = game.getOngoingAction();
		PBoard currentplayer = game.getTurnplayer();
		if(index==0){
			currentplayer.notifyLogPBoardView("\nUndoing...\n");
			if(((FamtoTower) currentaction).isCanGoBacktoFamChoice()){
				currentplayer.notifyLogPBoardView("\tTurned back to the Family Member choice\n");
				((FamtoTower) currentaction).famchoice();
			} else {
				currentplayer.notifyLogPBoardView("\tTurned back to the Tower choice\n");
				((FamtoTower) currentaction).towerChoice();
			}
		} else if(index<0 || index>GeneralParameters.numberofBaseTowers){
			currentplayer.notifyLogPBoardView("\nError: not a valid input\n");
			currentplayer.notifyLogPBoardView("\tTurned back to the Tower choice\n");
			((FamtoTower) currentaction).towerChoice();
		} else {
			index -= 1;
			Stats totalCostPreview = new Stats(0,0,0,0,0,0,0);
			Board gameBoard = game.getBoard();
			List<Tower> boardTowers = gameBoard.getTowers();
			FMember pBoardFM = ((FamtoTower) currentaction).getChosenFam();
			ConcreteTower boardTower = (ConcreteTower) boardTowers.get(index);
			boolean havetopayFee = true;
			for(LeaderCards card: currentplayer.getLeadercards()){
				if(card.isActive()){
					for(LCPermEffect effect: card.getPermEffects()){
						if("VariousModifier".equals(effect.getName())){
							if("SkipCoinPaymentinTower".equals(effect.getShortDescription())){
								havetopayFee = false;
							}
						}
					}
				}
			}
			
			if(boardTower.isFullTower()){
				currentplayer.notifyLogPBoardView("\nYou can't access Tower number " 
						+ index + ":\n\tTower is full\n");
				((FamtoTower) currentaction).towerChoice();
			}
			else{
				if(boardTower.isLegalTower(pBoardFM)){ 
					if(boardTower.isEmptyTower()){
						if(currentplayer.hasSpace(index)){
							((FamtoTower) currentaction).setChosenTower(index);
							((FamtoTower) currentaction).floorChoice(game);
						}
						else{
							String string[] = {"Green", "Blue", "Yellow", "Purple"};
							currentplayer.notifyLogPBoardView("\nYou can't access Tower number " 
									+ index + ":\n\tYou reached the " + string[index] + "card limit in your Personal Board\n");
							((FamtoTower) currentaction).towerChoice();
						}		
					} 
					else {
						if(havetopayFee){
							if((currentplayer.getResources()).getCoin() >= GeneralParameters.towerFee){
								if(currentplayer.hasSpace(index)){
									totalCostPreview.addCoins(GeneralParameters.towerFee);
									currentplayer.notifyLogPBoardView("\nYou can access Tower number " + index + "\n");
									((FamtoTower) currentaction).setTotalCostPreview(totalCostPreview);
									((FamtoTower) currentaction).setChosenTower(index);
									((FamtoTower) currentaction).floorChoice(game);
								}					
								else{
									String string[] = {"Green", "Blue", "Yellow", "Purple"};
									currentplayer.notifyLogPBoardView("\nYou can't access Tower number " 
											+ index + ":\n\tYou reached the " + string[index] + "card limit in your Personal Board\n");
									((FamtoTower) currentaction).towerChoice();
			
								}
							} 
							else {
								currentplayer.notifyLogPBoardView("\nYou can't access Tower number " 
										+ index + ":\n\tYou don't have enough coins\n");
								((FamtoTower) currentaction).towerChoice();	
							}
						} else {
							if(currentplayer.hasSpace(index)){
								currentplayer.notifyLogPBoardView("\nYou chose to access Tower number " + index + "\n");
								((FamtoTower) currentaction).setTotalCostPreview(totalCostPreview);
								((FamtoTower) currentaction).setChosenTower(index);
								((FamtoTower) currentaction).floorChoice(game);
							}					
							else{
								currentplayer.notifyLogPBoardView("\nYou can't access Tower number " 
										+ index + ":\n\tYou reached the card limit in your Personal Board\n");
								((FamtoTower) currentaction).towerChoice();
		
							}
						}
					}
				} 
				else {
					currentplayer.notifyLogPBoardView("\nYou can't access Tower number " 
							+ index + ":\n\tThe action is not legal\n");
					((FamtoTower) currentaction).towerChoice();
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
