package it.polimi.ingsw.ps18.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class PlayerClient {
	public static void main(String[] args) {
		ServerInterface server;
		try {
			
			server = (ServerInterface)Naming.lookup("//localhost/Server");	
			PlayerClientImplementation client = new PlayerClientImplementation();
			ClientInterface remoteRef = (ClientInterface) UnicastRemoteObject.exportObject(client, 0);
			server.addClient(remoteRef);
			
		} catch (MalformedURLException e) {
			System.err.println("URL non trovato!");
		} catch (RemoteException e) {
			System.err.println("Errore di connessione: " + e.getMessage() + "!");
		} catch (NotBoundException e) {
			System.err.println("Il riferimento passato non è associato a nulla!");
		}
	}

}
