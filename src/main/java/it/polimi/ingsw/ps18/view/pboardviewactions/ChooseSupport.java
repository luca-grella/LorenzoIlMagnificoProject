package it.polimi.ingsw.ps18.view.pboardviewactions;

import java.util.Observable;
import java.util.Scanner;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messages.ParamMessage;

public class ChooseSupport extends Observable implements PBViewAction{
	
Scanner input = new Scanner(System.in);

	@Override
	public void setObserver(MainController controller) {
		addObserver(controller);
	}

	@Override
	public void act() {
		System.out.println("\nDo you want to support the Church?\n"
				+ "Digit 1 if you want to support the Church\n"
				+ "Digit 2 if you want to be excommunicated\n");
		int supportChoice = input.nextInt();
		while(supportChoice != 1 && supportChoice != 2){
			System.out.println("\nError: not a valid input\n");
			System.out.println("\nDo you want to support the Church?\n"
					+ "Digit 1 if you want to support the Church\n"
					+ "Digit 2 if you want to be excommunicated\n");
			supportChoice = input.nextInt();
		}
		
		notifyParamMainController("Receive Vatican Answer", supportChoice);
	}
	
	
	private void notifyParamMainController(String msg, int i){
		setChanged();
		notifyObservers(new ParamMessage(msg, i));
	}

	@Override
	public void setIndex(int number) {
		return;
	}

}
