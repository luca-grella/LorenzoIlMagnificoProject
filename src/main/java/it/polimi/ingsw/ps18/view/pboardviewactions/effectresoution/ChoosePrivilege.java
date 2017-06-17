package it.polimi.ingsw.ps18.view.pboardviewactions.effectresoution;

import java.util.Observable;
import java.util.Scanner;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messages.ParamMessage;
import it.polimi.ingsw.ps18.view.pboardviewactions.PBViewAction;
import it.polimi.ingsw.ps18.view.pboardviewstatus.PBViewStatus;

public class ChoosePrivilege extends Observable implements PBViewAction {
	Scanner input = new Scanner(System.in);
	private int index = -1;

	@Override
	public void setObserver(MainController controller) {
		addObserver(controller);

	}

	@Override
	public void act() {
		System.out.println("Choose which Privilege you want to take:\n"
				+ "1. 1 Wood or 1 Rock.\n"
				+ "2. 2 Servants.\n"
				+ "3. 2 Coins.\n"
				+ "4. 2 Military Points.\n"
				+ "5. 1 Faith Point");
		int choice = input.nextInt();
		if(index == -1){
			notifyParamMainController("Chosen Privilege", choice);
		} else {
			notifyParamMainController("Chosen Diff Privilege", choice);
		}

	}
	
	private void notifyParamMainController(String msg,int i){
		setChanged();
		notifyObservers(new ParamMessage(msg,i));
	}

	@Override
	public void setIndex(int number) {
		this.index = number;
	}

}
