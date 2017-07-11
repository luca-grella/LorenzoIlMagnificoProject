package it.polimi.ingsw.ps18.view.pboardviewactions;

import java.rmi.RemoteException;
import java.util.Observable;
import java.util.Scanner;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messagesandlogs.ParamMessage;
import it.polimi.ingsw.ps18.model.messagesandlogs.StatusMessage;
import it.polimi.ingsw.ps18.rmi.ClientInterface;

/**
 * The Class ShowChoiceBonusTiles.
 */
public class ShowChoiceBonusTiles extends Observable implements PBViewAction {
	
	/** The index. */
	private int index;
	
	/** The input. */
	Scanner input = new Scanner(System.in);

	/**
	 * Instantiates a new show choice bonus tiles.
	 *
	 * @param controller the controller
	 */
	public ShowChoiceBonusTiles(MainController controller) {
		addObserver(controller);

	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.view.pboardviewactions.PBViewAction#act(it.polimi.ingsw.ps18.rmi.ClientInterface)
	 */
	@Override
	public void act(ClientInterface playerClient)  throws RemoteException{
		int choice = -100;
		try {
			playerClient.notify("Choose one Bonus Tile:\n");
			notifyStatusMainController("ShowBonusTiles");
			choice = playerClient.read();
		} catch (RemoteException e) {
			System.out.println("\n[ShowChoiceBonusTile] Error\n");
		}
		notifyParamMainController("ReceiveChosenBonusTile", choice);
	}
	
	/**
	 * Notify param main controller.
	 *
	 * @param msg the msg
	 * @param i the i
	 */
	private void notifyParamMainController(String msg,int i){
		setChanged();
		notifyObservers(new ParamMessage(msg,i));
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

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.view.pboardviewactions.PBViewAction#setIndex(int)
	 */
	@Override
	public void setIndex(int number) {
		this.index = number;
	}

}
