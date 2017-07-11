package it.polimi.ingsw.ps18.view.pboardviewstatus;

import java.rmi.RemoteException;
import java.util.Observable;
import java.util.Scanner;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messagesandlogs.ParamMessage;
import it.polimi.ingsw.ps18.rmi.ClientInterface;

/**
 * The Class ConfirmScreen.
 */
public class ConfirmScreen extends Observable implements PBViewStatus {
	
	/** The input. */
	Scanner input = new Scanner(System.in);
	
	/**
	 * Instantiates a new confirm screen.
	 *
	 * @param controller the controller
	 */
	public ConfirmScreen(MainController controller){
		addObserver(controller);
	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.view.pboardviewstatus.PBViewStatus#act(it.polimi.ingsw.ps18.rmi.ClientInterface)
	 */
	@Override
	public void act(ClientInterface playerClient)  throws RemoteException{
		int choice = -100;
		try {
			playerClient.notify("Confirm your Choice?"
					+ "\n1. Yes."
					+ "\n2. No.");
			do{
				choice= playerClient.read();
			} while(choice<=0 || choice>2);
		} catch (RemoteException e) {
			System.out.println("\n[ConfirmScreen] Error\n");
		}
		setChanged();
		notifyObservers(new ParamMessage("ReceiveConfirm", choice));
	}

}
