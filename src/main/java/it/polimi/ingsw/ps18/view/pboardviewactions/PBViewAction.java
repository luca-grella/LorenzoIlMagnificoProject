package it.polimi.ingsw.ps18.view.pboardviewactions;

import java.rmi.RemoteException;

import it.polimi.ingsw.ps18.rmi.ClientInterface;

/**
 * The Interface PBViewAction.
 */
public interface PBViewAction {
	
	/**
	 * Act.
	 *
	 * @param playerClient the player client
	 * @throws RemoteException the remote exception
	 */
	public void act(ClientInterface playerClient) throws RemoteException;

	/**
	 * Sets the index.
	 *
	 * @param number
	 *            the new index
	 */
	public void setIndex(int number);

}
