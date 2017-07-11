package it.polimi.ingsw.ps18.model.effect.leaderEffects.quickeffects;

import org.json.simple.JSONArray;

import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

/**
 * The Class AddResources.
 */
public class AddResources implements LCQuickEffect {
	
	/** The tobe added. */
	private Stats tobeAdded;

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.effect.leaderEffects.quickeffects.LCQuickEffect#activate(it.polimi.ingsw.ps18.model.personalboard.PBoard, it.polimi.ingsw.ps18.model.gamelogic.GameLogic)
	 */
	@Override
	public void activate(PBoard player, GameLogic game) {
		player.getResources().addStats(tobeAdded);
	}

	/**
	 * Sets the param.
	 *
	 * @param tobeAdded the new param
	 */
	public void setParam(JSONArray tobeAdded) {
		this.tobeAdded = new Stats(tobeAdded);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("Every time you activate this effect receive:\n");
		builder.append(tobeAdded.toStringCost());
		return builder.toString();
		
	}

}
