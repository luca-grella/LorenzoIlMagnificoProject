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
import it.polimi.ingsw.ps18.model.effect.generalEffects.ActHarvest;
import it.polimi.ingsw.ps18.model.effect.generalEffects.ActProduction;
import it.polimi.ingsw.ps18.model.effect.generalEffects.AddPVforBlueC;
import it.polimi.ingsw.ps18.model.effect.generalEffects.AddPVforGreenC;
import it.polimi.ingsw.ps18.model.effect.generalEffects.AddPVforPurpleC;
import it.polimi.ingsw.ps18.model.effect.generalEffects.AddPVforYellowC;
import it.polimi.ingsw.ps18.model.effect.generalEffects.AddVPforMP;
import it.polimi.ingsw.ps18.model.effect.generalEffects.DifferentPrivilege;
import it.polimi.ingsw.ps18.model.effect.generalEffects.Privilege;
import it.polimi.ingsw.ps18.model.effect.generalEffects.TakeOneCard;

/**
 * The Class HashMapQE.
 */
public class HashMapQE {
    
    /**
	 * The gen Q effects.
	 */
    private Map<String,QuickEffect> genQEffects = new HashMap<>();
	
	/**
	 * Instantiates a new hash map QE.
	 */
	public HashMapQE(){
		genQEffects.put("AddWood", new addWood());
		genQEffects.put("AddStone", new addRock());
		genQEffects.put("AddServant", new addServants());
		genQEffects.put("AddCoin", new addCoins());
		genQEffects.put("AddPC", new Privilege());
        genQEffects.put("AddDifferentPC", new DifferentPrivilege());
		genQEffects.put("AddPM", new addMP());
		genQEffects.put("AddPF", new addFP());
		genQEffects.put("AddPV", new addVP());
		genQEffects.put("ActivateHarvest", new ActHarvest());
		genQEffects.put("ActivateProduction", new ActProduction());
		genQEffects.put("TakeOneCard", new TakeOneCard());
		genQEffects.put("AddPVforGreenCard", new AddPVforGreenC());
		genQEffects.put("AddPVforBlueCard", new AddPVforBlueC());
		genQEffects.put("AddPVforYellowCard", new AddPVforYellowC());
		genQEffects.put("AddPVforPurpleCard", new AddPVforPurpleC());
		genQEffects.put("AddPVforMP", new AddVPforMP());
		genQEffects.put("SalesWoodandRockYellow", new QuickSalesCoinBlue());
		genQEffects.put("SalesCoinBlue", new QuickSalesWoodorRockYellow());
	}
	
	/**
	 * Gets the effect.
	 *
	 * @param a
	 *            the a
	 * @return the effect
	 */
	public QuickEffect geteffect(String a){
		return genQEffects.get(a);
	}

}
