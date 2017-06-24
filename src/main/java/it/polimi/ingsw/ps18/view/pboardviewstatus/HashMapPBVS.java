package it.polimi.ingsw.ps18.view.pboardviewstatus;

import java.util.HashMap;
import java.util.Map;

import it.polimi.ingsw.ps18.view.pboardviewactions.effectresoution.ChoosePrivilege;

// TODO: Auto-generated Javadoc
/**
 * Support for the Strategy Pattern that runs the various PBoard's View status .
 *
 * @author Francesco-Musio
 */
public class HashMapPBVS {
	
	/**
	 * The gen PBV status.
	 */
	private static Map<String,PBViewStatus> genPBVStatus = new HashMap<>();
	
	/**
	 * Inits the.
	 */
	public static void init(){
		genPBVStatus.put("Tower Choice", new ChooseTowertoShow());
		genPBVStatus.put("Player Choice", new ChoosePlayertoShow());
		genPBVStatus.put("WoodorRockChoice", new ChooseWoodorRock());
		genPBVStatus.put("actHarvest", new ActHarvest());
		genPBVStatus.put("actProduction", new ActProduction());
		genPBVStatus.put("Select YC", new SelectYellowC());
		genPBVStatus.put("Choose Effect", new ChooseEffect());
	}
	
	/**
	 * Gets the effect.
	 *
	 * @param a
	 *            the a
	 * @return the effect
	 */
	public static PBViewStatus geteffect(String a){
		return genPBVStatus.get(a);
	}

}
