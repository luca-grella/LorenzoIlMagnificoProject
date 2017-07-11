package it.polimi.ingsw.ps18.view.pboardviewstatus.leadercards;

import java.rmi.RemoteException;
import java.util.Observable;
import java.util.Scanner;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messagesandlogs.ParamMessage;
import it.polimi.ingsw.ps18.rmi.ClientInterface;
import it.polimi.ingsw.ps18.view.pboardviewstatus.PBViewStatus;

/**
 * The Class ChooseLC.
 */
public class ChooseLC extends Observable implements PBViewStatus {
	
	/** The input. */
	Scanner input = new Scanner(System.in);

	/**
	 * Instantiates a new choose LC.
	 *
	 * @param controller the controller
	 */
	public ChooseLC(MainController controller){
		addObserver(controller);
	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.view.pboardviewstatus.PBViewStatus#act(it.polimi.ingsw.ps18.rmi.ClientInterface)
	 */
	@Override
	public void act(ClientInterface playerClient)  throws RemoteException{
		int choice = -100;
		try {
			choice = playerClient.read();
		} catch (RemoteException e) {
			System.out.println("\n[ChooseLC] Error\n");
		}
		notifyParamMainController("ReceiveChoiceLC", choice);
	}
	
	/**
	 * Notify param main controller.
	 *
	 * @param msg
	 *            the msg
	 * @param i
	 *            the i
	 */
	private void notifyParamMainController(String msg,int i){
		setChanged();
		notifyObservers(new ParamMessage(msg,i));
	}

}
