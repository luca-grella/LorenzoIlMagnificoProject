package it.polimi.ingsw.ps18.model.effect.leaderEffects.requirements;

import java.util.HashMap;
import java.util.Map;

/**
 * The Class HashMapLCR.
 */
public class HashMapLCR {
	
	/** The lc requirements. */
	private Map<String,LCRequirement> lcRequirements = new HashMap<>();
	
	/**
	 * Instantiates a new hash map LCR.
	 */
	public HashMapLCR(){
		lcRequirements.put("CheckNumberCardType", new CheckNumberCardType());
		lcRequirements.put("CheckResources", new CheckResources());
		lcRequirements.put("CheckMinimumSameTypeCards", new CheckMinimumSameTypeCards());
		lcRequirements.put("CheckMinimumAllTypeCards", new CheckMinimumAllTypeCards());
	}
	
	/**
	 * Gets the requirement.
	 *
	 * @param requirement the requirement
	 * @return the requirement
	 */
	public LCRequirement getRequirement(String requirement){
		return lcRequirements.get(requirement);
	}

}
