package it.polimi.ingsw.ps18.model.effect.prodEffect;

import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

/**
 * The Interface Converter.
 */
public interface Converter extends ProductionEffect {
	
	/**
	 * Gets the cost.
	 *
	 * @return the cost
	 */
	public abstract Stats getCost();

}
