package it.polimi.ingsw.ps18.model.effect.finalEffect;

import java.util.HashMap;
import java.util.Map;

import it.polimi.ingsw.ps18.model.effect.generalEffects.addVP;


public class HashMapFE {
    private Map<String,FinalEffect> genFEffects = new HashMap<>();
	
	public HashMapFE(){
		genFEffects.put("AddPV", new addVP());
	}
	
	public FinalEffect geteffect(String a){
		return genFEffects.get(a);
	}


}
