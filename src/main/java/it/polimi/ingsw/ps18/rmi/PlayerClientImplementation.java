package it.polimi.ingsw.ps18.rmi;

import java.rmi.RemoteException;
import java.util.Scanner;

public class PlayerClientImplementation implements ClientInterface{
	
	
	
	Scanner scanner = new Scanner(System.in);
	private String name;
	
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
	public String chooseName(){
		System.out.println("Inserisci il nome utente.");
		return scanner.nextLine();
	}
	
	/**
	 * @return the name
	 */
	@Override
	public String getName() throws RemoteException{
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	

}
