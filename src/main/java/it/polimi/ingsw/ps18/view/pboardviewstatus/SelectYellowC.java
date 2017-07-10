package it.polimi.ingsw.ps18.view.pboardviewstatus;

import java.rmi.RemoteException;
import java.util.Observable;
import java.util.Scanner;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messagesandlogs.ParamMessage;
import it.polimi.ingsw.ps18.rmi.ClientInterface;

/**
 * The Class SelectYellowC.
 */
public class SelectYellowC extends Observable implements PBViewStatus {
	
	/**
	 * The input.
	 */
	Scanner input = new Scanner(System.in);

	public SelectYellowC(MainController controller) {
		addObserver(controller);
	}

	/**
	 * @see it.polimi.ingsw.ps18.view.pboardviewstatus.PBViewStatus#act()
	 */
	@Override
	public void act(ClientInterface playerClient) throws RemoteException {
		int choice = -100;
		try {
			playerClient.notify("Do You Want to Activate this Card's Production Effect?\n"
					+ "0. Select Cards Again. [NOT YET IMPLEMENTED]\n"
					+ "1. Yes.\n"
					+ "2. No.\n"
					+ "3. Select and Continue.");
			do{
				choice = playerClient.read();
			} while(choice<0 || choice>3);
		} catch (RemoteException e) {
			System.out.println("\n[SelectYellowC] Error\n");
		}
		notifyParamMainController("Selected YCard", choice);
	}
	
	/**
	 * Notify param main controller.
	 *
	 * @param msg
	 *            the msg
	 * @param choice
	 *            the choice
	 */
	private void notifyParamMainController(String msg, int choice){
		setChanged();
		notifyObservers(new ParamMessage(msg, choice));
	}

}
