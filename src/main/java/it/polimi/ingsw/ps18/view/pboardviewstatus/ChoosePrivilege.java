package it.polimi.ingsw.ps18.view.pboardviewstatus;

import java.util.Observable;
import java.util.Scanner;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messages.ParamMessage;

public class ChoosePrivilege extends Observable implements PBViewStatus {
	Scanner input = new Scanner(System.in);

	@Override
	public void setObserver(MainController controller) {
		addObserver(controller);

	}

	@Override
	public void act() {
		System.out.println("Choose which Privilege you want to take:\n"
				+ "1. 1 Wood or 1 Rock."
				+ "2. 2 Servants."
				+ "3. 2 Coins."
				+ "4. 2 Military Points."
				+ "5. 1 Faith Point");
		int choice = input.nextInt();
		notifyParamMainController("Chosen Privilege", choice);

	}
	
	private void notifyParamMainController(String msg,int i){
		setChanged();
		notifyObservers(new ParamMessage(msg,i));
	}

}
