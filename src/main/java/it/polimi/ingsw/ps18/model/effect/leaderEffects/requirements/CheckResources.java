package it.polimi.ingsw.ps18.model.effect.leaderEffects.requirements;

import org.json.simple.JSONArray;

import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

/**
 * The Class CheckResources.
 */
public class CheckResources implements LCRequirement {
	
	/** The minimum. */
	private Stats minimum;

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.effect.leaderEffects.requirements.LCRequirement#checkRequirement(it.polimi.ingsw.ps18.model.personalboard.PBoard)
	 */
	@Override
	public boolean checkRequirement(PBoard player) {
		return player.getResources().enoughStats(minimum);
	}

	/**
	 * Sets the param.
	 *
	 * @param minimum the new param
	 */
	public void setParam(JSONArray minimum) {
		this.minimum = new Stats(minimum);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		return "You need to have at least: \n" + this.minimum.toStringCost();
	}

	/**
	 * Gets the param.
	 *
	 * @return the param
	 */
	public Stats getParam() {
		
		return minimum;
	}

}
