package it.polimi.ingsw.ps18.view.pboardviewactions;

import java.util.HashMap;
import java.util.Map;

/**
 * Support for the Strategy Pattern that runs the various PBoard's View actions 
 * @author Francesco-Musio
 *
 */
public class HashMapPBVA {
    private static Map<String,PBViewAction> genPBVAction = new HashMap<>();
	
	public static void init(){
		genPBVAction.put("Init Player Turn", new PBVAInit());
		genPBVAction.put("Fam Choice", new ShowChoiceFam());
	}
	
	public static PBViewAction geteffect(String a){
		return genPBVAction.get(a);
	}

}
