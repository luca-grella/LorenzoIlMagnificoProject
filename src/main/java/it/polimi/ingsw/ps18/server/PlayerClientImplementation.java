package it.polimi.ingsw.ps18.server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class PlayerClientImplementation implements ClientInterface{
	
	@Override
	public void notify(String object) throws RemoteException {
		System.out.println(object);
	}

}
