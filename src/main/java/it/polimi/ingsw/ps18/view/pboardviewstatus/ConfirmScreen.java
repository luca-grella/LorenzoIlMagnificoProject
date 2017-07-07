package it.polimi.ingsw.ps18.view.pboardviewstatus;

import java.util.Observable;
import java.util.Scanner;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messagesandlogs.ParamMessage;

public class ConfirmScreen extends Observable implements PBViewStatus {
	Scanner input = new Scanner(System.in);
	
	public ConfirmScreen(MainController controller){
		addObserver(controller);
	}

	@Override
	public void act() {
		System.out.println("Confirm your Choice?"
				+ "\n1. Yes."
				+ "\n2. No.");
		int choice;
		do{
			choice= input.nextInt();
		} while(choice<=0 || choice>2);
		setChanged();
		notifyObservers(new ParamMessage("ReceiveConfirm", choice));
	}

}
