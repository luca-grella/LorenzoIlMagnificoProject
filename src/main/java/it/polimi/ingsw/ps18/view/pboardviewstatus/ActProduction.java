package it.polimi.ingsw.ps18.view.pboardviewstatus;

import java.rmi.RemoteException;
import java.util.Observable;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messagesandlogs.ActionMessage;
import it.polimi.ingsw.ps18.rmi.ClientInterface;

/**
 * The Class ActProduction.
 */
public class ActProduction extends Observable implements PBViewStatus {

	public ActProduction(MainController controller) {
		addObserver(controller);

	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.view.pboardviewstatus.PBViewStatus#act()
	 */
	@Override
	public void act(ClientInterface playerClient)  throws RemoteException{
		setChanged();
		notifyObservers(new ActionMessage("actProduction"));
	}

}
