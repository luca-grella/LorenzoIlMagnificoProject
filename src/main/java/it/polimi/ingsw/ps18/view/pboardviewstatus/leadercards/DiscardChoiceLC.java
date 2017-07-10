package it.polimi.ingsw.ps18.view.pboardviewstatus.leadercards;

import java.rmi.RemoteException;
import java.util.Observable;
import java.util.Scanner;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messagesandlogs.ParamMessage;
import it.polimi.ingsw.ps18.rmi.ClientInterface;
import it.polimi.ingsw.ps18.view.pboardviewstatus.PBViewStatus;

public class DiscardChoiceLC extends Observable implements PBViewStatus {
	Scanner input = new Scanner(System.in);
	
	public DiscardChoiceLC(MainController controller){
		addObserver(controller);
	}

	@Override
	public void act(ClientInterface playerClient) throws RemoteException {
		int choice = -100;
		try {
			playerClient.notify("Select which card you want to discard."
					+ "\n0. Back.");
			choice = playerClient.read();
		} catch (RemoteException e) {
			System.out.println("\n[DiscardChoiceLC] Error\n");
		}
		setChanged();
		notifyObservers(new ParamMessage("ReceiveDiscardChoice",choice));
	}

}
