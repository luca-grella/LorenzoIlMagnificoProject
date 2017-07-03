package it.polimi.ingsw.ps18.model.effect.finalEffect;

import java.util.HashMap;
import java.util.Map;

public class HashMapVPGreen {

	private Map<Integer, Integer> genVPGEffect = new HashMap<>();

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
	 * @return the genVPGEffect
	 */
	public Integer getGenVPGEffect(Integer i) {
		return genVPGEffect.get(i);
	}

	
	
}
