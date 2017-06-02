package it.polimi.ingsw.ps18.view;

import java.util.Observable;
import java.util.Observer;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messages.ActionMessage;
import it.polimi.ingsw.ps18.model.messages.LogMessage;
import it.polimi.ingsw.ps18.model.messages.Message;

public class MainView extends Observable  implements Observer{
	MainController controller;
	
	public MainView(MainController controller2){
		controller = controller2;
		addObserver(controller);
	}

	@Override
	public void update(Observable o, Object arg) {
		Message msg = (Message) arg;
		switch(msg.getID()){
		case 1:
			LogMessage lMessage = (LogMessage) msg;
			System.out.println(lMessage.getMessage());
			break;
		case 2:
			ActionMessage aMessage = (ActionMessage) msg;
			setChanged();
			notifyObservers(aMessage);
			break;
		}
	}
	

}
