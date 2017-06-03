package it.polimi.ingsw.ps18.view.pboardviewactions;

import java.util.Observable;
import java.util.Scanner;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messages.ActionMessage;
import it.polimi.ingsw.ps18.model.messages.LogMessage;
import it.polimi.ingsw.ps18.model.messages.StatusMessage;
import it.polimi.ingsw.ps18.model.personalBoard.FMember;

public class ShowChoiceFam extends Observable implements PBViewAction{

	@Override
	public void setObserver(MainController controller) {
		addObserver(controller);
		
	}

	@Override
	public void act() {
		System.out.println("Chose from yours family members which one to move:\n");
		notifyStatusMainController("Show Fam");
		//inserimento scelta
		//manda info al controller
		
	}
	
//	public FMember chooseFam(Scanner input){
//		System.out.println("I familiari a tua disposizione sono:");
//		System.out.println(this.toString(this.fams));
//		System.out.println("Scegli il familiare.");
//		int choice = input.nextInt();
//		return this.fams.get(choice);
//	}
	
	private void notifyLogMainController(String msg){
		setChanged();
		notifyObservers(new LogMessage(msg));
	}
	
	private void notifyActionMainController(String msg){
		setChanged();
		notifyObservers(new ActionMessage(msg));
	}
	
	private void notifyStatusMainController(String msg){
		setChanged();
		notifyObservers(new StatusMessage(msg));
	}

}
