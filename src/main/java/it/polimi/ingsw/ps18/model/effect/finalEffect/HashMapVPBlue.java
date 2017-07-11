package it.polimi.ingsw.ps18.model.effect.finalEffect;

import java.util.HashMap;
import java.util.Map;

/**
 * The Class HashMapVPBlue.
 */
public class HashMapVPBlue {

	/** The gen VPB effect. */
	private Map<Integer, Integer> genVPBEffect = new HashMap<>();
	
	
	/**
	 * Instantiates a new hash map VP blue.
	 */
	public HashMapVPBlue() {
		genVPBEffect.put(0, 0);
		genVPBEffect.put(1, 1);
		genVPBEffect.put(2, 3);
		genVPBEffect.put(3, 6);
		genVPBEffect.put(4, 10);
		genVPBEffect.put(5, 15);
		genVPBEffect.put(6, 21);
	}


	/**
	 * Gets the gen VPB effect.
	 *
	 * @param i the i
	 * @return the gen VPB effect
	 */
	public Integer getGenVPBEffect(Integer i) {
		return genVPBEffect.get(i);
	}
	
	
}
