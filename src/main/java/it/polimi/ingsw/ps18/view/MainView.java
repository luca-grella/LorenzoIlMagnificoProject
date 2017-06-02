package it.polimi.ingsw.ps18.view;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import it.polimi.ingsw.ps18.controller.MainController;

public class MainView extends Observable  implements Observer{
	Scanner input = new Scanner(System.in);
	MainController controller;
	
	public MainView(MainController controller2){
		controller = controller2;
		addObserver(controller);
	}

	@Override
	public void update(Observable o, Object arg) {
		String msg = (String) arg;
		System.out.println(msg);
		
	}
	

}
