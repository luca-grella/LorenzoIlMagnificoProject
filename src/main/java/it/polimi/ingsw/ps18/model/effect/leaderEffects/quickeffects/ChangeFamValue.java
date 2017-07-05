package it.polimi.ingsw.ps18.model.effect.leaderEffects.quickeffects;

import java.util.Observable;

import it.polimi.ingsw.ps18.model.effect.leaderEffects.ChoiceLeaderEffect;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.messagesandlogs.StatusMessage;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class ChangeFamValue extends Observable implements LCQuickEffect, ChoiceLeaderEffect {
	private int newActionvalue;
	private int choice;
	private String description;

	@Override
	public void activate(PBoard player, GameLogic game) {
		addObserver(player.getpBoardView());
		game.setOngoingLCEffect(this);
		setChanged();
		notifyObservers(new StatusMessage("FamChoiceLC"));
	}

	@Override
	public void continueEffect(PBoard player, GameLogic game) {
		FMember fam = player.getFams().get(choice);
		fam.setValue(newActionvalue);
	}
	
	public void setParam(int newActionValue, String description){
		if(newActionValue<0){
			this.newActionvalue=0;
		} else {
			this.newActionvalue = newActionValue;
		}
		this.description = description;
	}

	/**
	 * @param choice the choice to set
	 */
	public void setChoice(int choice) {
		this.choice = choice;
	}
	
	@Override
	public String toString(){
		return description;
	}
	
	

}
