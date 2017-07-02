package it.polimi.ingsw.ps18.model.effect.permeffects;

import java.util.HashMap;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class HashMapPermE.
 */
public class HashMapPermE {
	
	/**
	 * The perm effects.
	 */
	private Map<String,Permanenteffect> permEffects = new HashMap<>();
	
	/**
	 * Instantiates a new hash map perm E.
	 */
	public HashMapPermE(){
		permEffects.put("IncreaseFMvalueOnAction", new IncreaseFMValueOnAction());
		permEffects.put("IncreaseFMvalueOnActionWR", new IncreaseFMValueOnActionWR());
		permEffects.put("BlockFloorBonus", new BlockFloorBonus());
	}
	
	/**
	 * Gets the effect.
	 *
	 * @param code
	 *            the code
	 * @return the effect
	 */
	public Permanenteffect getEffect(String code){
		return permEffects.get(code);
	}

}
