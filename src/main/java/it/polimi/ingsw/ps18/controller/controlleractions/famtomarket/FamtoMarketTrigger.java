package it.polimi.ingsw.ps18.controller.controlleractions.famtomarket;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.cards.LeaderCards;
import it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects.LCPermEffect;
import it.polimi.ingsw.ps18.model.gamelogic.Action;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoHarvest;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoMarket;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoProduction;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.gamelogic.GeneralParameters;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;


/**
 * Sets the ongoing action (placing the Family Member to a Market Cell) and goes
 * to the Family Member choice.
 *
 * @author yazan-matar
 */
public class FamtoMarketTrigger implements ActionChoice {
	
	/**
	 * Controls if there's at least a Family Member in the current player
	 * Personal Board that can be put in a Market Cell:
	 * <ol>
	 * <li>It checks the Market status:
	 * <ul>
	 * <li>If the Market is full, it returns to the action choice
	 * <li>Else, it finds the Family Member with the greater Action Value and
	 * eventually adds the player cards's action bonuses and all of the player's
	 * servants.
	 * <li>Then it checks the legality of the action with that Family Member for
	 * every cell of the Market:
	 * <ul>
	 * <li>If the action is legal, the method moves to the Family Member choice.
	 * <li>Else, it returns to the Action choice.
	 * </ul>
	 * </ul>
	 * 
	 * </ol>
	 * All of this controls are diversified depending on the Family Member color
	 * (neutral/colored).
	 *
	 * @param game
	 *            the game
	 */
	@Override
	public void act(GameLogic game) {
		PBoard currentplayer = game.getTurnplayer();
		FMember maxFM = new FMember(0, currentplayer.getPlayercol(), currentplayer);
		FMember maxNeutralFM = new FMember(0, currentplayer.getPlayercol(), currentplayer);
		int maxValue = 0;
		int maxNeutralValue = 0;
		boolean skipfullspacecontrol = false;
		for(LeaderCards card: currentplayer.getLeadercards()){
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

		if( (! (game.getBoard().isFullMarket())) || skipfullspacecontrol ) {
			for(int famIndex=0; famIndex<currentplayer.getFams().size(); famIndex++){
				FMember curFM = currentplayer.getFams().get(famIndex);
				if(curFM!=null){
					if(curFM.getColor() == GeneralParameters.neutralFMColor){
						maxNeutralValue = curFM.getValue() + currentplayer.getResources().getServants();
						if(maxNeutralValue > maxNeutralFM.getValue() ){
							maxNeutralFM.setValue(maxNeutralValue);
							maxNeutralFM.setColor(curFM.getColor());
						}
					}
					else{
						maxValue = curFM.getValue() + currentplayer.getResources().getServants();
						if(maxValue > maxFM.getValue() ){
							maxFM.setValue(maxValue);
							maxFM.setColor(curFM.getColor());
						}
					}
				}
			}
			if(maxFM.getValue() > GeneralParameters.baseValueMarketCells){
				currentplayer.notifyLogPBoardView("\n[Market]The action is legal\n"
						+ "\tYou can proceed\n");
				Action action = new FamtoMarket(currentplayer.getpBoardView());
				game.setOngoingAction(action);
				((FamtoMarket) action).famchoice();
				return;
			}
			if(maxNeutralFM.getValue() > GeneralParameters.baseValueMarketCells){
				currentplayer.notifyLogPBoardView("\n[Market]The action is legal\n"
						+ "\tYou can proceed\n");
				Action action = new FamtoMarket(currentplayer.getpBoardView());
				game.setOngoingAction(action);
				((FamtoMarket) action).famchoice();
				return;
			}
			currentplayer.notifyLogPBoardView("\n[Market]The action is not legal\n"
					+ "Choose another action\n");
			Action action = game.getOngoingAction();
			action.act(game); 
		}
		else{
			currentplayer.notifyLogPBoardView("\n[Market]Market is full!\n"
					+ "Choose another action\n");
			Action action = game.getOngoingAction();
			action.act(game);
		}
	}

	/**
	 * Sets the index.
	 *
	 * @param i the new index
	 * @see it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice#setIndex(int)
	 */
	@Override
	public void setIndex(int i) {
		return;

	}

}
