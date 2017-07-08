package it.polimi.ingsw.ps18.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public interface ClientInterface extends Remote {
	
	public void notify(String object) throws RemoteException;
	
	public int read() throws RemoteException;
	
}
