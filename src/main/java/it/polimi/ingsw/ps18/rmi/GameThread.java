package it.polimi.ingsw.ps18.rmi;

import java.io.Serializable;
import java.util.LinkedList;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class GameThread extends Thread implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	LinkedList<PBoard> players = new LinkedList<>();
	
	boolean canReceivePlayer = true;
	
	public GameThread(LinkedList<ClientInterface> clients){
		for(int i=0; i<clients.size(); i++){
			PBoard player = new PBoard(i, clients.get(i));
			players.add(player);
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
		try {
			sleep(120000);
		} catch (InterruptedException e) {
			System.out.println("Raggiunti i 4 giocatori, inizio della partita.");
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
		try {
			if(players.size()!=4){
				sleep(120000);
			}
		} catch (InterruptedException e) {
			System.out.println("\n[GameThread] Error\n");
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
	
	

}
