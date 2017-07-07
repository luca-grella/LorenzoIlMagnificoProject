package it.polimi.ingsw.ps18.model.effect.leaderEffects.requirements;

import org.json.simple.JSONArray;

import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

public class CheckResources implements LCRequirement {
	private Stats minimum;

	@Override
	public boolean checkRequirement(PBoard player) {
		return player.getResources().enoughStats(minimum);
	}

	public void setParam(JSONArray minimum) {
		this.minimum = new Stats(minimum);
	}
	
	@Override
	public String toString(){
		return "You need to have at least: \n" + this.minimum.toStringCost();
	}

	/**
	 * @return
	 */
	public Stats getParam() {
		
		return minimum;
	}

}
