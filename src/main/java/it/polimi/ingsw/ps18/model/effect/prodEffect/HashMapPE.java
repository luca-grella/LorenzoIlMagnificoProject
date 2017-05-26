package it.polimi.ingsw.ps18.model.effect.prodEffect;

import java.util.HashMap;
import java.util.Map;

import it.polimi.ingsw.ps18.model.effect.generalEffects.addCoins;
import it.polimi.ingsw.ps18.model.effect.generalEffects.addFP;
import it.polimi.ingsw.ps18.model.effect.generalEffects.addMP;
import it.polimi.ingsw.ps18.model.effect.generalEffects.addRock;
import it.polimi.ingsw.ps18.model.effect.generalEffects.addServants;
import it.polimi.ingsw.ps18.model.effect.generalEffects.addVP;
import it.polimi.ingsw.ps18.model.effect.generalEffects.addWood;

public class HashMapPE {
    private static Map<String,ProductionEffect> genPEffects = new HashMap<>();
	
	public static void init(){
		genPEffects.put("addWood", new addWood());
		genPEffects.put("addRock", new addRock());
		genPEffects.put("addServant", new addServants());
		genPEffects.put("addCoin", new addCoins());
		genPEffects.put("addMP", new addMP());
		genPEffects.put("addFP", new addFP());
		genPEffects.put("addVP", new addVP());
	}
	
	public static ProductionEffect geteffect(String a){
		return genPEffects.get(a);
	}


}
