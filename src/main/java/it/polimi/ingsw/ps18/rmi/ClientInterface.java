package it.polimi.ingsw.ps18.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * The Interface ClientInterface.
 */
public interface ClientInterface extends Remote {
	
	/**
	 * Notify.
	 *
	 * @param object the object
	 * @throws RemoteException the remote exception
	 */
	public void notify(String object) throws RemoteException;
	
	/**
	 * Read.
	 *
	 * @return the int
	 * @throws RemoteException the remote exception
	 */
	public int read() throws RemoteException;
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 * @throws RemoteException the remote exception
	 */
	public String getName() throws RemoteException;

	/**
	 * Choose name.
	 *
	 * @return the string
	 * @throws RemoteException the remote exception
	 */
	String chooseName() throws RemoteException;
	
}
