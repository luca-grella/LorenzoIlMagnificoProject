package it.polimi.ingsw.ps18.view;

import java.util.Observable;
import java.util.Observer;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messages.ActionMessage;
import it.polimi.ingsw.ps18.model.messages.LogMessage;
import it.polimi.ingsw.ps18.model.messages.Message;

// TODO: Auto-generated Javadoc
/**
 * The Class MainView.
 */
public class MainView extends Observable  implements Observer {
	
	/**
	 * The controller.
	 */
	MainController controller;
	
	/**
	 * Instantiates a new main view.
	 *
	 * @param controller
	 *            the controller
	 */
	public MainView(MainController controller){
		addObserver(controller);
	}

	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		Message msg = (Message) arg;
		switch(msg.getID()){
		case 1:
			LogMessage lMessage = (LogMessage) msg;
			System.out.println(lMessage.getMessage());
			break;
		case 2:
			ActionMessage aMessage = (ActionMessage) msg;
			setChanged();
			notifyObservers(aMessage);
			break;
		}
	}
	

}
