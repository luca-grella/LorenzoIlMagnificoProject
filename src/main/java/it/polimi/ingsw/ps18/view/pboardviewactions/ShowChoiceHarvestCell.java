package it.polimi.ingsw.ps18.view.pboardviewactions;

import java.rmi.RemoteException;
import java.util.Observable;
import java.util.Scanner;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messagesandlogs.ParamMessage;
import it.polimi.ingsw.ps18.model.messagesandlogs.StatusMessage;
import it.polimi.ingsw.ps18.rmi.ClientInterface;

/**
 * The Class ShowChoiceHarvestCell.
 */
public class ShowChoiceHarvestCell extends Observable implements PBViewAction{
	
	/** The index. */
	private int index;
	
	/** The input. */
	Scanner input = new Scanner(System.in);
	
	/**
	 * Instantiates a new show choice harvest cell.
	 *
	 * @param controller the controller
	 */
	public ShowChoiceHarvestCell(MainController controller) {
		addObserver(controller);
	}
	
	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.view.pboardviewactions.PBViewAction#act(it.polimi.ingsw.ps18.rmi.ClientInterface)
	 */
	@Override
	public void act(ClientInterface playerClient)  throws RemoteException {
		int cellChoice = -100;
		try {
			playerClient.notify("Choose the Harvest Cell in which you want to move in:\n"
					+ "1. Harvest Cell without malus\n"
					+ "2. Harvest Cell with malus\n"
					+ "-----------------\n0. Back.");
			notifyStatusMainController("Show Harvest");
			cellChoice = playerClient.read();
		} catch (RemoteException e) {
			System.out.println("\n[ShowChoiceHarvestCell] Error\n");
		}
		notifyParamMainController("ReceiveHarvCell", cellChoice);
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
	
	/**
	 * Notify param main controller.
	 *
	 * @param msg the msg
	 * @param cellChoice the cell choice
	 */
	private void notifyParamMainController(String msg, int cellChoice){
		setChanged();
		notifyObservers(new ParamMessage(msg, cellChoice));
	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.view.pboardviewactions.PBViewAction#setIndex(int)
	 */
	@Override
	public void setIndex(int number) {
		this.index = number;
	}

}
