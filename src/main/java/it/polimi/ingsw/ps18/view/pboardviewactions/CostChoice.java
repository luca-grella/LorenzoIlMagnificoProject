package it.polimi.ingsw.ps18.view.pboardviewactions;

import java.rmi.RemoteException;
import java.util.Observable;
import java.util.Scanner;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messagesandlogs.ParamMessage;
import it.polimi.ingsw.ps18.rmi.ClientInterface;

/**
 * The Class CostChoice.
 */
public class CostChoice extends Observable implements PBViewAction {
	
	/** The index. */
	private int index;
	
	/** The input. */
	Scanner input = new Scanner(System.in);

	/**
	 * Instantiates a new cost choice.
	 *
	 * @param controller the controller
	 */
	public CostChoice(MainController controller) {
		addObserver(controller);

	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.view.pboardviewactions.PBViewAction#act(it.polimi.ingsw.ps18.rmi.ClientInterface)
	 */
	@Override
	public void act(ClientInterface playerClient)  throws RemoteException{
		int choice = -100;
		try {
			playerClient.notify("How do You want to pay for this Card?\n"
					+ "0. Back."
					+ "1. Resources.\n"
					+ "2. Military Points");
			do{
				choice = playerClient.read();
			} while(choice<0 || choice>2);
		} catch (RemoteException e) {
			System.out.println("\n[CostChoice] Error\n");
		}
		setChanged();
		notifyObservers(new ParamMessage("ReceiveChosenCost", choice));

	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.view.pboardviewactions.PBViewAction#setIndex(int)
	 */
	@Override
	public void setIndex(int number) {
		this.index = number;

	}

}
