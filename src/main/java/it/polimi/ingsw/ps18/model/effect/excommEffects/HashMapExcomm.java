package it.polimi.ingsw.ps18.model.effect.excommEffects;

import java.util.HashMap;
import java.util.Map;


/**
 * The Class HashMapExcomm.
 */
public class HashMapExcomm {
	
	/**
	 * The geneffetti.
	 */
	private Map<String,ExcommEffects> geneffetti = new HashMap<>();
	
	/**
	 * Instantiates a new hash map excomm.
	 */
	public HashMapExcomm(){
		geneffetti.put("MalusResources", new MalusResources());
		geneffetti.put("MalusValue", new MalusValue());
		geneffetti.put("IgnoreCards", new IgnoreCards());
		geneffetti.put("LoseVPforVP", new LoseVPforVP());
		geneffetti.put("LoseVPforMP", new LoseVPforMP());
		geneffetti.put("LoseVPforCosts", new LoseVPforCosts());
		geneffetti.put("LoseVPforResources", new LoseVPforResources()); 
		

	}
	
	/**
	 * Gets the effect.
	 *
	 * @param a
	 *            the a
	 * @return the effect
	 */
	public ExcommEffects geteffect(String a){
		return geneffetti.get(a);
	}

}
