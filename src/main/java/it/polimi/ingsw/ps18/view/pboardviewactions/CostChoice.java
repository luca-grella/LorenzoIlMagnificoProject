package it.polimi.ingsw.ps18.view.pboardviewactions;

import java.util.Observable;
import java.util.Scanner;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messagesandlogs.ParamMessage;

public class CostChoice extends Observable implements PBViewAction {
	private int index;
	Scanner input = new Scanner(System.in);

	public CostChoice(MainController controller) {
		addObserver(controller);

	}

	@Override
	public void act() {
		System.out.println("How do You want to pay for this Card?\n"
				+ "0. Back."
				+ "1. Resources.\n"
				+ "2. Military Points");
		int choice = input.nextInt();
		setChanged();
		notifyObservers(new ParamMessage("ReceiveChosenCost", choice));

	}

	@Override
	public void setIndex(int number) {
		this.index = number;

	}

}
