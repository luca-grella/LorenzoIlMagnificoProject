package it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects;

import java.util.HashMap;
import java.util.Map;

/**
 * The Class HashMapLCP.
 */
public class HashMapLCP {
	
	/** The peffects. */
	private Map<String,LCPermEffect> peffects = new HashMap<>();
	
	/**
	 * Instantiates a new hash map LCP.
	 */
	public HashMapLCP(){
		peffects.put("TowerDiscount", new TowerDiscount());
		peffects.put("ModifierValue", new ModifierValue());
		peffects.put("VariousModifier", new VariousModifier());
	}
	
	/**
	 * Gets the LC perm effect.
	 *
	 * @param key the key
	 * @return the LC perm effect
	 */
	public LCPermEffect getLCPermEffect(String key){
		return peffects.get(key);
	}

}
