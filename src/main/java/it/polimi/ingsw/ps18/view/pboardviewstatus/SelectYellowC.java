package it.polimi.ingsw.ps18.view.pboardviewstatus;

import java.util.Observable;
import java.util.Scanner;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messagesandlogs.ParamMessage;

// TODO: Auto-generated Javadoc
/**
 * The Class SelectYellowC.
 */
public class SelectYellowC extends Observable implements PBViewStatus {
	
	/**
	 * The input.
	 */
	Scanner input = new Scanner(System.in);

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.view.pboardviewstatus.PBViewStatus#setObserver(it.polimi.ingsw.ps18.controller.MainController)
	 */
	@Override
	public void setObserver(MainController controller) {
		addObserver(controller);
	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.view.pboardviewstatus.PBViewStatus#act()
	 */
	@Override
	public void act() {
		System.out.println("Do You Want to Activate this Card's Production Effect?\n"
				+ "1. Yes.\n"
				+ "2. No.\n"
				+ "3. Select cards again.");
		int choice = input.nextInt();
		notifyParamMainController("Selected YCard", choice);
	}
	
	/**
	 * Notify param main controller.
	 *
	 * @param msg
	 *            the msg
	 * @param choice
	 *            the choice
	 */
	private void notifyParamMainController(String msg, int choice){
		setChanged();
		notifyObservers(new ParamMessage(msg, choice));
	}

}
