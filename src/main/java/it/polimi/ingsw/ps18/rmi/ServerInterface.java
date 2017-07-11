package it.polimi.ingsw.ps18.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * The Interface ServerInterface.
 */
/*
 * IMPORTANTE:
 * L'interfaccia che definisce la classe da esportare deve:
 * - Estendere l'interfaccia Remote
 * - Tutti i metodi devono essere pubblici e lanciare l'eccezione RemoteException
 */
public interface ServerInterface extends Remote {	
	
	/**
	 * Adds the client.
	 *
	 * @param client the client
	 * @throws RemoteException the remote exception
	 */
	public void addClient(ClientInterface client) throws RemoteException;

}