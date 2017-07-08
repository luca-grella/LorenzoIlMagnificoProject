package it.polimi.ingsw.ps18.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public interface ClientInterface extends Remote {
	
	public void notify(String object) throws RemoteException;
	
}
