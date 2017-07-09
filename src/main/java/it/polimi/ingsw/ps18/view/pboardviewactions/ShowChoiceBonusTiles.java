package it.polimi.ingsw.ps18.view.pboardviewactions;

import java.rmi.RemoteException;
import java.util.Observable;
import java.util.Scanner;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messagesandlogs.ParamMessage;
import it.polimi.ingsw.ps18.model.messagesandlogs.StatusMessage;
import it.polimi.ingsw.ps18.rmi.ClientInterface;

public class ShowChoiceBonusTiles extends Observable implements PBViewAction {
	private int index;
	Scanner input = new Scanner(System.in);

	public ShowChoiceBonusTiles(MainController controller) {
		addObserver(controller);

	}

	@Override
	public void act(ClientInterface playerClient) {
		int choice = -100;
		try {
			playerClient.notify("Choose one Bonus Tile:\n");
			notifyStatusMainController("ShowBonusTiles");
			choice = playerClient.read();
		} catch (RemoteException e) {
			System.out.println("\n[ShowChoiceBonusTile] Error\n");
		}
		notifyParamMainController("ReceiveChosenBonusTile", choice);
	}
	
	private void notifyParamMainController(String msg,int i){
		setChanged();
		notifyObservers(new ParamMessage(msg,i));
	}
	
	private void notifyStatusMainController(String msg){
		setChanged();
		notifyObservers(new StatusMessage(msg));
	}

	@Override
	public void setIndex(int number) {
		this.index = number;
	}

}
