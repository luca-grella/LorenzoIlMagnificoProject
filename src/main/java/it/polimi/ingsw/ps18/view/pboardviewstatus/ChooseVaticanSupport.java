package it.polimi.ingsw.ps18.view.pboardviewstatus;

import java.util.Scanner;
import java.util.Observable;

import it.polimi.ingsw.ps18.controller.MainController;

// TODO: Auto-generated Javadoc
/**
 * The Class ChooseVaticanSupport.
 */
public class ChooseVaticanSupport extends Observable implements PBViewStatus{
	
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
		System.out.println("\nDo you want to support the Church?\n");
		String answer = input.nextLine();
		
	}
	
	
	
}
