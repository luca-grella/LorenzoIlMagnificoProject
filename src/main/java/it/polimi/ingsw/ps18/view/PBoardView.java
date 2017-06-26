package it.polimi.ingsw.ps18.view;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.controller.controlleractions.HashMapActions;
import it.polimi.ingsw.ps18.model.messagesandlogs.ActionMessage;
import it.polimi.ingsw.ps18.model.messagesandlogs.LogMessage;
import it.polimi.ingsw.ps18.model.messagesandlogs.Message;
import it.polimi.ingsw.ps18.model.messagesandlogs.ParamMessage;
import it.polimi.ingsw.ps18.model.messagesandlogs.StatusMessage;
import it.polimi.ingsw.ps18.view.pboardviewactions.HashMapPBVA;
import it.polimi.ingsw.ps18.view.pboardviewactions.PBViewAction;
import it.polimi.ingsw.ps18.view.pboardviewstatus.HashMapPBVS;
import it.polimi.ingsw.ps18.view.pboardviewstatus.PBViewStatus;

// TODO: Auto-generated Javadoc
/**
 * The Class PBoardView.
 */
public class PBoardView extends Observable implements Observer {
	
	/**
	 * The controller.
	 */
	MainController controller;
	private int a;
	
	/**
	 * Instantiates a new p board view.
	 *
	 * @param mcontroller
	 *            the mcontroller
	 */
	public PBoardView(MainController mcontroller){
		this.controller = mcontroller;
		addObserver(controller);
		HashMapPBVA.init();
		HashMapPBVS.init();
	}

	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
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
		case 3:
			StatusMessage sMessage = (StatusMessage) msg;
			PBViewStatus statusAction = HashMapPBVS.geteffect(sMessage.getMessage());
			statusAction.setObserver(controller);
			statusAction.act();
			break;
		case 4:
			ParamMessage pMessage = (ParamMessage) msg;
			PBViewAction ParamAction = HashMapPBVA.geteffect(pMessage.getMessage());
			ParamAction.setObserver(controller);
			ParamAction.setIndex(pMessage.getNumber());
			ParamAction.act();
			
		}
	}
	
	/**
	 * 
	 *Per test
	 * @return 
	 */
	
	public PBoardView(int b){
		
		b = 1;
		this.a = b;
		
	};

}
