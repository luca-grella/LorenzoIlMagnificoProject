package it.polimi.ingsw.ps18.view.pboardviewactions.effectresolution;

import java.rmi.RemoteException;
import java.util.Observable;
import java.util.Scanner;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messagesandlogs.ParamMessage;
import it.polimi.ingsw.ps18.rmi.ClientInterface;
import it.polimi.ingsw.ps18.view.pboardviewactions.PBViewAction;
import it.polimi.ingsw.ps18.view.pboardviewstatus.PBViewStatus;

/**
 * The Class ChoosePrivilege.
 */
public class ChoosePrivilege extends Observable implements PBViewAction {
	
	/**
	 * The input.
	 */
	Scanner input = new Scanner(System.in);
	
	/**
	 * The index.
	 */
	private int index = -1;

	public ChoosePrivilege(MainController controller){
		addObserver(controller);

	}

	/**
	 * @see it.polimi.ingsw.ps18.view.pboardviewactions.PBViewAction#act()
	 */
	@Override
	public void act(ClientInterface playerClient)  throws RemoteException{
		int choice = -100;
		try {
			playerClient.notify("Choose which Privilege you want to take:\n"
					+ "1. 1 Wood or 1 Rock.\n"
					+ "2. 2 Servants.\n"
					+ "3. 2 Coins.\n"
					+ "4. 2 Military Points.\n"
					+ "5. 1 Faith Point");
			do{
				choice = playerClient.read();
			} while(choice<1 || choice>5);
		} catch (RemoteException e) {
			System.out.println("\n[ChoosePrivilege] Error\n");
		}
		if(index == -1){
			notifyParamMainController("Chosen Privilege", choice);
		} else {
			notifyParamMainController("Chosen Diff Privilege", choice);
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

	/**
	 * @see it.polimi.ingsw.ps18.view.pboardviewactions.PBViewAction#setIndex(int)
	 */
	@Override
	public void setIndex(int number) {
		this.index = number;
	}

}
