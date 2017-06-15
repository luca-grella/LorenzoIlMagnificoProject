package it.polimi.ingsw.ps18.model.effect.prodEffect;

import java.util.Observable;

import org.json.simple.JSONArray;

import it.polimi.ingsw.ps18.model.messages.StatusMessage;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

public class ConvertResorResinResources extends Observable implements Converter {
	private String name = "Convert WR in Resources";
	private int quantity;
	private Stats cost;
	private Stats reward;

	@Override
	public void activate(PBoard player) {
		Stats playerStats = player.getResources();
		playerStats.addStats(reward);
	}
	
	public void WoodorRockChoice(PBoard player){
		addObserver(player.getpBoardView());
		Stats playerStats = player.getResources();
		if(playerStats.getWood() < quantity){
			cost = new Stats(0,quantity,0,0,0,0,0);
			return;
		} else if(playerStats.getRock() < quantity){
			cost = new Stats(quantity,0,0,0,0,0,0);
		} else {
			setChanged();
			notifyObservers(new StatusMessage("WoodorRockChoice"));
		}
	}
	
	public void pay(PBoard player, int index){
		if(index==1){
			cost = new Stats(quantity,0,0,0,0,0,0);
		} else {
			cost = new Stats(0,quantity,0,0,0,0,0);
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

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the cost
	 */
	@Override
	public Stats getCost() {
		return cost;
	}
	
	

}
