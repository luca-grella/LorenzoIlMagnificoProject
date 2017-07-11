package it.polimi.ingsw.ps18.view.pboardviewactions;

import java.rmi.RemoteException;
import java.util.Observable;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messagesandlogs.StatusParamMessage;
import it.polimi.ingsw.ps18.rmi.ClientInterface;

/**
 * The Class NewGameChoice.
 */
public class NewGameChoice extends Observable implements PBViewAction {
	
	/** The color. */
	private int color;
	
	
	/**
	 * Instantiates a new new game choice.
	 *
	 * @param controller the controller
	 */
	public NewGameChoice(MainController controller){
		addObserver(controller);
	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.view.pboardviewactions.PBViewAction#act(it.polimi.ingsw.ps18.rmi.ClientInterface)
	 */
	@Override
	public void act(ClientInterface playerClient)  throws RemoteException{
		int ans = -1;
		try {
			playerClient.notify("\n\n\nDo you want to play again?\n"
					+ "1. Yes.\n"
					+ "2. No.");
			do{
				ans = playerClient.read();
			} while(ans!=1 && ans!=2);
		} catch (RemoteException e) {
			System.out.println("\n[NewGameChoice] Error\n");
		}
		setChanged();
		notifyObservers(new StatusParamMessage("ReceiveNewGameChoice", color, ans)); // da fare
	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.view.pboardviewactions.PBViewAction#setIndex(int)
	 */
	@Override
	public void setIndex(int number) {
		this.color = number;
	}

}
