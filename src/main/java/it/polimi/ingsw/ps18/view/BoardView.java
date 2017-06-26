package it.polimi.ingsw.ps18.view;

import java.util.Observable;
import java.util.Observer;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messagesandlogs.LogMessage;
import it.polimi.ingsw.ps18.model.messagesandlogs.Message;

// TODO: Auto-generated Javadoc
/**
 * The Class BoardView.
 */
public class BoardView extends Observable implements Observer{

	/**
	 * Instantiates a new board view.
	 *
	 * @param mcontroller
	 *            the mcontroller
	 */
	public BoardView(MainController mcontroller) {
		addObserver(mcontroller);
	}

	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		Message msg = (Message) arg;
		switch(msg.getID()){
		case 1:
			LogMessage message = (LogMessage) msg;
			System.out.println(message.getMessage()); 
		
		}
	}

}
