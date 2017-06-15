package it.polimi.ingsw.ps18.view.pboardviewstatus;

import java.util.Observable;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messages.ActionMessage;

public class ActProduction extends Observable implements PBViewStatus {

	@Override
	public void setObserver(MainController controller) {
		addObserver(controller);

	}

	@Override
	public void act() {
		setChanged();
		notifyObservers(new ActionMessage("actProduction"));
	}

}
