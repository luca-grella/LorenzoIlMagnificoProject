package it.polimi.ingsw.ps18.view.pboardviewstatus.leadercards;

import java.util.Observable;
import java.util.Scanner;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messagesandlogs.ParamMessage;
import it.polimi.ingsw.ps18.rmi.ClientInterface;
import it.polimi.ingsw.ps18.view.pboardviewstatus.PBViewStatus;

public class ActivateQEChoiceLC extends Observable implements PBViewStatus {
	Scanner input = new Scanner(System.in);
	
	public ActivateQEChoiceLC(MainController mcontroller){
		addObserver(mcontroller);
	}

	@Override
	public void act(ClientInterface playerClient) {
		System.out.println("Do you want to activate this card's quick effect?"
				+ "\n1. Yes."
				+ "\n2. No.");
		int choice;
		do{
			choice = input.nextInt();
		} while(choice<=0 || choice>2);
		setChanged();
		notifyObservers(new ParamMessage("ReceiveActivationLCQEChoice", choice));
	}

}
