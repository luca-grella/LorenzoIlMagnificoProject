package it.polimi.ingsw.ps18.view.pboardviewstatus;

import java.util.Observable;
import java.util.Scanner;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messages.ParamMessage;
import it.polimi.ingsw.ps18.view.pboardviewactions.PBViewAction;

public class ChooseTowertoShow extends Observable implements PBViewStatus {
	Scanner input = new Scanner(System.in);

	@Override
	public void setObserver(MainController controller) {
		addObserver(controller);

	}

	@Override
	public void act() {
		System.out.println("Choose a tower to zoom in. Type 0 to continue.");
		int choice = input.nextInt();
		while(choice!=0){
			notifyParamMainController("RecieveTowertoShow",choice-1);
			System.out.println("Choose a tower to zoom in. Type 0 to continue.");
			choice = input.nextInt();
		}
		

	}
	
	private void notifyParamMainController(String msg,int i){
		setChanged();
		notifyObservers(new ParamMessage(msg,i));
	}

}
