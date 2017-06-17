package it.polimi.ingsw.ps18.model.effect.excommEffects;

import org.json.simple.JSONArray;

import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

public class LoseVPforMP implements ExcommEffects {
	private String name = "Lose Victory Point for same Military Point";
	private long hasMP;
	private long loseVP;


	@Override
	public void setQuantity(int quantity) {
		return;
	}
	

	/**
	 * @return the loseVP
	 */
	public long getLoseVP() {
		return loseVP;
	}

	/**
	 * @param loseVP the VP to lose
	 */
	public void setLoseVP(long loseVP) {
		this.loseVP = loseVP;
	}

	/**
	 * @return the hasMP
	 */
	public long getBoostActionValue() {
		return hasMP;
	}

	/**
	 * @param hasMP the number of MP every lose VP to set
	 */
	public void setBoostActionValue(long hasMP) {
		this.hasMP = hasMP;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	public void setVEx(long hasMP, long loseVP) {
		this.hasMP=hasMP;
		this.loseVP=loseVP;
		
		
	}

	
	
}