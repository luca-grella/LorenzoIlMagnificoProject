package it.polimi.ingsw.ps18.model.effect.prodEffect;

import org.json.simple.JSONArray;

import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

// TODO: Auto-generated Javadoc
/**
 * The Class ConvertinResources.
 */
public class ConvertinResources implements Converter {
	
	/**
	 * The name.
	 */
	private String name = "Convert in Resources";
	
	/**
	 * The cost.
	 */
	private Stats cost;
	
	/**
	 * The reward.
	 */
	private Stats reward;

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.effect.prodEffect.ProductionEffect#activate(it.polimi.ingsw.ps18.model.personalboard.PBoard, it.polimi.ingsw.ps18.model.gamelogic.GameLogic)
	 */
	@Override
	public void activate(PBoard player, GameLogic game) {
		Stats playerStats = player.getResources();
		playerStats.addStats(reward);
	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.effect.prodEffect.ProductionEffect#setQuantity(int)
	 */
	@Override
	public void setQuantity(int quantity) {
		return;
	}
	
	/**
	 * Sets the stats.
	 *
	 * @param cost
	 *            the cost
	 * @param reward
	 *            the reward
	 */
	public void setStats(JSONArray cost, JSONArray reward){
		this.cost = new Stats(cost);
		this.reward = new Stats(reward);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("Pay:\n" + this.cost.toStringCost()
		               + "to gain:\n " + this.reward.toStringCost());
		return builder.toString();
	}

	/**
	 * Gets the cost.
	 *
	 * @return the cost
	 */
	public Stats getCost() {
		return cost;
	}

	/**
	 * Sets the cost.
	 *
	 * @param cost
	 *            the cost to set
	 */
	public void setCost(Stats cost) {
		this.cost = cost;
	}

	/**
	 * Gets the reward.
	 *
	 * @return the reward
	 */
	public Stats getReward() {
		return reward;
	}

	/**
	 * Sets the reward.
	 *
	 * @param reward
	 *            the reward to set
	 */
	public void setReward(Stats reward) {
		this.reward = reward;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	
	
	

}
