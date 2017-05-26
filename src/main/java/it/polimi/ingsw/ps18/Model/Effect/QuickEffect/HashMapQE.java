package it.polimi.ingsw.ps18.model.effect.quickEffect;

import java.util.HashMap;
import java.util.Map;

import it.polimi.ingsw.ps18.model.effect.generalEffects.addCoins;
import it.polimi.ingsw.ps18.model.effect.generalEffects.addFP;
import it.polimi.ingsw.ps18.model.effect.generalEffects.addMP;
import it.polimi.ingsw.ps18.model.effect.generalEffects.addRock;
import it.polimi.ingsw.ps18.model.effect.generalEffects.addServants;
import it.polimi.ingsw.ps18.model.effect.generalEffects.addVP;
import it.polimi.ingsw.ps18.model.effect.generalEffects.addWood;

public class HashMapQE {
    private static Map<String,QuickEffect> genQEffects = new HashMap<>();
	
	public static void init(){
		genQEffects.put("addWood", new addWood());
		genQEffects.put("addRock", new addRock());
		genQEffects.put("addServant", new addServants());
		genQEffects.put("addCoin", new addCoins());
		genQEffects.put("addMP", new addMP());
		genQEffects.put("addFP", new addFP());
		genQEffects.put("addVP", new addVP());
	}
	
	public static QuickEffect geteffect(String a){
		return genQEffects.get(a);
	}

}
