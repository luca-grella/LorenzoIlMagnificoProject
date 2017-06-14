package it.polimi.ingsw.ps18.model.effect.prodEffect;

import java.util.Observable;

import org.json.simple.JSONArray;

import it.polimi.ingsw.ps18.model.messages.StatusMessage;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

public class ConvertResorResinResources extends Observable implements ProductionEffect {
	private int quantity;
	private Stats reward;

	@Override
	public void activate(PBoard player) {
		addObserver(player.getpBoardView());
		Stats playerStats = player.getResources();
		if(playerStats.getWood() < quantity){
			Stats cost = new Stats(0,quantity,0,0,0,0,0);
			playerStats.subStats(cost);
			playerStats.addStats(reward);
			return;
		} else if(playerStats.getRock() < quantity){
			Stats cost = new Stats(quantity,0,0,0,0,0,0);
			playerStats.subStats(cost);
			playerStats.addStats(reward);
		} else {
			setChanged();
			notifyObservers(new StatusMessage("WoodorRockChoice"));
		}
	}
	
	public void pay(PBoard player, int index){
		Stats playerStats = player.getResources();
		if(index==1){
			Stats cost = new Stats(quantity,0,0,0,0,0,0);
			playerStats.subStats(cost);
			playerStats.addStats(reward);
		} else {
			Stats cost = new Stats(0,quantity,0,0,0,0,0);
			playerStats.subStats(cost);
			playerStats.addStats(reward);
		}
	}

	@Override
	public void setQuantity(int quantity) {
		this.quantity = quantity;

	}
	
	public void setStats(long quantity, JSONArray reward){
		this.reward = new Stats(reward);
		this.setQuantity((int) quantity);
	}

	/**
	 * @return the reward
	 */
	public Stats getReward() {
		return reward;
	}

	/**
	 * @param reward the reward to set
	 */
	public void setReward(Stats reward) {
		this.reward = reward;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	
	

}
