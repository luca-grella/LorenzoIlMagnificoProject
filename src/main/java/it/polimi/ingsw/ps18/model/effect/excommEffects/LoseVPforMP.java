package it.polimi.ingsw.ps18.model.effect.excommEffects;

import org.json.simple.JSONArray;

/**
 * The Class LoseVPforMP.
 */
public class LoseVPforMP implements ExcommEffects {
	
	/**
	 * The name.
	 */
	private String name = "LoseVPforMP";
	
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
	 * Sets the Parameters.
	 *
	 * @param hasMP
	 *            the has MP
	 * @param loseVP
	 *            the lose VP
	 */
	public void setExcommParam(JSONArray param) {
		this.hasMP= (long) param.get(0);
		this.loseVP= (long) param.get(1);
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
	 * @return the hasMP
	 */
	public long getHasMP() {
		return hasMP;
	}

	/**
	 * @return the loseVP
	 */
	public long getLoseVP() {
		return loseVP;
	}
	
	

	

	
	
}