package it.polimi.ingsw.ps18.view;

import java.rmi.RemoteException;
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
import it.polimi.ingsw.ps18.rmi.ClientInterface;
import it.polimi.ingsw.ps18.view.pboardviewactions.HashMapPBVA;
import it.polimi.ingsw.ps18.view.pboardviewactions.PBViewAction;
import it.polimi.ingsw.ps18.view.pboardviewstatus.HashMapPBVS;
import it.polimi.ingsw.ps18.view.pboardviewstatus.PBViewStatus;

/**
 * The Class PBoardView.
 */
public class PBoardView extends Observable implements Observer {
	private ClientInterface playerClient;
	
	/**
	 * Instantiates a new p board view.
	 *
	 * @param mcontroller
	 *            the mcontroller
	 */
	public PBoardView(MainController mcontroller, ClientInterface playerClient){
		this.playerClient = playerClient;
		addObserver(mcontroller);
		HashMapPBVA.init(mcontroller);
		HashMapPBVS.init(mcontroller);
	}
	
	public PBoardView(MainController mcontroller){
		addObserver(mcontroller);
		HashMapPBVA.init(mcontroller);
		HashMapPBVS.init(mcontroller);
	}

	/**
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg){
		Message msg = (Message) arg;
		switch(msg.getID()){
		case 1:
			LogMessage lMessage = (LogMessage) msg;
			try{
				playerClient.notify(lMessage.getMessage()); 
			} catch (RemoteException e) {
				System.out.println("Giocatore Disconnesso.");
				return;
			}
			break;
		case 2:
			ActionMessage aMessage = (ActionMessage) msg;
			PBViewAction action = HashMapPBVA.geteffect(aMessage.getMessage());
			action.setIndex(-1);
			try {
				action.act(playerClient);
			} catch (RemoteException e) {
				System.out.println("Giocatore Disconnesso.");
				return;
			}
			break;
		case 3:
			StatusMessage sMessage = (StatusMessage) msg;
			PBViewStatus statusAction = HashMapPBVS.geteffect(sMessage.getMessage());
			try {
				statusAction.act(playerClient);
			} catch (RemoteException e1) {
				System.out.println("Giocatore Disconnesso.");
				return;
			}
			break;
		case 4:
			ParamMessage pMessage = (ParamMessage) msg;
			PBViewAction ParamAction = HashMapPBVA.geteffect(pMessage.getMessage());
			ParamAction.setIndex(pMessage.getNumber());
			try {
				ParamAction.act(playerClient);
			} catch (RemoteException e) {
				System.out.println("Giocatore Disconnesso.");
				return;
			}
			
		}
	}

}
