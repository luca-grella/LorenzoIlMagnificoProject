package it.polimi.ingsw.ps18.model.effect.excommEffects;

import org.json.simple.JSONArray;

import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

public class LoseVPforMP implements ExcommEffects {
	private String name = "Lose Victory Point for same Military Point";
	private Stats hasMP;
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
	 * @return the hasMP
	 */
	public Stats getBoostActionValue() {
		return hasMP;
	}

	/**
	 * @param hasMP the number of MP every lose VP to set
	 */
	public void setBoostActionValue(Stats hasMP) {
		this.hasMP = hasMP;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	public void setStats(JSONArray hasMP, JSONArray loseVP){
		this.hasMP = new Stats(hasMP);
		this.loseVP = new Stats(loseVP);
	}

	
	
}