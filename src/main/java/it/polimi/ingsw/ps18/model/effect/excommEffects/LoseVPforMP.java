package it.polimi.ingsw.ps18.model.effect.excommEffects;

import org.json.simple.JSONArray;

import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

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
	
	
	/**
	 * Activate.
	 *
	 * @param player the player
	 */
	public void activate(PBoard player){
		Stats resources = player.getResources();
		resources.addVP((int) - ((resources.getMP() / hasMP) * loseVP));
	}


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
	 * @param param the new excomm param
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
	 * Gets the checks for MP.
	 *
	 * @return the hasMP
	 */
	public long getHasMP() {
		return hasMP;
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
		return "Lose " + loseVP + " Victory Point for every " + hasMP + " MP that you have.";
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