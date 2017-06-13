package it.polimi.ingsw.ps18.model.effect.prodEffect;

import org.json.simple.JSONArray;

import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

public class ConvertinPC implements ProductionEffect {
	private Stats cost;
	private int quantity;

	@Override
	public void activate(PBoard player) {

	}

	@Override
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void setStats(JSONArray cost, long quantity){
		this.cost = new Stats(cost);
		this.setQuantity((int) quantity);
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
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	
	

}
