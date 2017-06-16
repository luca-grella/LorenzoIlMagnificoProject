package it.polimi.ingsw.ps18.model.effect.excommEffects;


import org.json.simple.JSONArray;

import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

public class MalusIncreaseActionValue implements ExcommEffects {
	private String name = "Increase Action Value Reduced";
	private Stats boostactionvalue;
	private Stats cost;


	@Override
	public void setQuantity(int quantity) {
		return;
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
	 * @return the boostactionvalue
	 */
	public Stats getBoostActionValue() {
		return boostactionvalue;
	}

	/**
	 * @param boostactionvalue the increase of action value to set
	 */
	public void setBoostActionValue(Stats boostactionvalue) {
		this.boostactionvalue = boostactionvalue;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	public void setStats(JSONArray boostactionvalue, JSONArray cost){
		this.boostactionvalue = new Stats(boostactionvalue);
		this.cost = new Stats(cost);
	}

	
	
}
