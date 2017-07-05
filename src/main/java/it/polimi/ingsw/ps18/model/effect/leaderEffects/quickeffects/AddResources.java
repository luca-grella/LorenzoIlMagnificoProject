package it.polimi.ingsw.ps18.model.effect.leaderEffects.quickeffects;

import org.json.simple.JSONArray;

import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

public class AddResources implements LCQuickEffect {
	private Stats tobeAdded;
	private String description;

	@Override
	public void activate(PBoard player, GameLogic game) {
		player.getResources().addStats(tobeAdded);
	}

	public void setParam(JSONArray tobeAdded, String description) {
		this.tobeAdded = new Stats(tobeAdded);
		this.description = description;
	}
	
	@Override
	public String toString(){
		return description;
	}

}
