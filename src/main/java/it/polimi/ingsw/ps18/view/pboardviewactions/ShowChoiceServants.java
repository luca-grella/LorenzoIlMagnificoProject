package it.polimi.ingsw.ps18.view.pboardviewactions;

import java.rmi.RemoteException;
import java.util.Observable;
import java.util.Scanner;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messagesandlogs.ActionMessage;
import it.polimi.ingsw.ps18.model.messagesandlogs.ParamMessage;
import it.polimi.ingsw.ps18.model.messagesandlogs.StatusMessage;
import it.polimi.ingsw.ps18.rmi.ClientInterface;

public class ShowChoiceServants extends Observable implements PBViewAction{
	private int index;
	Scanner input = new Scanner(System.in);
	

	public ShowChoiceServants (MainController controller) {
		addObserver(controller);
	}

	@Override
	public void act(ClientInterface playerClient)  throws RemoteException{
		int choice = -100;
		try {
			playerClient.notify("Choose a number of Servants to add:\n");
			notifyStatusMainController("Show Servants");
			choice = playerClient.read();
		} catch (RemoteException e) {
			System.out.println("\n[ShowChoiceServants] Error\n");
		}
		notifyParamMainController("Add Servants", choice);
	}
	
	
	private void notifyStatusMainController(String msg){
		setChanged();
		notifyObservers(new StatusMessage(msg));
	}
	private void notifyParamMainController(String msg, int numberOfServants){
		setChanged();
		notifyObservers(new ParamMessage(msg, numberOfServants));
	}

	@Override
	public void setIndex(int number) {
		this.index = number;
	}

}
