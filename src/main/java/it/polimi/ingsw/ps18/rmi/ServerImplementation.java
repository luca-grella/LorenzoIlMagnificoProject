package it.polimi.ingsw.ps18.rmi;

import java.rmi.ConnectException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class ServerImplementation extends UnicastRemoteObject implements ServerInterface {
	
	private LinkedList<PBoard> players = new LinkedList<>();
	
	int counter=0;

	protected ServerImplementation() throws RemoteException {
		super(0);
	}

	private static final long serialVersionUID = -7098548671967083832L;

	@Override
	public void addClient(ClientInterface client) throws RemoteException {
		PBoard player = new PBoard(counter,client);
		counter++;
		players.add(player);
		if(players.size() == 2){
			game();
		}
		
	}
	
	public void game(){
		MainController controller = new MainController();
		controller.startGame(players.size(), players);
	}

}
