package it.polimi.ingsw.ps18.view;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.controller.controlleractions.HashMapActions;
import it.polimi.ingsw.ps18.model.messages.ActionMessage;
import it.polimi.ingsw.ps18.model.messages.LogMessage;
import it.polimi.ingsw.ps18.model.messages.Message;
import it.polimi.ingsw.ps18.model.messages.ParamMessage;
import it.polimi.ingsw.ps18.view.pboardviewactions.HashMapPBVA;
import it.polimi.ingsw.ps18.view.pboardviewactions.PBViewAction;

public class PBoardView extends Observable implements Observer {
	Scanner input = new Scanner(System.in);
	MainController controller;
	
	public PBoardView(MainController mcontroller){
		this.controller = mcontroller;
		addObserver(controller);
		HashMapPBVA.init();
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
			PBViewAction action = HashMapPBVA.geteffect(aMessage.getMessage());
			action.setObserver(controller);
			action.act();
			break;
		case 4:
			ParamMessage pMessage = (ParamMessage) msg;
			PBViewAction ParamAction = HashMapPBVA.geteffect(pMessage.getMessage());
			ParamAction.setIndex(pMessage.getNumber());
			ParamAction.act();
			
		}
	}

}
