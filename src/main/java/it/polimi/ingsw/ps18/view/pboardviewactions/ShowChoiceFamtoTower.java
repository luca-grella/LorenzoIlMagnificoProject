package it.polimi.ingsw.ps18.view.pboardviewactions;

import java.util.Observable;
import java.util.Scanner;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messages.ParamMessage;
import it.polimi.ingsw.ps18.model.messages.StatusMessage;

public class ShowChoiceFamtoTower extends Observable implements PBViewAction{
	Scanner input = new Scanner(System.in);

	@Override
	public void setObserver(MainController controller) {
		addObserver(controller);
		
	}

	@Override
	public void act() {
		System.out.println("Choose a family member to place:\n");
		notifyStatusMainController("Show Fam");
		int choice = input.nextInt();
		notifyParamMainController("ReceiveFamtoTower",choice);
		
	}
	
	private void notifyParamMainController(String msg,int i){
		setChanged();
		notifyObservers(new ParamMessage(msg,i));
	}
	
	private void notifyStatusMainController(String msg){
		setChanged();
		notifyObservers(new StatusMessage(msg));
	}

	@Override
	public void setIndex(int number) {
		return;
		
	}

}
