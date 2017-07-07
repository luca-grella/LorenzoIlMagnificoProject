package it.polimi.ingsw.ps18.view.pboardviewstatus.leadercards;

import java.util.Observable;
import java.util.Scanner;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messagesandlogs.ParamMessage;
import it.polimi.ingsw.ps18.view.pboardviewstatus.PBViewStatus;

public class ActivationChoiceLC extends Observable implements PBViewStatus {
	Scanner input = new Scanner(System.in);
	
	public ActivationChoiceLC(MainController controller){
		addObserver(controller);
	}

	@Override
	public void act() {
		System.out.println("Do you want to activate this card?"
				+ "\n1. Yes.\n"
				+ "2. No.");
		int choice;
		do{
			choice = input.nextInt();
		} while(choice!=1&&choice!=2);
		setChanged();
		notifyObservers(new ParamMessage("ReceiveActivationChoice", choice));
	}

}
