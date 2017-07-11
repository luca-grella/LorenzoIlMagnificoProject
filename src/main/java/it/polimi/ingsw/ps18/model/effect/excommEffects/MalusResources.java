package it.polimi.ingsw.ps18.model.effect.excommEffects;

import org.json.simple.JSONArray;

import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

/**
 * The Class MalusResources.
 */
public class MalusResources implements ExcommEffects {
	
	/** The name. */
	private String name = "MalusResources";
	
	/** The malus. */
	private Stats malus;
	

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.effect.excommEffects.ExcommEffects#setQuantity(int)
	 */
	@Override
	public void setQuantity(int quantity) {
		return;
	}
	
	/**
	 * Sets the malus.
	 *
	 * @param stats the new malus
	 */
	public void setMalus(JSONArray stats){
		malus = new Stats(stats);
	}
	
	
	
	/**
	 * Gets the malus.
	 *
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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("When you receive resources from an Action Space or a Card, reduce yout income by:\n");
		builder.append(malus.toStringCost());
		return builder.toString();
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
