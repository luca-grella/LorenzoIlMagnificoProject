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
import it.polimi.ingsw.ps18.model.effect.generalEffects.Privilege;

public class HashMapHE {
    private Map<String,HarvestEffect> genHEffects = new HashMap<>();
	
	public HashMapHE(){
		genHEffects.put("AddWood", new addWood());
		genHEffects.put("AddStone", new addRock());
		genHEffects.put("AddServant", new addServants());
		genHEffects.put("AddCoin", new addCoins());
		genHEffects.put("AddPC", new Privilege());
		genHEffects.put("AddPM", new addMP());
		genHEffects.put("AddPF", new addFP());
		genHEffects.put("AddPV", new addVP());
	}
	
	public HarvestEffect geteffect(String a){
		return genHEffects.get(a);
	}


}
