package it.polimi.ingsw.ps18.model.gamelogic;

import java.util.Observable;

import it.polimi.ingsw.ps18.model.messagesandlogs.ActionMessage;
import it.polimi.ingsw.ps18.view.MainView;

public class ActionDevelopThread extends Observable implements Runnable{
	
	public ActionDevelopThread(MainView view){
		addObserver(view);
	}

	@Override
	public void run() {
		setChanged();
		notifyObservers(new ActionMessage("Turn Handle Init"));
		
		return;
	}

}
