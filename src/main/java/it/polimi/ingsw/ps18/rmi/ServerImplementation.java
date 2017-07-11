package it.polimi.ingsw.ps18.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ServerImplementation extends UnicastRemoteObject implements ServerInterface {
	
	private LinkedList<ClientInterface> players = new LinkedList<>();
	
	private List<GameThread> lobbies = new ArrayList<>();
	
	private HashMap<String,ClientInterface> users = new HashMap<>();
	
	protected ServerImplementation() throws RemoteException {
		super(0);
	}

	private static final long serialVersionUID = -7098548671967083832L;

	@Override
	public void addClient(ClientInterface client) throws RemoteException {
		players.add(client);
		if(insertInHashMap(client)){
			insertPlayer(client);
			generateLobby();
		} else {
			return;
		}
		
	}
	
	private boolean insertInHashMap(ClientInterface client){
		String name;
		try {
			name = (String) client.getName();
		} catch (RemoteException e) {
			System.out.println("\n[ServerImplementation] Error\n");
			return false;
		}
		if(! users.containsKey(name)){
			users.put(name, client);
			//il giocatore non ha mai fatto un accesso quindi viene inserito
			return true;
		} else {
			ClientInterface oldClient = users.get(name);
			for(GameThread game: lobbies){
				if(game.getClients().contains(oldClient)){
					game.updateClients(client);
				}
			}
			//giocatore presente, setta il nuovo client
			return false;
		}
	}
	
	
	private void insertPlayer(ClientInterface client){
		for(GameThread lobby: lobbies){
			if(lobby.getPlayers().size() < 4){
				lobby.addPlayers(client);
				players.remove(client);
				if(lobby.getPlayers().size()==4){
					lobby.setTimer(false);;
				}
				return;
			}
		}
	}
	
	private synchronized void generateLobby(){
		LinkedList<ClientInterface> tobePassed = new LinkedList<>();
		if(players.size()>=2){
			if(players.size()<4){
				for(int i=players.size()-1; i>=0; i--){
					ClientInterface temp = new PlayerClientImplementation();
					temp = players.get(i);
					tobePassed.add(temp);
					players.remove(temp);
				}
			} else {
				for(int i=3; i>=0; i--){
					ClientInterface temp = new PlayerClientImplementation();
					temp = players.get(i);
					tobePassed.add(temp);
					players.remove(temp);
				}
			}
		}
		if(tobePassed.size()>=2 && tobePassed.size()<4){
			GameThread gamethread = new GameThread(tobePassed);
			this.lobbies.add(gamethread);
			gamethread.start();
		}
		
	}
}
