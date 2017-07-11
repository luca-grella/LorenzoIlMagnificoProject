package it.polimi.ingsw.ps18.view.pboardviewactions;

import java.rmi.RemoteException;
import java.util.Observable;
import java.util.Scanner;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messagesandlogs.ParamMessage;
import it.polimi.ingsw.ps18.rmi.ClientInterface;

/**
 * The Class ChooseSupport.
 */
public class ChooseSupport extends Observable implements PBViewAction{
	
	/** The index. */
	private int index;
	
	/** The input. */
	Scanner input = new Scanner(System.in);

	/**
	 * Instantiates a new choose support.
	 *
	 * @param controller the controller
	 */
	public ChooseSupport(MainController controller) {
		addObserver(controller);
	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.view.pboardviewactions.PBViewAction#act(it.polimi.ingsw.ps18.rmi.ClientInterface)
	 */
	@Override
	public void act(ClientInterface playerClient)  throws RemoteException {
		int supportChoice = -100;
		try {
			playerClient.notify("\nDo you want to support the Church?\n"
					+ "Digit 1 if you want to support the Church\n"
					+ "Digit 2 if you want to be excommunicated\n");
			supportChoice = playerClient.read();
			while(supportChoice != 1 && supportChoice != 2){
				playerClient.notify("\nError: not a valid input\n");
				playerClient.notify("\nDo you want to support the Church?\n"
						+ "Digit 1 if you want to support the Church\n"
						+ "Digit 2 if you want to be excommunicated\n");
				supportChoice = playerClient.read();
			}
		} catch (RemoteException e) {
			System.out.println("\n[ChooseSupport] Error\n");
		}
		
		notifyParamMainController("Receive Vatican Answer", supportChoice);
	}
	
	
	/**
	 * Notify param main controller.
	 *
	 * @param msg the msg
	 * @param i the i
	 */
	private void notifyParamMainController(String msg, int i){
		setChanged();
		notifyObservers(new ParamMessage(msg, i));
	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.view.pboardviewactions.PBViewAction#setIndex(int)
	 */
	@Override
	public void setIndex(int choice) {
		this.index = choice;
	}

}
