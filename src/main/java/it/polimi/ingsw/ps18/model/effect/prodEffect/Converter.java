package it.polimi.ingsw.ps18.model.effect.prodEffect;

import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

public interface Converter extends ProductionEffect {
	
	public abstract Stats getCost();

}
