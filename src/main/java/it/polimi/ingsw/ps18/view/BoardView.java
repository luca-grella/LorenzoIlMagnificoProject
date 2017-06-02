package it.polimi.ingsw.ps18.view;

import java.util.Observable;
import java.util.Observer;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messages.LogMessage;
import it.polimi.ingsw.ps18.model.messages.Message;

public class BoardView extends Observable implements Observer{

	public BoardView(MainController mcontroller) {
		addObserver(mcontroller);
	}

	@Override
	public void update(Observable o, Object arg) {
		Message msg = (Message) arg;
		switch(msg.getID()){
		case 1:
			LogMessage message = (LogMessage) msg;
			System.out.println(message.getMessage()); 
		
		}
	}

}
