package it.polimi.ingsw.ps18.view.pboardviewstatus;

import java.util.Observable;
import java.util.Scanner;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messagesandlogs.ParamMessage;

// TODO: Auto-generated Javadoc
/**
 * The Class ChooseWoodorRock.
 */
public class ChooseWoodorRock extends Observable implements PBViewStatus {
	
	/**
	 * The input.
	 */
	Scanner input = new Scanner(System.in);

	/**
	 * @see it.polimi.ingsw.ps18.view.pboardviewstatus.PBViewStatus#setObserver(it.polimi.ingsw.ps18.controller.MainController)
	 */
	@Override
	public void setObserver(MainController controller) {
		addObserver(controller);
	}

	/**
	 * @see it.polimi.ingsw.ps18.view.pboardviewstatus.PBViewStatus#act()
	 */
	@Override
	public void act() {
		System.out.println("Choose which Resource you want to use:\n"
				+ "1. Wood\n"
				+ "2. Rock");
		int choice = input.nextInt();
		notifyParamMainController("Chosen Resource", choice);
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
