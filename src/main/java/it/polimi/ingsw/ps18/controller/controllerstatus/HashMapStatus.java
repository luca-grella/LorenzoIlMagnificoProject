package it.polimi.ingsw.ps18.controller.controllerstatus;

import java.util.HashMap;
import java.util.Map;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.controller.controlleractions.TurnHandleInit;

// TODO: Auto-generated Javadoc
/**
 * The Class HashMapStatus.
 */
public class HashMapStatus {
    
    /**
	 * The gen status.
	 */
    private static Map<String,Status> genStatus = new HashMap<>();
	
	/**
	 * Inits the.
	 */
	public static void init(){
		genStatus.put("Show Fam", new ShowFam());
		genStatus.put("Show Towers", new ShowTowers());
		genStatus.put("Show Towers Zoom", new ShowTowerswithZoom());
		genStatus.put("Show Market", new ShowMarket());
		genStatus.put("Show Council", new ShowCouncil());
		genStatus.put("Show Harvest", new ShowHarvest());
		genStatus.put("Show Production", new ShowProduction());
	}
	
	/**
	 * Gets the effect.
	 *
	 * @param a
	 *            the a
	 * @return the effect
	 */
	public static Status geteffect(String a){
		return genStatus.get(a);
	}

}
