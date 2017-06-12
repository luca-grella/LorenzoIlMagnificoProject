package it.polimi.ingsw.ps18.view.pboardviewstatus;

import java.util.Observable;
import java.util.Scanner;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messages.ParamMessage;

public class ChoosePlayertoShow extends Observable implements PBViewStatus {
	Scanner input = new Scanner(System.in);

	@Override
	public void setObserver(MainController controller) {
		addObserver(controller);

	}

	@Override
	public void act() {
		System.out.println("Choose the player of which you want to see the resources");
		int choice = input.nextInt();
		notifyParamMainController("RecievePlayertoShow",choice);
	}
	
	private void notifyParamMainController(String msg,int i){
		setChanged();
		notifyObservers(new ParamMessage(msg,i));
	}

}
