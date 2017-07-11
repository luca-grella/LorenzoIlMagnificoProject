package it.polimi.ingsw.ps18.view.pboardviewstatus.leadercards;

import java.rmi.RemoteException;
import java.util.Observable;
import java.util.Scanner;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messagesandlogs.ParamMessage;
import it.polimi.ingsw.ps18.rmi.ClientInterface;
import it.polimi.ingsw.ps18.view.pboardviewstatus.PBViewStatus;

/**
 * The Class ChooseLCtoCopy.
 */
public class ChooseLCtoCopy extends Observable implements PBViewStatus {
	
	/** The input. */
	Scanner input = new Scanner(System.in);
	
	
	/**
	 * Instantiates a new choose L cto copy.
	 *
	 * @param controller the controller
	 */
	public ChooseLCtoCopy(MainController controller){
		addObserver(controller);
	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.view.pboardviewstatus.PBViewStatus#act(it.polimi.ingsw.ps18.rmi.ClientInterface)
	 */
	@Override
	public void act(ClientInterface playerClient) throws RemoteException {
		int choice = -100;
		try {
			playerClient.notify("Choose which card you want to copy.");
			choice = playerClient.read();
		} catch (RemoteException e) {
			System.out.println("\n[ChooseLCtoCopy] Error\n");
		}
		setChanged();
		notifyObservers(new ParamMessage("ReceiveLCtoCopy", choice));
	}

}
