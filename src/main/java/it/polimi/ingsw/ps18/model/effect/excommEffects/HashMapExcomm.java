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
		geneffetti.put("MalusMP", new MalusMP());
		geneffetti.put("MalusCoins", new MalusCoins());
		geneffetti.put("MalusServants", new MalusServants());
		geneffetti.put("MalusWR", new MalusWR());
		geneffetti.put("MalusHarv", new MalusHarv());
		geneffetti.put("MalusProd", new MalusProd());
		geneffetti.put("MalusDice", new MalusDice());
		geneffetti.put("MalusGreenC", new MalusGreenC());
		geneffetti.put("MalusYellowC", new MalusYellowC());
		geneffetti.put("MalusBlueC", new MalusBlueC());
		geneffetti.put("MalusPurpleC", new MalusPurpleC());
		geneffetti.put("MalusMarket", new MalusMarket());
		geneffetti.put("MalusIncreaseActionValue", new MalusIncreaseActionValue());
		geneffetti.put("MalusTurnOrder", new MalusTurnOrder());
		geneffetti.put("IgnoreBlueC", new IgnoreBlueC());
		geneffetti.put("IgnorePurpleC", new IgnorePurpleC());
		geneffetti.put("IgnoreGreenC", new IgnoreGreenC());
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
