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
import it.polimi.ingsw.ps18.model.effect.generalEffects.privilege;

public class HashMapHE {
    private static Map<String,HarvestEffect> genHEffects = new HashMap<>();
	
	public static void init(){
		genHEffects.put("AddWood", new addWood());
		genHEffects.put("AddStone", new addRock());
		genHEffects.put("AddServant", new addServants());
		genHEffects.put("AddCoin", new addCoins());
		genHEffects.put("AddPC", new privilege());
		genHEffects.put("AddPM", new addMP());
		genHEffects.put("AddPF", new addFP());
		genHEffects.put("AddPV", new addVP());
	}
	
	public static HarvestEffect geteffect(String a){
		return genHEffects.get(a);
	}


}
