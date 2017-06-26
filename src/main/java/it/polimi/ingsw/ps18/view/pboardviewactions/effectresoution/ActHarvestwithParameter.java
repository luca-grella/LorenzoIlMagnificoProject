package it.polimi.ingsw.ps18.view.pboardviewactions.effectresoution;

import java.util.Observable;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messagesandlogs.ParamMessage;
import it.polimi.ingsw.ps18.view.pboardviewactions.PBViewAction;

// TODO: Auto-generated Javadoc
/**
 * The Class ActHarvestwithParameter.
 */
public class ActHarvestwithParameter extends Observable implements PBViewAction {
    
    /**
	 * The index.
	 */
    private int index;

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.view.pboardviewactions.PBViewAction#setObserver(it.polimi.ingsw.ps18.controller.MainController)
	 */
	@Override
	public void setObserver(MainController controller) {
		addObserver(controller);

	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.view.pboardviewactions.PBViewAction#act()
	 */
	@Override
	public void act() {
		setChanged();
		notifyObservers(new ParamMessage("actHarvest", index));
	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.view.pboardviewactions.PBViewAction#setIndex(int)
	 */
	@Override
	public void setIndex(int number) {
		this.index = number;

	}

}
