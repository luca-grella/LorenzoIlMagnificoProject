package it.polimi.ingsw.ps18.rmi;

import java.io.Serializable;
import java.util.LinkedList;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

/**
 * The Class GameThread.
 */
public class GameThread extends Thread implements Serializable{
	
	/** The timer. */
	private boolean timer = true;
//	private MainController game;

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The clients. */
	LinkedList<ClientInterface> clients = new LinkedList<>();

	/** The players. */
	LinkedList<PBoard> players = new LinkedList<>();
	
	/** The can receive player. */
	boolean canReceivePlayer = true;
	
	/**
	 * Instantiates a new game thread.
	 *
	 * @param clients the clients
	 */
	public GameThread(LinkedList<ClientInterface> clients){
		this.clients = clients;
		for(int i=0; i<clients.size(); i++){
			PBoard player = new PBoard(i, clients.get(i));
			players.add(player);
		}
	}
	
	/**
	 * Update clients.
	 *
	 * @param newclient the newclient
	 */
	public void updateClients(ClientInterface newclient){
//		game.updateClient(newclient);
	}
	
	/**
	 * Adds the players.
	 *
	 * @param client the client
	 */
	public void addPlayers(ClientInterface client){
		if(canReceivePlayer){
			PBoard player = new PBoard(players.size(), client);
			players.add(player);
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run(){
		int counter = 0;
		timer=true;
		while(timer){
			try {
				if(counter<120){
					sleep(1000);
				}
				if(counter>=120){
					timer = false;
				}
				counter++;
			} catch (InterruptedException e) {
				System.out.println("\n[GameThread] Error\n");
				Thread.currentThread().interrupt();
			}
		}
		canReceivePlayer = false;
		MainController game = new MainController();
		LinkedList<ClientInterface> newplayers = game.startGame(players.size(), players);
		if(! newplayers.isEmpty()){
			this.players.clear();
			for(int i=0; i<newplayers.size(); i++){
				PBoard player = new PBoard(i, newplayers.get(i));
				players.add(player);
			}
			runagain();
		} else {
			return;
		}
	}
	
	/**
	 * Runagain.
	 */
	public void runagain(){
		canReceivePlayer = true;
		int counter = 0;
		timer=true;
		while(timer){
			try {
				if(counter<120){
					if(players.size()!=4){
						sleep(1000);
					}
					if(counter>=120){
						timer = false;
					}
				}
				counter++;
			} catch (InterruptedException e) {
				System.out.println("\n[GameThread] Error\n");
				Thread.currentThread().interrupt();
			}
		}
		canReceivePlayer = false;
		MainController game = new MainController();
		LinkedList<ClientInterface> newplayers = game.startGame(players.size(), players);
		if(! newplayers.isEmpty()){
			this.players.clear();
			for(int i=0; i<newplayers.size(); i++){
				PBoard player = new PBoard(i, newplayers.get(i));
				players.add(player);
			}
			runagain();
		} else {
			return;
		}
	}

	/**
	 * Gets the players.
	 *
	 * @return the players
	 */
	public LinkedList<PBoard> getPlayers() {
		return players;
	}

	/**
	 * Sets the timer.
	 *
	 * @param timer the timer to set
	 */
	public void setTimer(boolean timer) {
		this.timer = timer;
	}

	/**
	 * Gets the clients.
	 *
	 * @return the clients
	 */
	public LinkedList<ClientInterface> getClients() {
		return clients;
	}
	
	

}
