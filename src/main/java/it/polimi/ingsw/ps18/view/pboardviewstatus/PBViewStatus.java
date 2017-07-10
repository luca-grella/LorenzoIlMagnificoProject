package it.polimi.ingsw.ps18.view.pboardviewstatus;

import java.rmi.RemoteException;

import it.polimi.ingsw.ps18.rmi.ClientInterface;

/**
 * The Interface PBViewStatus.
 */
public interface PBViewStatus {
	
	
	/**
	 * Act.
	 */
	public void act(ClientInterface playerClient)  throws RemoteException;

}
