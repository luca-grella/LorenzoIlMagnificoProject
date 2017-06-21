package it.polimi.ingsw.ps18.model.gamelogic;

import java.util.Observable;

import it.polimi.ingsw.ps18.model.messages.ActionMessage;
import it.polimi.ingsw.ps18.model.messages.LogMessage;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

/**
 * Support Class that handle the player's turn. It has a specific View and Controller to
 * separate the work on the main ones.
 * @author Francesco-Musio
 *
 */

/*
 * TODO: la classe si potrebbe anche eliminare/modificare per compiere
 * le azioni che accomunano le varie azioni (decorator, sa franco)
 */
public class TurnHandler extends Observable implements Action {
	PBoard currentPlayer;
	
	public TurnHandler(PBoard currentplayer){
		this.currentPlayer = currentplayer;
		addObserver(currentplayer.getpBoardView());
	}
	
	public void act(GameLogic game){
		notifyLogPBoardView("Player color " + currentPlayer.getPlayercol() + " turn");
		notifyActionPboardView("Init Player Turn");
	}
	
	
	
	private void notifyLogPBoardView(String msg){
		setChanged();
		notifyObservers(new LogMessage(msg));
	}
	
	private void notifyActionPboardView(String msg){
		setChanged();
		notifyObservers(new ActionMessage(msg));
	}

	@Override
	public void setChosenFam(FMember chosenFam) {
		return;
		
	}

}
