package it.polimi.ingsw.ps18.model.effect.prodEffect;

import org.json.simple.JSONArray;

import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

public class ConvertResorResinResources implements ProductionEffect {
	private int quantity;
	private Stats reward;

	@Override
	public void activate(PBoard player) {

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
