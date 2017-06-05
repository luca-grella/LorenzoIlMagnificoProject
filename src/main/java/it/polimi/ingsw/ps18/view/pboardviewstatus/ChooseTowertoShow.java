package it.polimi.ingsw.ps18.view.pboardviewstatus;

import java.util.Observable;
import java.util.Scanner;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.view.pboardviewactions.PBViewAction;

public class ChooseTowertoShow extends Observable implements PBViewStatus {
	Scanner input = new Scanner(System.in);

	@Override
	public void setObserver(MainController controller) {
		addObserver(controller);

	}

	@Override
	public void act() {
		

	}

}
