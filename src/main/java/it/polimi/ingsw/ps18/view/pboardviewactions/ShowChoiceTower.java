package it.polimi.ingsw.ps18.view.pboardviewactions;

import java.rmi.RemoteException;
import java.util.Observable;
import java.util.Scanner;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messagesandlogs.ParamMessage;
import it.polimi.ingsw.ps18.model.messagesandlogs.StatusMessage;
import it.polimi.ingsw.ps18.rmi.ClientInterface;

/**
 * The Class ShowChoiceTower.
 */
public class ShowChoiceTower extends Observable implements PBViewAction {
	private int index;
	
	/**
	 * The input.
	 */
	Scanner input = new Scanner(System.in);

	public ShowChoiceTower(MainController controller){
		addObserver(controller);
		
	}

	/**
	 * @see it.polimi.ingsw.ps18.view.pboardviewactions.PBViewAction#act()
	 */
	@Override
	public void act(ClientInterface playerClient)  throws RemoteException{
		int choiceTower = -100;
		try {
			playerClient.notify("Choose the Tower in which you want to move in:\n"
					+ "-----------------\n0. Back.");
			notifyStatusMainController("Show Towers");
			choiceTower = playerClient.read();
		} catch (RemoteException e) {
			System.out.println("\n[ShowChoiceTower] Error\n");
		}
		notifyParamMainController("ReceiveTower",choiceTower);

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

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.view.pboardviewactions.PBViewAction#setIndex(int)
	 */
	@Override
	public void setIndex(int number) {
		this.index = number;
	}

}
