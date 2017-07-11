package it.polimi.ingsw.ps18.view.pboardviewactions;

import java.rmi.RemoteException;
import java.util.Observable;
import java.util.Scanner;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messagesandlogs.ActionMessage;
import it.polimi.ingsw.ps18.model.messagesandlogs.ParamMessage;
import it.polimi.ingsw.ps18.model.messagesandlogs.StatusMessage;
import it.polimi.ingsw.ps18.rmi.ClientInterface;

/**
 * The Class ShowChoiceServants.
 */
public class ShowChoiceServants extends Observable implements PBViewAction{
	
	/** The index. */
	private int index;
	
	/** The input. */
	Scanner input = new Scanner(System.in);
	

	/**
	 * Instantiates a new show choice servants.
	 *
	 * @param controller the controller
	 */
	public ShowChoiceServants (MainController controller) {
		addObserver(controller);
	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.view.pboardviewactions.PBViewAction#act(it.polimi.ingsw.ps18.rmi.ClientInterface)
	 */
	@Override
	public void act(ClientInterface playerClient)  throws RemoteException{
		int choice = -100;
		try {
			playerClient.notify("Choose a number of Servants to add:\n");
			notifyStatusMainController("Show Servants");
			choice = playerClient.read();
		} catch (RemoteException e) {
			System.out.println("\n[ShowChoiceServants] Error\n");
		}
		notifyParamMainController("Add Servants", choice);
	}
	
	
	/**
	 * Notify status main controller.
	 *
	 * @param msg the msg
	 */
	private void notifyStatusMainController(String msg){
		setChanged();
		notifyObservers(new StatusMessage(msg));
	}
	
	/**
	 * Notify param main controller.
	 *
	 * @param msg the msg
	 * @param numberOfServants the number of servants
	 */
	private void notifyParamMainController(String msg, int numberOfServants){
		setChanged();
		notifyObservers(new ParamMessage(msg, numberOfServants));
	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.view.pboardviewactions.PBViewAction#setIndex(int)
	 */
	@Override
	public void setIndex(int number) {
		this.index = number;
	}

}
