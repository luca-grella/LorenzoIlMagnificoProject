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
import it.polimi.ingsw.ps18.model.effect.generalEffects.privilege;

public class HashMapQE {
    private static Map<String,QuickEffect> genQEffects = new HashMap<>();
	
	public static void init(){
		genQEffects.put("AddWood", new addWood());
		genQEffects.put("AddStone", new addRock());
		genQEffects.put("AddServant", new addServants());
		genQEffects.put("AddCoin", new addCoins());
		genQEffects.put("AddPC", new privilege());
		genQEffects.put("AddPM", new addMP());
		genQEffects.put("AddPF", new addFP());
		genQEffects.put("AddPV", new addVP());
	}
	
	public static QuickEffect geteffect(String a){
		return genQEffects.get(a);
	}

}
