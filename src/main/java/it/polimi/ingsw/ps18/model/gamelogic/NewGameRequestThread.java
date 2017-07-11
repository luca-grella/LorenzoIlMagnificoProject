package it.polimi.ingsw.ps18.model.gamelogic;

import java.util.Observable;

import it.polimi.ingsw.ps18.model.messagesandlogs.ParamMessage;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

/**
 * The Class NewGameRequestThread.
 */
public class NewGameRequestThread extends Observable implements Runnable {
	
	/** The color. */
	private int color;
	
	/**
	 * Instantiates a new new game request thread.
	 *
	 * @param player the player
	 */
	public NewGameRequestThread(PBoard player){
		addObserver(player.getpBoardView());
		this.color = player.getPlayercol();
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		setChanged();
		notifyObservers(new ParamMessage("NewGameChoice", color));

	}

}
