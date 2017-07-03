package it.polimi.ingsw.ps18.model.effect.excommEffects;

import org.json.simple.JSONArray;

/**
 * The Class LoseVPforVP.
 */
public class LoseVPforVP implements ExcommEffects {
	
	/**
	 * The name.
	 */
	private String name = "LoseVPforVP";
	
	/**
	 * The has VP.
	 */
	private long hasVP;
	
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
	
	public void setExcommParam(JSONArray param) {
		this.hasVP = (long) param.get(0);
		this.loseVP = (long) param.get(1);
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
	 * @return the hasVP
	 */
	public long getHasVP() {
		return hasVP;
	}

	/**
	 * @return the loseVP
	 */
	public long getLoseVP() {
		return loseVP;
	}

	@Override
	public String toString(){
		return "Lose " + loseVP + " Victory Point for every " + hasVP + " VP that you have.";
	}
	
	


	
	

	
}