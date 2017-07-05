package it.polimi.ingsw.ps18.view.pboardviewstatus;

import java.util.Observable;
import java.util.Scanner;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messagesandlogs.ParamMessage;
import it.polimi.ingsw.ps18.model.messagesandlogs.StatusMessage;

public class ChooseFamforValueChangeLC extends Observable implements PBViewStatus {
	
	/**
	 * The input.
	 */
	Scanner input = new Scanner(System.in);
	
	public ChooseFamforValueChangeLC(MainController controller){
		addObserver(controller);
	}

	@Override
	public void act() {
		System.out.println("Choose a Family Member of which you want to incrase the value:\n");
		notifyStatusMainController("Show Fam");
		int choice = input.nextInt();
		notifyParamMainController("ReceiveFamforValueChange",choice);
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
	
	/**
	 * Notify status main controller.
	 *
	 * @param msg
	 *            the msg
	 */
	private void notifyStatusMainController(String msg){
		setChanged();
		notifyObservers(new StatusMessage(msg));
	}

}
