package it.polimi.ingsw.ps18.rmi;

import java.rmi.RemoteException;
import java.util.Scanner;

/**
 * The Class PlayerClientImplementation.
 */
public class PlayerClientImplementation implements ClientInterface{
	
	
	
	/** The scanner. */
	Scanner scanner = new Scanner(System.in);
	
	/** The name. */
	private String name;
	
	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.rmi.ClientInterface#notify(java.lang.String)
	 */
	@Override
	public void notify(String object) throws RemoteException {
		System.out.println(object);
	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.rmi.ClientInterface#read()
	 */
	@Override
	public int read() throws RemoteException {
		while (!scanner.hasNextInt()) 
	    	scanner.next();
		int input = scanner.nextInt();
		return input;
	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.rmi.ClientInterface#chooseName()
	 */
	@Override
	public String chooseName(){
		System.out.println("Inserisci il nome utente.");
		return scanner.nextLine();
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 * @throws RemoteException the remote exception
	 */
	@Override
	public String getName() throws RemoteException{
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	

}
