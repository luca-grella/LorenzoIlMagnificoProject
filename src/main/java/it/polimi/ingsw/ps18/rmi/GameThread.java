package it.polimi.ingsw.ps18.rmi;

import java.io.Serializable;
import java.util.LinkedList;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class GameThread extends Thread implements Serializable{
	private boolean timer = true;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	LinkedList<ClientInterface> clients = new LinkedList<>();

	LinkedList<PBoard> players = new LinkedList<>();
	
	boolean canReceivePlayer = true;
	
	public GameThread(LinkedList<ClientInterface> clients){
		this.clients = clients;
		for(int i=0; i<clients.size(); i++){
			PBoard player = new PBoard(i, clients.get(i));
			players.add(player);
		}
	}
	
	public void updateClients(ClientInterface oldclient, ClientInterface newclient){
		for(int i=0; i<players.size(); i++){
			if(players.get(i).getPlayer().equals(oldclient)){
				players.get(i).setPlayer(newclient);
			}
		}
	}
	
	public void addPlayers(ClientInterface client){
		if(canReceivePlayer){
			PBoard player = new PBoard(players.size(), client);
			players.add(player);
		}
	}
	
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
	 * @return the players
	 */
	public LinkedList<PBoard> getPlayers() {
		return players;
	}

	/**
	 * @param timer the timer to set
	 */
	public void setTimer(boolean timer) {
		this.timer = timer;
	}

	/**
	 * @return the clients
	 */
	public LinkedList<ClientInterface> getClients() {
		return clients;
	}
	
	

}
