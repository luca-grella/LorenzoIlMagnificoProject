package it.polimi.ingsw.ps18.model.effect.finalEffect;

import java.util.HashMap;
import java.util.Map;

import it.polimi.ingsw.ps18.model.effect.generalEffects.addVP;


public class HashMapFE {
private static Map<String,FinalEffect> genFEffects = new HashMap<>();
	
	public static void init(){
		genFEffects.put("addVP", new addVP());
	}
	
	public static FinalEffect geteffect(String a){
		return genFEffects.get(a);
	}


}
