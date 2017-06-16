package it.polimi.ingsw.ps18.model.effect.excommEffects;

import org.json.simple.JSONArray;

import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

public class LoseVPforVP implements ExcommEffects {
	private String name = "Lose Victory Point for same Victory Point";
	private Stats hasVP;
	private Stats loseVP;


	@Override
	public void setQuantity(int quantity) {
		return;
	}
	

	/**
	 * @return the loseVP
	 */
	public Stats getLoseVP() {
		return loseVP;
	}

	/**
	 * @param loseVP the VP to lose
	 */
	public void setLoseVP(Stats loseVP) {
		this.loseVP = loseVP;
	}

	/**
	 * @return the hasVP
	 */
	public Stats getBoostActionValue() {
		return hasVP;
	}

	/**
	 * @param hasVP the number of VP every lose VP to set
	 */
	public void setBoostActionValue(Stats hasVP) {
		this.hasVP = hasVP;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	public void setStats(JSONArray hasVP, JSONArray loseVP){
		this.hasVP = new Stats(hasVP);
		this.loseVP = new Stats(loseVP);
	}

	
	
}