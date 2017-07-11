package it.polimi.ingsw.ps18.model.effect.finalEffect;

import java.util.HashMap;
import java.util.Map;

/**
 * The Class HashMapVPGreen.
 */
public class HashMapVPGreen {

	/** The gen VPG effect. */
	private Map<Integer, Integer> genVPGEffect = new HashMap<>();

	/**
	 * Instantiates a new hash map VP green.
	 */
	public HashMapVPGreen() {
		genVPGEffect.put(0, 0);
		genVPGEffect.put(1, 0);
		genVPGEffect.put(2, 0);
		genVPGEffect.put(3, 1);
		genVPGEffect.put(4, 4);
		genVPGEffect.put(5, 10);
		genVPGEffect.put(6, 20);
	}
	
	/**
	 * Gets the gen VPG effect.
	 *
	 * @param i the i
	 * @return the genVPGEffect
	 */
	public Integer getGenVPGEffect(Integer i) {
		return genVPGEffect.get(i);
	}

	
	
}
