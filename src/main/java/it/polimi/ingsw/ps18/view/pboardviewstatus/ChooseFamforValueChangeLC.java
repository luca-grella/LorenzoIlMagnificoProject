package it.polimi.ingsw.ps18.view.pboardviewstatus;

import java.rmi.RemoteException;
import java.util.Observable;
import java.util.Scanner;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messagesandlogs.ParamMessage;
import it.polimi.ingsw.ps18.model.messagesandlogs.StatusMessage;
import it.polimi.ingsw.ps18.rmi.ClientInterface;

/**
 * The Class ChooseFamforValueChangeLC.
 */
public class ChooseFamforValueChangeLC extends Observable implements PBViewStatus {
	
	/**
	 * The input.
	 */
	Scanner input = new Scanner(System.in);
	
	/**
	 * Instantiates a new choose famfor value change LC.
	 *
	 * @param controller the controller
	 */
	public ChooseFamforValueChangeLC(MainController controller){
		addObserver(controller);
	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.view.pboardviewstatus.PBViewStatus#act(it.polimi.ingsw.ps18.rmi.ClientInterface)
	 */
	@Override
	public void act(ClientInterface playerClient) throws RemoteException {
		int choice = -100;
		try {
			playerClient.notify("Choose a Family Member of which you want to increase the value:\n");
			notifyStatusMainController("Show Fam");
			choice = playerClient.read();
		} catch (RemoteException e) {
			System.out.println("\n[ChooseFamforValueChangeLC] Error\n");
		}
		notifyParamMainController("ReceiveFamforValueChange",choice);
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
	
	/**
	 * Notify status main controller.
	 *
	 * @param msg
	 *            the msg
	 */
	private void notifyStatusMainController(String msg){
		setChanged();
		notifyObservers(new StatusMessage(msg));
	}

}
