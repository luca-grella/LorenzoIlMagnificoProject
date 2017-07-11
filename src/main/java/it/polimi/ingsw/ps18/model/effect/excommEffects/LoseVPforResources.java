package it.polimi.ingsw.ps18.model.effect.excommEffects;

import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

/**
 * The Class LoseVPforResources.
 */
public class LoseVPforResources implements ExcommEffects {

	
	/**
	 * The lose VP.
	 */
	private int loseVP;
	
	/**
	 * The name.
	 */
	private String name = "LoseVPforResources";
	
	/**
	 * Activate.
	 *
	 * @param player the player
	 */
	public void activate(PBoard player){
		Stats resources = player.getResources();
		int count = 0;
		count += resources.getWood();
		count += resources.getRock();
		count += resources.getCoin();
		count += resources.getServants();
		resources.addVP((int) - (count * loseVP));
	}
	
	
	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.effect.excommEffects.ExcommEffects#setQuantity(int)
	 */
	@Override
	public void setQuantity(int quantity) {
		this.loseVP=quantity;
	}
	
	/**
	 * Gets the lose VP.
	 *
	 * @return the loseVP
	 */
	public int getLoseVP() {
		return loseVP;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		return "Lose " + loseVP + " Victory Point for each resource in your PBoard";
	}

}
