package it.polimi.ingsw.ps18.model.effect.prodEffect;

import org.json.simple.JSONArray;

import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

public class ConvertinResources implements ProductionEffect {
	private Stats cost;
	private Stats reward;

	@Override
	public void activate(PBoard player) {
		
	}

	@Override
	public void setQuantity(int quantity) {
		return;
	}
	
	public void setStats(JSONArray cost, JSONArray reward){
		this.cost = new Stats(cost);
		this.reward = new Stats(reward);
	}

	/**
	 * @return the cost
	 */
	public Stats getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(Stats cost) {
		this.cost = cost;
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

	
	
	

}
