package it.polimi.ingsw.ps18.view.pboardviewactions;

import java.rmi.RemoteException;
import java.util.Observable;
import java.util.Scanner;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messagesandlogs.ParamMessage;
import it.polimi.ingsw.ps18.rmi.ClientInterface;

public class ChooseSupport extends Observable implements PBViewAction{
	
	private int index;
	Scanner input = new Scanner(System.in);

	public ChooseSupport(MainController controller) {
		addObserver(controller);
	}

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
	
	
	private void notifyParamMainController(String msg, int i){
		setChanged();
		notifyObservers(new ParamMessage(msg, i));
	}

	@Override
	public void setIndex(int choice) {
		this.index = choice;
	}

}
