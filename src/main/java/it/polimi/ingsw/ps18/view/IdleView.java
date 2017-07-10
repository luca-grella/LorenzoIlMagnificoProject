package it.polimi.ingsw.ps18.view;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messagesandlogs.ActionMessage;
import it.polimi.ingsw.ps18.model.messagesandlogs.LogMessage;
import it.polimi.ingsw.ps18.model.messagesandlogs.Message;
import it.polimi.ingsw.ps18.model.messagesandlogs.StatusMessage;
import it.polimi.ingsw.ps18.model.messagesandlogs.StatusParamMessage;
import it.polimi.ingsw.ps18.rmi.ClientInterface;
import it.polimi.ingsw.ps18.view.pboardviewstatus.HashMapPBVS;
import it.polimi.ingsw.ps18.view.pboardviewstatus.PBViewStatus;

public class IdleView extends Observable{
	private ClientInterface playerClient;
	private int playercol;

	public IdleView(MainController controller, ClientInterface playerClient, int playercol) {
		addObserver(controller);
		HashMapPBVS.init(controller);
		this.playercol = playercol;
		this.playerClient = playerClient;
	}
	
	public void init(){
		int ans = -1;
		StringBuilder builder = new StringBuilder();
		builder.append("Choose an action:\n");
		builder.append("1. Visualize Towers.\n");
		builder.append("2. Visualize Market.\n");
		builder.append("3. Visualize Council.\n");
		builder.append("4. Visualize Harvest.\n");
		builder.append("5. Visualize Production.\n");
		builder.append("6. Visualize Player Board.\n");
		builder.append("7. Visualize the Excommunications in Game.\n");
		try {
			playerClient.notify(builder.toString());
			ans = playerClient.read();
		} catch (RemoteException e) {
			System.out.println("\n[PBVAInit] Error\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		switch (ans){
		case 1:
			notifyStatusParamMainController("Show Towers Zoom",playercol,-1);
			break;
		case 2:
			notifyStatusParamMainController("Show Market",playercol,-1);
			break;
		case 3:
			notifyStatusParamMainController("Show Council",playercol,-1);
			break;
		case 4:
			notifyStatusParamMainController("Show Harvest",playercol,-1);
			break;
		case 5:
			notifyStatusParamMainController("Show Production",playercol,-1);
			break;
		case 6:
			notifyStatusParamMainController("Show Player",playercol,-1);
			break;
		case 7:
			notifyStatusParamMainController("Show Excomm",playercol,-1);
			break;
		}
	}
	
	/**
	 * Notify status main controller.
	 *
	 * @param msg
	 *            the msg
	 */
	private void notifyStatusParamMainController(String msg, int color, int index){
		setChanged();
		notifyObservers(new StatusParamMessage(msg,color,index));
	}

	/**
	 * @return the playerClient
	 */
	public ClientInterface getPlayerClient() {
		return playerClient;
	}
	
	

}
