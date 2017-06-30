package it.polimi.ingsw.ps18.view.pboardviewactions;

import java.util.Observable;
import java.util.Scanner;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.gamelogic.GeneralParameters;
import it.polimi.ingsw.ps18.model.messagesandlogs.ParamMessage;
import it.polimi.ingsw.ps18.model.messagesandlogs.StatusMessage;

/**
 * The Class ShowChoiceFamtoTower.
 */
public class ShowChoiceFamtoTower extends Observable implements PBViewAction{
	private int index;
	
	/**
	 * The input.
	 */
	Scanner input = new Scanner(System.in);

	public ShowChoiceFamtoTower(MainController controller) {
		addObserver(controller);
		
	}

	/**
	 * @see it.polimi.ingsw.ps18.view.pboardviewactions.PBViewAction#act()
	 */
	@Override
	public void act() {
		System.out.println("Choose a family member to place:\n"
				+ "-----------------\n0. Back.");
		notifyStatusMainController("Show Fam");
		int choice = input.nextInt();
//		while(choice < 0 || choice > GeneralParameters.nfamperplayer){
//			System.out.println("\nErrore: input non valido\n");
//			notifyStatusMainController("Show Fam");
//			choice = input.nextInt();
//		}
		notifyParamMainController("ReceiveFamtoTower",choice);
		
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

	/**
	 * @see it.polimi.ingsw.ps18.view.pboardviewactions.PBViewAction#setIndex(int)
	 */
	@Override
	public void setIndex(int number) {
		this.index = number;
		
	}

}
