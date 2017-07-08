package it.polimi.ingsw.ps18.view.pboardviewstatus.leadercards;

import java.util.Observable;
import java.util.Scanner;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messagesandlogs.ParamMessage;
import it.polimi.ingsw.ps18.rmi.ClientInterface;
import it.polimi.ingsw.ps18.view.pboardviewstatus.PBViewStatus;

public class ChooseLCtoCopy extends Observable implements PBViewStatus {
	Scanner input = new Scanner(System.in);
	
	
	public ChooseLCtoCopy(MainController controller){
		addObserver(controller);
	}

	@Override
	public void act(ClientInterface playerClient) {
		System.out.println("Choose which card you want to copy.");
		int choice = input.nextInt();
		setChanged();
		notifyObservers(new ParamMessage("ReceiveLCtoCopy", choice));
	}

}
