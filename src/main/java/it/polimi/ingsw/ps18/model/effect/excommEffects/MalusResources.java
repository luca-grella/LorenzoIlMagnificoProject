package it.polimi.ingsw.ps18.model.effect.excommEffects;

import org.json.simple.JSONArray;

import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

public class MalusResources implements ExcommEffects {
	private String name = "MalusResources";
	private Stats malus;
	

	@Override
	public void setQuantity(int quantity) {
		return;
	}
	
	public void setMalus(JSONArray stats){
		malus = new Stats(stats);
	}
	
	
	
	/**
	 * @return the malus
	 */
	public Stats getMalus() {
		return malus;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

}
