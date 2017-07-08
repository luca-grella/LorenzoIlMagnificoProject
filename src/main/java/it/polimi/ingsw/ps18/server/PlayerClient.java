package it.polimi.ingsw.ps18.server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class PlayerClient {
	public static void main(String[] args) {
		ServerInterface server;
		try {
			
			server = (ServerInterface)Naming.lookup("//localhost/Server");	//Ottengo il riferimento remoto associato alla stringa passata (contiene l'host target e l'identificativo dell'oggetto sull'host).	
			PlayerClientImplementation client = new PlayerClientImplementation();	//Creo l'oggetto client normalmente.
			ClientInterface remoteRef = (ClientInterface) UnicastRemoteObject.exportObject(client, 0);	 //Tuttavia, dato che ClientImplementation non estende la classe UnicastRemoteObject, devo creare un riferimento remoto
																 //In questo caso non devo associare un identificativo all'oggetto (in quanto il riferimento remoto verrà passato al server).
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
