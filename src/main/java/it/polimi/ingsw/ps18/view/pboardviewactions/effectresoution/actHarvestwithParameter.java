package it.polimi.ingsw.ps18.view.pboardviewactions.effectresoution;

import java.util.Observable;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messages.ParamMessage;
import it.polimi.ingsw.ps18.view.pboardviewactions.PBViewAction;

public class actHarvestwithParameter extends Observable implements PBViewAction {
    private int index;

	@Override
	public void setObserver(MainController controller) {
		addObserver(controller);

	}

	@Override
	public void act() {
		setChanged();
		notifyObservers(new ParamMessage("actHarvest", index));
	}

	@Override
	public void setIndex(int number) {
		this.index = number;

	}

}
