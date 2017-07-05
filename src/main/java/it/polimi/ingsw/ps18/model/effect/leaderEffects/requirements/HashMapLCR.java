package it.polimi.ingsw.ps18.model.effect.leaderEffects.requirements;

import java.util.HashMap;
import java.util.Map;

public class HashMapLCR {
	private Map<String,LCRequirement> lcRequirements = new HashMap<>();
	
	public HashMapLCR(){
		lcRequirements.put("CheckNumberCardType", new CheckNumberCardType());
		lcRequirements.put("CheckResources", new CheckResources());
		lcRequirements.put("CheckMinimumSameTypeCards", new CheckMinimumSameTypeCards());
		lcRequirements.put("CheckMinimumAllTypeCards", new CheckMinimumAllTypeCards());
	}
	
	public LCRequirement getRequirement(String requirement){
		return lcRequirements.get(requirement);
	}

}
