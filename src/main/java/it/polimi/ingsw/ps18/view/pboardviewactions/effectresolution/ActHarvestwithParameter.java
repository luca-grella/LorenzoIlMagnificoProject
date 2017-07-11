package it.polimi.ingsw.ps18.view.pboardviewactions.effectresolution;

import java.rmi.RemoteException;
import java.util.Observable;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messagesandlogs.ParamMessage;
import it.polimi.ingsw.ps18.rmi.ClientInterface;
import it.polimi.ingsw.ps18.view.pboardviewactions.PBViewAction;

/**
 * The Class ActHarvestwithParameter.
 */
public class ActHarvestwithParameter extends Observable implements PBViewAction {
    
    /**
	 * The index.
	 */
    private int index;

	/**
	 * Instantiates a new act harvestwith parameter.
	 *
	 * @param controller the controller
	 */
	public ActHarvestwithParameter(MainController controller) {
		addObserver(controller);

	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.view.pboardviewactions.PBViewAction#act()
	 */
	@Override
	public void act(ClientInterface playerClient)  throws RemoteException{
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
	
	/**
	 * Per test.
	 *
	 * @return the index
	 */
	public int getIndex() {
		return index;

	}

}
