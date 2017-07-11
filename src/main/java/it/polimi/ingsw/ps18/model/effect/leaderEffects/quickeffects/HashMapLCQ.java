package it.polimi.ingsw.ps18.model.effect.leaderEffects.quickeffects;

import java.util.HashMap;
import java.util.Map;

import it.polimi.ingsw.ps18.model.effect.generalEffects.ActHarvest;
import it.polimi.ingsw.ps18.model.effect.generalEffects.ActProduction;
import it.polimi.ingsw.ps18.model.effect.generalEffects.Privilege;

/**
 * The Class HashMapLCQ.
 */
public class HashMapLCQ {
	
	/** The qeffects. */
	private Map<String,LCQuickEffect> qeffects = new HashMap<>();
	
	
	/**
	 * Instantiates a new hash map LCQ.
	 */
	public HashMapLCQ(){
		qeffects.put("ActivateHarvest", new ActHarvest());
		qeffects.put("ActivateProduction", new ActProduction());
		qeffects.put("AddResources", new AddResources());
		qeffects.put("AddPC", new Privilege());
		qeffects.put("ChangeFamValue", new ChangeFamValue());
	}
	
	/**
	 * Gets the LC quick effect.
	 *
	 * @param key the key
	 * @return the LC quick effect
	 */
	public LCQuickEffect getLCQuickEffect(String key){
		return qeffects.get(key);
	}

}
