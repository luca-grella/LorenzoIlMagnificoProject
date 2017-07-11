package it.polimi.ingsw.ps18.view.pboardviewstatus;

import java.rmi.RemoteException;

import it.polimi.ingsw.ps18.rmi.ClientInterface;

/**
 * The Interface PBViewStatus.
 */
public interface PBViewStatus {
	
	
	/**
	 * Act.
	 *
	 * @param playerClient the player client
	 * @throws RemoteException the remote exception
	 */
	public void act(ClientInterface playerClient)  throws RemoteException;

}
