package it.polimi.ingsw.ps18.view.pboardviewactions;

import java.rmi.RemoteException;
import java.util.Observable;
import java.util.Scanner;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messagesandlogs.ParamMessage;
import it.polimi.ingsw.ps18.model.messagesandlogs.StatusMessage;
import it.polimi.ingsw.ps18.rmi.ClientInterface;

/**
 * The Class ShowChoiceProductionCell.
 */
public class ShowChoiceProductionCell extends Observable implements PBViewAction{
	
	/** The input. */
	Scanner input = new Scanner(System.in);
	
	/**
	 * Instantiates a new show choice production cell.
	 *
	 * @param controller the controller
	 */
	public ShowChoiceProductionCell(MainController controller) {
		addObserver(controller);
	}
	
	
	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.view.pboardviewactions.PBViewAction#act(it.polimi.ingsw.ps18.rmi.ClientInterface)
	 */
	@Override
	public void act(ClientInterface playerClient)  throws RemoteException{
		int cellChoice = -100;
		try {
			playerClient.notify("Choose the Production Cell in which you want to move in:\n"
					+ "1. Production Cell without malus\n"
					+ "2. Production Cell with malus\n"
					+ "-----------------\n0. Back.");
			notifyStatusMainController("Show Production");
			cellChoice = playerClient.read();
		} catch (RemoteException e) {
			System.out.println("\n[ShowChoiceProductionCell] Error\n");
		}
		notifyParamMainController("ReceiveProdCell", cellChoice);
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
		
	}

}
