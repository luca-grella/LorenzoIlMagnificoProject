package it.polimi.ingsw.ps18.view.pboardviewstatus;

import java.util.Observable;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messagesandlogs.ActionMessage;
import it.polimi.ingsw.ps18.rmi.ClientInterface;

/**
 * The Class ActHarvest.
 */
public class ActHarvest extends Observable implements PBViewStatus {

	public ActHarvest(MainController controller) {
		addObserver(controller);

	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.view.pboardviewstatus.PBViewStatus#act()
	 */
	@Override
	public void act(ClientInterface playerClient) {
		setChanged();
		notifyObservers(new ActionMessage("actHarvest"));
	}

}
