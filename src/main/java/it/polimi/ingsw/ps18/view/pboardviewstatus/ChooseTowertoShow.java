package it.polimi.ingsw.ps18.view.pboardviewstatus;

import java.rmi.RemoteException;
import java.util.Observable;
import java.util.Scanner;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messagesandlogs.ParamMessage;
import it.polimi.ingsw.ps18.rmi.ClientInterface;
import it.polimi.ingsw.ps18.view.pboardviewactions.PBViewAction;

/**
 * The Class ChooseTowertoShow.
 */
public class ChooseTowertoShow extends Observable implements PBViewStatus {
	
	/**
	 * The input.
	 */
	Scanner input = new Scanner(System.in);

	public ChooseTowertoShow(MainController controller) {
		addObserver(controller);

	}

	/**
	 * @see it.polimi.ingsw.ps18.view.pboardviewstatus.PBViewStatus#act()
	 */
	@Override
	public void act(ClientInterface playerClient) {
		int choice = -100;
		try {
			playerClient.notify("\nChoose a tower to zoom in. Type 0 to continue.");
			do{
				choice = playerClient.read();
			} while(choice<0);
			while(choice!=0){
				notifyParamMainController("ReceiveTowertoShow",choice-1);
				playerClient.notify("\nChoose a tower to zoom in. Type 0 to continue.");
				do{
					choice = playerClient.read();
				} while(choice<0);
			}
		} catch (RemoteException e) {
			System.out.println("\n[ChooseTowertoShow] Error\n");
		}
		

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
