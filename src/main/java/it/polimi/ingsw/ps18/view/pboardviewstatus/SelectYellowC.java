package it.polimi.ingsw.ps18.view.pboardviewstatus;

import java.util.Observable;
import java.util.Scanner;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messages.ParamMessage;

public class SelectYellowC extends Observable implements PBViewStatus {
	Scanner input = new Scanner(System.in);

	@Override
	public void setObserver(MainController controller) {
		addObserver(controller);
	}

	@Override
	public void act() {
		System.out.println("Do You Want to Activate this Card's Production Effect?\n"
				+ "1. Yes.\n"
				+ "2. No.\n"
				+ "3. Select cards again.");
		int choice = input.nextInt();
		notifyParamMainController("Selected YCard", choice);
	}
	
	private void notifyParamMainController(String msg, int choice){
		setChanged();
		notifyObservers(new ParamMessage(msg, choice));
	}

}
