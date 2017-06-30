package it.polimi.ingsw.ps18.view.pboardviewactions;

import java.util.Observable;
import java.util.Scanner;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messagesandlogs.ActionMessage;
import it.polimi.ingsw.ps18.model.messagesandlogs.ParamMessage;
import it.polimi.ingsw.ps18.model.messagesandlogs.StatusMessage;

public class ShowChoiceServants extends Observable implements PBViewAction{
	private int index;
	Scanner input = new Scanner(System.in);
	

	public ShowChoiceServants (MainController controller) {
		addObserver(controller);
	}

	@Override
	public void act() {
		System.out.println("\nChoose a number of servants to add:\n");
		notifyStatusMainController("Show Servants");
		int choice = input.nextInt();
		notifyParamMainController("Add Servants", choice);
		//Sta notify dove la mando? devo solo sommare choice agli actionvalue del familiare scelto.
	}
	
	
	private void notifyStatusMainController(String msg){
		setChanged();
		notifyObservers(new StatusMessage(msg));
	}
	private void notifyParamMainController(String msg, int numberOfServants){
		setChanged();
		notifyObservers(new ParamMessage(msg, numberOfServants));
	}

	@Override
	public void setIndex(int number) {
		this.index = number;
	}

}
