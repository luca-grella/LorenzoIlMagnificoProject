package it.polimi.ingsw.ps18.model.gamelogic;

import java.util.Observable;

import it.polimi.ingsw.ps18.model.messages.ActionMessage;
import it.polimi.ingsw.ps18.model.messages.LogMessage;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

/**
 * Support Class that handle the player's turn. It has a specific View and Controller to
 * separate the work on the main ones.
 * @author Francesco-Musio
 *
 */
public class TurnHandler extends Observable {
	PBoard currentPlayer;
	
	public TurnHandler(PBoard currentplayer){
		this.currentPlayer = currentplayer;
		addObserver(currentplayer.getpBoardView());
	}
	
	public void init(){
		notifyLogMainView("Player color " + currentPlayer.getPlayercol() + " turn");
		notifyActionMainView("Init Player Turn");
	}
	
	
	
	private void notifyLogMainView(String msg){
		setChanged();
		notifyObservers(new LogMessage(msg));
	}
	
	private void notifyActionMainView(String msg){
		setChanged();
		notifyObservers(new ActionMessage(msg));
	}

}
