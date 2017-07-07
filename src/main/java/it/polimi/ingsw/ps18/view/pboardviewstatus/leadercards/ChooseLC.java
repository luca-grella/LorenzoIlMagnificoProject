package it.polimi.ingsw.ps18.view.pboardviewstatus.leadercards;

import java.util.Observable;
import java.util.Scanner;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messagesandlogs.ParamMessage;
import it.polimi.ingsw.ps18.view.pboardviewstatus.PBViewStatus;

public class ChooseLC extends Observable implements PBViewStatus {
	Scanner input = new Scanner(System.in);

	public ChooseLC(MainController controller){
		addObserver(controller);
	}

	@Override
	public void act() {
		int choice = input.nextInt();
		notifyParamMainController("ReceiveChoiceLC", choice);
	}
	
	/**
	 * Notify param main controller.
	 *
	 * @param msg
	 *            the msg
	 * @param i
	 *            the i
	 */
	private void notifyParamMainController(String msg,int i){
		setChanged();
		notifyObservers(new ParamMessage(msg,i));
	}

}
