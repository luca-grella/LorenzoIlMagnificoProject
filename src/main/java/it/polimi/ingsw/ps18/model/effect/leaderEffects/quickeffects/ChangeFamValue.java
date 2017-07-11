package it.polimi.ingsw.ps18.model.effect.leaderEffects.quickeffects;

import java.util.Observable;

import it.polimi.ingsw.ps18.model.effect.leaderEffects.ChoiceLeaderEffect;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.messagesandlogs.StatusMessage;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

/**
 * The Class ChangeFamValue.
 */
public class ChangeFamValue extends Observable implements LCQuickEffect, ChoiceLeaderEffect {
	
	/** The new actionvalue. */
	private int newActionvalue;
	
	/** The choice. */
	private int choice;

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.effect.leaderEffects.quickeffects.LCQuickEffect#activate(it.polimi.ingsw.ps18.model.personalboard.PBoard, it.polimi.ingsw.ps18.model.gamelogic.GameLogic)
	 */
	@Override
	public void activate(PBoard player, GameLogic game) {
		addObserver(player.getpBoardView());
		game.setOngoingLCEffect(this);
		setChanged();
		notifyObservers(new StatusMessage("FamChoiceLC"));
	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.effect.leaderEffects.ChoiceLeaderEffect#continueEffect(it.polimi.ingsw.ps18.model.personalboard.PBoard, it.polimi.ingsw.ps18.model.gamelogic.GameLogic)
	 */
	@Override
	public void continueEffect(PBoard player, GameLogic game) {
		FMember fam = player.getFams().get(choice);
		fam.setValue(newActionvalue);
	}
	
	/**
	 * Sets the param.
	 *
	 * @param newActionValue the new param
	 */
	public void setParam(int newActionValue){
		if(newActionValue<0){
			this.newActionvalue=0;
		} else {
			this.newActionvalue = newActionValue;
		}
	}

	/**
	 * Sets the choice.
	 *
	 * @param choice the choice to set
	 */
	public void setChoice(int choice) {
		this.choice = choice;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("Change one of you Family Member's value to " + this.newActionvalue + " once every turn");
		return builder.toString();
	}

	/**
	 * Gets the new action value.
	 *
	 * @return the new action value
	 */
	public int getNewActionValue() {
		
		return newActionvalue;
	}
	
	

}
