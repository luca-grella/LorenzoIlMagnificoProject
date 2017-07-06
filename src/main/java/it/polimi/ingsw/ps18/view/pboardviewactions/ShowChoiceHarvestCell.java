package it.polimi.ingsw.ps18.view.pboardviewactions;

import java.util.Observable;
import java.util.Scanner;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messagesandlogs.ParamMessage;
import it.polimi.ingsw.ps18.model.messagesandlogs.StatusMessage;

public class ShowChoiceHarvestCell extends Observable implements PBViewAction{
	
	private int index;
	
	Scanner input = new Scanner(System.in);
	
	public ShowChoiceHarvestCell(MainController controller) {
		addObserver(controller);
	}
	
	@Override
	public void act() {
		System.out.println("Choose the Harvest Cell in which you want to move in:\n"
				+ "1. Harvest Cell without malus\n"
				+ "2. Harvest Cell with malus\n"
				+ "-----------------\n0. Back.");
		notifyStatusMainController("Show Harvest");
		int cellChoice = input.nextInt();
		notifyParamMainController("ReceiveHarvCell", cellChoice);
	}
	
	private void notifyStatusMainController(String msg){
		setChanged();
		notifyObservers(new StatusMessage(msg));
	}
	
	private void notifyParamMainController(String msg, int cellChoice){
		setChanged();
		notifyObservers(new ParamMessage(msg, cellChoice));
	}

	@Override
	public void setIndex(int number) {
		this.index = number;
	}

}
