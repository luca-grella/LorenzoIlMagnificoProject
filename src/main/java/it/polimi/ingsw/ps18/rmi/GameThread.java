package it.polimi.ingsw.ps18.rmi;

import java.awt.List;
import java.io.Serializable;
import java.util.LinkedList;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class GameThread extends Thread implements Serializable{

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
		    Thread.currentThread().interrupt();
		}
		canReceivePlayer = false;
		MainController game = new MainController();
		game.startGame(players.size(), players);
	}

	/**
	 * @return the players
	 */
	public LinkedList<PBoard> getPlayers() {
		return players;
	}
	
	

}
