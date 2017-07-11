package it.polimi.ingsw.ps18.model.gamelogic;

import java.util.Observable;

import it.polimi.ingsw.ps18.model.messagesandlogs.ActionMessage;
import it.polimi.ingsw.ps18.view.MainView;

/**
 * The Class ActionDevelopThread.
 */
public class ActionDevelopThread extends Observable implements Runnable{
	
	/**
	 * Instantiates a new action develop thread.
	 *
	 * @param view the view
	 */
	public ActionDevelopThread(MainView view){
		addObserver(view);
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		setChanged();
		notifyObservers(new ActionMessage("Turn Handle Init"));
		
		return;
	}

}
