package it.polimi.ingsw.ps18.view.pboardviewstatus;

import java.util.Observable;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messages.ActionMessage;

// TODO: Auto-generated Javadoc
/**
 * The Class ActProduction.
 */
public class ActProduction extends Observable implements PBViewStatus {

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.view.pboardviewstatus.PBViewStatus#setObserver(it.polimi.ingsw.ps18.controller.MainController)
	 */
	@Override
	public void setObserver(MainController controller) {
		addObserver(controller);

	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.view.pboardviewstatus.PBViewStatus#act()
	 */
	@Override
	public void act() {
		setChanged();
		notifyObservers(new ActionMessage("actProduction"));
	}

}
