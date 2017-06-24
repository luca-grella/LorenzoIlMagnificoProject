package it.polimi.ingsw.ps18.model.effect.excommEffects;

import org.json.simple.JSONArray;

import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

// TODO: Auto-generated Javadoc
/**
 * The Class LoseVPforMP.
 */
public class LoseVPforMP implements ExcommEffects {
	
	/**
	 * The name.
	 */
	private String name = "Lose Victory Point for same Military Point";
	
	/**
	 * The has MP.
	 */
	private long hasMP;
	
	/**
	 * The lose VP.
	 */
	private long loseVP;


	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.effect.excommEffects.ExcommEffects#setQuantity(int)
	 */
	@Override
	public void setQuantity(int quantity) {
		return;
	}
	

	/**
	 * Gets the lose VP.
	 *
	 * @return the loseVP
	 */
	public long getLoseVP() {
		return loseVP;
	}

	/**
	 * Sets the lose VP.
	 *
	 * @param loseVP
	 *            the VP to lose
	 */
	public void setLoseVP(long loseVP) {
		this.loseVP = loseVP;
	}

	/**
	 * Gets the boost action value.
	 *
	 * @return the hasMP
	 */
	public long getBoostActionValue() {
		return hasMP;
	}

	/**
	 * Sets the boost action value.
	 *
	 * @param hasMP
	 *            the number of MP every lose VP to set
	 */
	public void setBoostActionValue(long hasMP) {
		this.hasMP = hasMP;
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
	 * Sets the V ex.
	 *
	 * @param hasMP
	 *            the has MP
	 * @param loseVP
	 *            the lose VP
	 */
	public void setVEx(long hasMP, long loseVP) {
		this.hasMP=hasMP;
		this.loseVP=loseVP;
		
		
	}

	
	
}