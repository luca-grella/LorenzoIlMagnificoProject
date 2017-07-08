package it.polimi.ingsw.ps18.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/*
 * IMPORTANTE:
 * L'interfaccia che definisce la classe da esportare deve:
 * - Estendere l'interfaccia Remote
 * - Tutti i metodi devono essere pubblici e lanciare l'eccezione RemoteException
 */
public interface ServerInterface extends Remote {	
	
	public void addClient(ClientInterface client) throws RemoteException;

}