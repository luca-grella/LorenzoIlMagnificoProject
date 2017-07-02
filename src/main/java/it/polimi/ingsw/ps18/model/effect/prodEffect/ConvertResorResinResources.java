package it.polimi.ingsw.ps18.model.effect.prodEffect;

import java.util.Observable;

import org.json.simple.JSONArray;

import it.polimi.ingsw.ps18.model.effect.generalEffects.WoodorRockEffects;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.messagesandlogs.StatusMessage;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

/**
 * The Class ConvertResorResinResources.
 */
public class ConvertResorResinResources extends Observable implements Converter, WoodorRockEffects {
	
	/**
	 * The name.
	 */
	private String name = "Convert WR in Resources";
	
	/**
	 * The quantity.
	 */
	private int quantity;
	
	/**
	 * The cost.
	 */
	private Stats cost;
	
	/**
	 * The reward.
	 */
	private Stats reward;

	/**
	 * @see it.polimi.ingsw.ps18.model.effect.prodEffect.ProductionEffect#activate(it.polimi.ingsw.ps18.model.personalboard.PBoard, it.polimi.ingsw.ps18.model.gamelogic.GameLogic)
	 */
	@Override
	public void activate(PBoard player, GameLogic game) {
		Stats playerStats = player.getResources();
		playerStats.addStats(reward);
	}
	
	/**
	 * Woodor rock choice.
	 *
	 * @param player
	 *            the player
	 * @param game
	 *            the game
	 */
	public void WoodorRockChoice(PBoard player, GameLogic game){
		addObserver(player.getpBoardView());
		Stats playerStats = player.getResources();
		if(playerStats.getWood() < quantity){
			cost = new Stats(0,quantity,0,0,0,0,0);
			return;
		} else if(playerStats.getRock() < quantity){
			cost = new Stats(quantity,0,0,0,0,0,0);
		} else {
			setChanged();
			game.setOngoingWREffect((WoodorRockEffects) this);
			notifyObservers(new StatusMessage("WoodorRockChoice"));
		}
	}
	
	@Override
	public void continueEffect(int index){
		if(index==1){
			cost = new Stats(quantity,0,0,0,0,0,0);
		} else {
			cost = new Stats(0,quantity,0,0,0,0,0);
		}
	}

	/**
	 * @see it.polimi.ingsw.ps18.model.effect.prodEffect.ProductionEffect#setQuantity(int)
	 */
	@Override
	public void setQuantity(int quantity) {
		this.quantity = quantity;

	}
	
	/**
	 * Sets the stats.
	 *
	 * @param quantity
	 *            the quantity
	 * @param reward
	 *            the reward
	 */
	public void setStats(long quantity, JSONArray reward){
		this.reward = new Stats(reward);
		this.setQuantity((int) quantity);
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("Pay " + this.quantity + "Wood or Rock\n"
                       + "to gain:\n " + this.reward.toStringCost());
		return builder.toString();
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
	 * Gets the quantity.
	 *
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the cost.
	 *
	 * @return the cost
	 */
	@Override
	public Stats getCost() {
		return cost;
	}

	/**
	 * per test, evita l'input utente
	 * @param cost the cost to set
	 */
	public void setCost(Stats cost) {
		this.cost = cost;
	}
	
	

}
