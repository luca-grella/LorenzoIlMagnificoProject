package it.polimi.ingsw.ps18.view.pboardviewactions;

import java.rmi.RemoteException;
import java.util.Observable;
import java.util.Scanner;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messagesandlogs.ParamMessage;
import it.polimi.ingsw.ps18.model.messagesandlogs.StatusParamMessage;
import it.polimi.ingsw.ps18.rmi.ClientInterface;
import it.polimi.ingsw.ps18.view.pboardviewstatus.PBViewStatus;

/**
 * The Class ChoosePlayertoShow.
 */
public class ChoosePlayertoShow extends Observable implements PBViewAction {
	
	/** The color. */
	private int color;
	
	/**
	 * The input.
	 */
	Scanner input = new Scanner(System.in);

	/**
	 * Instantiates a new choose playerto show.
	 *
	 * @param controller the controller
	 */
	public ChoosePlayertoShow(MainController controller) {
		addObserver(controller);

	}

	/**
	 * Act.
	 *
	 * @param playerClient the player client
	 * @throws RemoteException the remote exception
	 * @see it.polimi.ingsw.ps18.view.pboardviewstatus.PBViewStatus#act()
	 */
	@Override
	public void act(ClientInterface playerClient)  throws RemoteException {
		int choice = -100;
		try {
			playerClient.notify("Choose the player of which you want to see the resources:\n");
			choice = playerClient.read();
		} catch (RemoteException e) {
			System.out.println("\n[ChoosePlayertoShow] Error\n");
		}
		notifyStatusParamMainController("ReceivePlayertoShow", color ,choice);
	}
	
	/**
	 * Notify param main controller.
	 *
	 * @param msg            the msg
	 * @param color the color
	 * @param index the index
	 */
	private void notifyStatusParamMainController(String msg,int color, int index){
		setChanged();
		notifyObservers(new StatusParamMessage(msg,color, index));
	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.view.pboardviewactions.PBViewAction#setIndex(int)
	 */
	@Override
	public void setIndex(int number) {
		this.color = number;
	}

}
