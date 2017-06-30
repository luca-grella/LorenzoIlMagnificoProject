package it.polimi.ingsw.ps18.view.pboardviewstatus;

import java.util.HashMap;
import java.util.Map;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.view.pboardviewactions.effectresolution.ChoosePrivilege;

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
	 * @param mcontroller 
	 */
	public static void init(MainController mcontroller){
		genPBVStatus.put("Tower Choice", new ChooseTowertoShow(mcontroller));
		genPBVStatus.put("Player Choice", new ChoosePlayertoShow(mcontroller));
		genPBVStatus.put("WoodorRockChoice", new ChooseWoodorRock(mcontroller));
		genPBVStatus.put("actHarvest", new ActHarvest(mcontroller));
		genPBVStatus.put("actProduction", new ActProduction(mcontroller));
		genPBVStatus.put("Select YC", new SelectYellowC(mcontroller));
		genPBVStatus.put("Choose Effect", new ChooseEffect(mcontroller));
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
