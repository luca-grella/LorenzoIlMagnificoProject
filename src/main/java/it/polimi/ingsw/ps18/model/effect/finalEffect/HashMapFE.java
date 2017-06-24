package it.polimi.ingsw.ps18.model.effect.finalEffect;

import java.util.HashMap;
import java.util.Map;

import it.polimi.ingsw.ps18.model.effect.generalEffects.addVP;


// TODO: Auto-generated Javadoc
/**
 * The Class HashMapFE.
 */
public class HashMapFE {
    
    /**
	 * The gen F effects.
	 */
    private Map<String,FinalEffect> genFEffects = new HashMap<>();
	
	/**
	 * Instantiates a new hash map FE.
	 */
	public HashMapFE(){
		genFEffects.put("AddPV", new addVP());
	}
	
	/**
	 * Gets the effect.
	 *
	 * @param a
	 *            the a
	 * @return the effect
	 */
	public FinalEffect geteffect(String a){
		return genFEffects.get(a);
	}


}
