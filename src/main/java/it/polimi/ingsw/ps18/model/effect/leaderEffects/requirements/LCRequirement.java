package it.polimi.ingsw.ps18.model.effect.leaderEffects.requirements;

import it.polimi.ingsw.ps18.model.personalboard.PBoard;

/**
 * The Interface LCRequirement.
 */
public interface LCRequirement {
	
	/**
	 * Check requirement.
	 *
	 * @param player the player
	 * @return true, if successful
	 */
	public boolean checkRequirement(PBoard player);
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString();

}
