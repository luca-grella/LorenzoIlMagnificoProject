package it.polimi.ingsw.ps18.view;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messages.ActionMessage;
import it.polimi.ingsw.ps18.model.messages.LogMessage;
import it.polimi.ingsw.ps18.model.messages.Message;
import it.polimi.ingsw.ps18.view.pboardviewactions.HashMapPBVA;
import it.polimi.ingsw.ps18.view.pboardviewactions.PBViewAction;

public class PBoardView extends Observable implements Observer {
	Scanner input = new Scanner(System.in);
	
	public PBoardView(MainController mcontroller){
		addObserver(mcontroller);
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
//			PBViewAction action = HashMapPBVA.geteffect(aMessage.getMessage());
			if("Init Player Turn".equals(aMessage.getMessage())){
				System.out.println("Ciao");
				String ris = input.nextLine();
			}
			
		}
	}

}
