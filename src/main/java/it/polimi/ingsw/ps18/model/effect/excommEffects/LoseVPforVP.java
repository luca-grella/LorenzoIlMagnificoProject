package it.polimi.ingsw.ps18.model.effect.excommEffects;

import org.json.simple.JSONArray;

import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

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

	
	/**
	 * Activate.
	 *
	 * @param player the player
	 */
	public void activate(PBoard player){
		Stats resources = player.getResources();
		resources.addVP((int) - ((resources.getVP() / hasVP) * loseVP));
	}
	
	
	

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.effect.excommEffects.ExcommEffects#setQuantity(int)
	 */
	@Override
	public void setQuantity(int quantity) {
		return;
	}
	
	/**
	 * Sets the excomm param.
	 *
	 * @param param the new excomm param
	 */
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
	 * Gets the checks for VP.
	 *
	 * @return the hasVP
	 */
	public long getHasVP() {
		return hasVP;
	}

	/**
	 * Gets the lose VP.
	 *
	 * @return the loseVP
	 */
	public long getLoseVP() {
		return loseVP;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		return "Lose " + loseVP + " Victory Point for every " + hasVP + " VP that you have.";
	}




	/**
	 * Gets the quantity.
	 *
	 * @param quantity the quantity
	 * @return the quantity
	 */
	public int getQuantity(int quantity) {
		return quantity;
		
	}
	
	


	
	

	
}