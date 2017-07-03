package it.polimi.ingsw.ps18.model.effect.finalEffect;

import java.util.HashMap;
import java.util.Map;

public class HashMapVPBlue {

	private Map<Integer, Integer> genVPBEffect = new HashMap<>();
	
	
	public HashMapVPBlue() {
		genVPBEffect.put(0, 0);
		genVPBEffect.put(1, 1);
		genVPBEffect.put(2, 3);
		genVPBEffect.put(3, 6);
		genVPBEffect.put(4, 10);
		genVPBEffect.put(5, 15);
		genVPBEffect.put(6, 21);
	}


	public Integer getGenVPBEffect(Integer i) {
		return genVPBEffect.get(i);
	}
	
	
}
