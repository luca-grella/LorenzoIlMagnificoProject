package it.polimi.ingsw.ps18.model.effect.prodEffect;

import java.util.HashMap;
import java.util.Map;

import it.polimi.ingsw.ps18.model.effect.generalEffects.AddCoinforGreenC;
import it.polimi.ingsw.ps18.model.effect.generalEffects.AddCoinforYellowC;
import it.polimi.ingsw.ps18.model.effect.generalEffects.AddPVforBlueC;
import it.polimi.ingsw.ps18.model.effect.generalEffects.AddPVforGreenC;
import it.polimi.ingsw.ps18.model.effect.generalEffects.AddPVforPurpleC;
import it.polimi.ingsw.ps18.model.effect.generalEffects.AddPVforYellowC;
import it.polimi.ingsw.ps18.model.effect.generalEffects.Privilege;
import it.polimi.ingsw.ps18.model.effect.generalEffects.addCoins;
import it.polimi.ingsw.ps18.model.effect.generalEffects.addFP;
import it.polimi.ingsw.ps18.model.effect.generalEffects.addMP;
import it.polimi.ingsw.ps18.model.effect.generalEffects.addRock;
import it.polimi.ingsw.ps18.model.effect.generalEffects.addServants;
import it.polimi.ingsw.ps18.model.effect.generalEffects.addVP;
import it.polimi.ingsw.ps18.model.effect.generalEffects.addWood;

public class HashMapPE {
    private Map<String,ProductionEffect> genPEffects = new HashMap<>();
	
	public HashMapPE(){
		genPEffects.put("AddWood", new addWood());
		genPEffects.put("AddStone", new addRock());
		genPEffects.put("AddServant", new addServants());
		genPEffects.put("AddCoin", new addCoins());
		genPEffects.put("AddPC", new Privilege());
		genPEffects.put("AddPM", new addMP());
		genPEffects.put("AddPF", new addFP());
		genPEffects.put("AddPV", new addVP());
		genPEffects.put("ConvertResourcesInResources", new ConvertinResources());
		genPEffects.put("AddPVforGreenCard", new AddPVforGreenC());
		genPEffects.put("AddPVforBlueCard", new AddPVforBlueC());
		genPEffects.put("AddPVforYellowCard", new AddPVforYellowC());
		genPEffects.put("AddPVforPurpleCard", new AddPVforPurpleC());
		genPEffects.put("AddCoinforGreenCard", new AddCoinforGreenC());
		genPEffects.put("AddCoinforYellowCard", new AddCoinforYellowC());
		genPEffects.put("ConvertResourcesInPC", new ConvertinPC());
		genPEffects.put("ConvertResourcesOrResourcesInResources", new ConvertResorResinResources());
	}
	
	public ProductionEffect geteffect(String a){
		return genPEffects.get(a);
	}


}
