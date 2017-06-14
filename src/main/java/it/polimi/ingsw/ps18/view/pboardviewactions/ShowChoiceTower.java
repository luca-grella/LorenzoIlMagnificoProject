package it.polimi.ingsw.ps18.view.pboardviewactions;

import java.util.Observable;
import java.util.Scanner;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messages.ParamMessage;
import it.polimi.ingsw.ps18.model.messages.StatusMessage;

public class ShowChoiceTower extends Observable implements PBViewAction {
	Scanner input = new Scanner(System.in);

	@Override
	public void setObserver(MainController controller) {
		addObserver(controller);
		
	}

	@Override
	public void act() {
		System.out.println("Chose the Tower in which you want to move in:\n");
		notifyStatusMainController("Show Towers");
		int choiceTower = input.nextInt();
		notifyParamMainController("ReceiveTower",choiceTower);

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
