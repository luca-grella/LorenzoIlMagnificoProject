package it.polimi.ingsw.ps18.view;

import java.util.Observable;
import java.util.Observer;

import it.polimi.ingsw.ps18.controller.MainController;

public class PBoardView extends Observable implements Observer {
	
	public PBoardView(MainController mcontroller){
		addObserver(mcontroller);
	}

	@Override
	public void update(Observable o, Object arg) {
		String msg = (String) arg;
		System.out.println(msg);
		
	}

}
