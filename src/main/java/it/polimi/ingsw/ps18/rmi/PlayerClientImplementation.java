package it.polimi.ingsw.ps18.rmi;

import java.rmi.RemoteException;
import java.util.Scanner;

public class PlayerClientImplementation implements ClientInterface{
	Scanner scanner = new Scanner(System.in);
	
	@Override
	public void notify(String object) throws RemoteException {
		System.out.println(object);
	}

	@Override
	public int read() throws RemoteException {
		while (!scanner.hasNextInt()) 
	    	scanner.next();
		int input = scanner.nextInt();
		return input;
	}
	
	
	
	@Override
	public void closeScanner(){
//		
	}

}
