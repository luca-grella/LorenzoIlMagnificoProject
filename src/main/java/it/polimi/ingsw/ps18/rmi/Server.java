package it.polimi.ingsw.ps18.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * The Class Server.
 */
public class Server {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(1099);
		} catch (RemoteException e) {
			System.out.println("Registry già presente!");	
		}		
		
		try {
			ServerImplementation serverImplementation = new ServerImplementation();
			Naming.rebind("Server", serverImplementation);													  
		} catch (MalformedURLException e) {
			System.err.println("Impossibile registrare l'oggetto indicato!");
		} catch (RemoteException e) {
			System.err.println("Errore di connessione: " + e.getMessage() + "!");
		}		
	}

}
