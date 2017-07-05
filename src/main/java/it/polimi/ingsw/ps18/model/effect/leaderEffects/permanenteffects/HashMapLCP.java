package it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects;

import java.util.HashMap;
import java.util.Map;

public class HashMapLCP {
	private Map<String,LCPermEffect> peffects = new HashMap<>();
	
	public HashMapLCP(){
		peffects.put("TowerDiscount", new TowerDiscount());
		peffects.put("ModifierValue", new ModifierValue());
		peffects.put("VariousModifier", new VariousModifier());
	}
	
	public LCPermEffect getLCPermEffect(String key){
		return peffects.get(key);
	}

}
