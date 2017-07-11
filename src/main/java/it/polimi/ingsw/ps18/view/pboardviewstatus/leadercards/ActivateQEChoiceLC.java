package it.polimi.ingsw.ps18.view.pboardviewstatus.leadercards;

import java.rmi.RemoteException;
import java.util.Observable;
import java.util.Scanner;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messagesandlogs.ParamMessage;
import it.polimi.ingsw.ps18.rmi.ClientInterface;
import it.polimi.ingsw.ps18.view.pboardviewstatus.PBViewStatus;

/**
 * The Class ActivateQEChoiceLC.
 */
public class ActivateQEChoiceLC extends Observable implements PBViewStatus {
	
	/** The input. */
	Scanner input = new Scanner(System.in);
	
	/**
	 * Instantiates a new activate QE choice LC.
	 *
	 * @param mcontroller the mcontroller
	 */
	public ActivateQEChoiceLC(MainController mcontroller){
		addObserver(mcontroller);
	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.view.pboardviewstatus.PBViewStatus#act(it.polimi.ingsw.ps18.rmi.ClientInterface)
	 */
	@Override
	public void act(ClientInterface playerClient) throws RemoteException {
		System.out.println("Do you want to activate this card's quick effect?"
				+ "\n1. Yes."
				+ "\n2. No.");
		int choice;
		do{
			choice = input.nextInt();
		} while(choice<=0 || choice>2);
		setChanged();
		notifyObservers(new ParamMessage("ReceiveActivationLCQEChoice", choice));
	}

}
