package it.polimi.ingsw.ps18.model.effect.leaderEffects.quickeffects;

import org.json.simple.JSONArray;

import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

public class AddResources implements LCQuickEffect {
	private Stats tobeAdded;

	@Override
	public void activate(PBoard player, GameLogic game) {
		player.getResources().addStats(tobeAdded);
	}

	public void setParam(JSONArray tobeAdded) {
		this.tobeAdded = new Stats(tobeAdded);
	}
	
	@Override
	public String toString(){
		return "Da Scrivere";
	}

}
