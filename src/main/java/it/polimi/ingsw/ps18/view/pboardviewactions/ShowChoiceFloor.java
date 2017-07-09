package it.polimi.ingsw.ps18.view.pboardviewactions;

import java.rmi.RemoteException;
import java.util.Observable;
import java.util.Scanner;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messagesandlogs.ParamMessage;
import it.polimi.ingsw.ps18.rmi.ClientInterface;

/**
 * The Class ShowChoiceFloor.
 */
public class ShowChoiceFloor extends Observable implements PBViewAction {
	
	/**
	 * The input.
	 */
	Scanner input = new Scanner(System.in);
	
	/**
	 * The index.
	 */
	private int index;

	public ShowChoiceFloor(MainController controller) {
		addObserver(controller);
		
	}

	/**
	 * @see it.polimi.ingsw.ps18.view.pboardviewactions.PBViewAction#act()
	 */
	@Override
	public void act(ClientInterface playerClient) {
		int choiceFloor = -100;
		try {
			playerClient.notify("Choose the Floor in which you want to move in:\n"
					+ "-----------------\n0. Back.");
			notifyParamMainController("ReceiveTowertoShow",this.index);
			choiceFloor = playerClient.read();
		} catch (RemoteException e) {
			System.out.println("\n[ShowChoiceFloor] Error\n");
		}
		notifyParamMainController("ReceiveFloor",choiceFloor);

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
