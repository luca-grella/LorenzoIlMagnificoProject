package it.polimi.ingsw.ps18.model.effect.harvestEffect;

import java.util.HashMap;
import java.util.Map;

import it.polimi.ingsw.ps18.model.effect.generalEffects.addCoins;
import it.polimi.ingsw.ps18.model.effect.generalEffects.addFP;
import it.polimi.ingsw.ps18.model.effect.generalEffects.addMP;
import it.polimi.ingsw.ps18.model.effect.generalEffects.addRock;
import it.polimi.ingsw.ps18.model.effect.generalEffects.addServants;
import it.polimi.ingsw.ps18.model.effect.generalEffects.addVP;
import it.polimi.ingsw.ps18.model.effect.generalEffects.addWood;

public class HashMapHE {
    private static Map<String,HarvestEffect> genHEffects = new HashMap<>();
	
	public static void init(){
		genHEffects.put("addWood", new addWood());
		genHEffects.put("addRock", new addRock());
		genHEffects.put("addServant", new addServants());
		genHEffects.put("addCoin", new addCoins());
		genHEffects.put("addMP", new addMP());
		genHEffects.put("addFP", new addFP());
		genHEffects.put("addVP", new addVP());
	}
	
	public static HarvestEffect geteffect(String a){
		return genHEffects.get(a);
	}


}
