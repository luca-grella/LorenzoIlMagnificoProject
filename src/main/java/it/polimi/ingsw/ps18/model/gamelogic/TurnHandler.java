package it.polimi.ingsw.ps18.model.gamelogic;

import java.util.Observable;

import it.polimi.ingsw.ps18.model.messages.ActionMessage;
import it.polimi.ingsw.ps18.model.messages.LogMessage;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

// TODO: Auto-generated Javadoc
/**
 * Support Class that handle the player's turn. It has a specific View and Controller to
 * separate the work on the main ones.
 * @author Francesco-Musio
 *
 */

/*
 * TODO: la classe si potrebbe anche eliminare/modificare per compiere
 * le azioni che accomunano le varie azioni (decorator)
 */
public class TurnHandler extends Observable implements Action {
	
	/**
	 * The current player.
	 */
	PBoard currentPlayer;
	
	/**
	 * Instantiates a new turn handler.
	 *
	 * @param currentplayer
	 *            the currentplayer
	 */
	public TurnHandler(PBoard currentplayer){
		this.currentPlayer = currentplayer;
		addObserver(currentplayer.getpBoardView());
	}
	
	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.gamelogic.Action#act(it.polimi.ingsw.ps18.model.gamelogic.GameLogic)
	 */
	public void act(GameLogic game){
		notifyLogPBoardView("Player color " + currentPlayer.getPlayercol() + " turn");
		notifyActionPboardView("Init Player Turn");
	}
	
	
	
	/**
	 * Notify log P board view.
	 *
	 * @param msg
	 *            the msg
	 */
	private void notifyLogPBoardView(String msg){
		setChanged();
		notifyObservers(new LogMessage(msg));
	}
	
	/**
	 * Notify action pboard view.
	 *
	 * @param msg
	 *            the msg
	 */
	private void notifyActionPboardView(String msg){
		setChanged();
		notifyObservers(new ActionMessage(msg));
	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.gamelogic.Action#setChosenFam(it.polimi.ingsw.ps18.model.personalboard.FMember)
	 */
	@Override
	public void setChosenFam(FMember chosenFam) {
		return;
		
	}

}
