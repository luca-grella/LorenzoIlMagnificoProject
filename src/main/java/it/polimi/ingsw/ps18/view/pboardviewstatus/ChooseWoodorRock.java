package it.polimi.ingsw.ps18.view.pboardviewstatus;

import java.rmi.RemoteException;
import java.util.Observable;
import java.util.Scanner;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messagesandlogs.ParamMessage;
import it.polimi.ingsw.ps18.rmi.ClientInterface;

/**
 * The Class ChooseWoodorRock.
 */
public class ChooseWoodorRock extends Observable implements PBViewStatus {
	
	/**
	 * The input.
	 */
	Scanner input = new Scanner(System.in);

	public ChooseWoodorRock(MainController controller) {
		addObserver(controller);
	}

	/**
	 * @see it.polimi.ingsw.ps18.view.pboardviewstatus.PBViewStatus#act()
	 */
	@Override
	public void act(ClientInterface playerClient) throws RemoteException {
		int choice = -100;
		try {
			playerClient.notify("Choose which Resource you want to use:\n"
					+ "1. Wood\n"
					+ "2. Rock");
			do{
				choice = playerClient.read();
			} while(choice<=0 || choice>2);
		} catch (RemoteException e) {
			System.out.println("\n[ChooseWoodorRock] Error\n");
		}
		notifyParamMainController("Chosen Resource", choice);
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
