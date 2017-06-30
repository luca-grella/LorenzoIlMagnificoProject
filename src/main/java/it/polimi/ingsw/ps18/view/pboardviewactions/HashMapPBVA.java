package it.polimi.ingsw.ps18.view.pboardviewactions;

import java.util.HashMap;
import java.util.Map;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.view.pboardviewactions.effectresoution.ActHarvestwithParameter;
import it.polimi.ingsw.ps18.view.pboardviewactions.effectresoution.ActProductionwithParameter;
import it.polimi.ingsw.ps18.view.pboardviewactions.effectresoution.ChoosePrivilege;

/**
 * Support for the Strategy Pattern that runs the various PBoard's View actions
 * .
 *
 * @author Francesco-Musio
 */
public class HashMapPBVA {
    
    /**
	 * The gen PBV action.
	 */
    private static Map<String,PBViewAction> genPBVAction = new HashMap<>();
	
	/**
	 * Inits the.
	 * @param mcontroller 
	 */
	public static void init(MainController mcontroller){
		genPBVAction.put("Init Player Turn", new PBVAInit(mcontroller));
		genPBVAction.put("Fam Choice Tower", new ShowChoiceFamtoTower(mcontroller));
		genPBVAction.put("Tower Choice", new ShowChoiceTower(mcontroller));
		genPBVAction.put("Floor Choice", new ShowChoiceFloor(mcontroller));
		genPBVAction.put("Fam Choice Market", new ShowChoiceFamtoMarket(mcontroller));
		genPBVAction.put("Market Cell Choice", new ShowChoiceMarketCell(mcontroller));
		genPBVAction.put("Fam Choice Council", new ShowChoiceFamtoCouncil(mcontroller));
		genPBVAction.put("Fam Choice Harvest", new ShowChoiceFamtoHarvest(mcontroller));
		genPBVAction.put("Fam Choice Production", new ShowChoiceFamtoProduction(mcontroller));
		genPBVAction.put("actHarvest", new ActHarvestwithParameter(mcontroller));
		genPBVAction.put("actProduction", new ActProductionwithParameter(mcontroller));
		genPBVAction.put("PrivilegeChoice", new ChoosePrivilege(mcontroller));
		genPBVAction.put("CardCostChoice", new CostChoice(mcontroller));
		genPBVAction.put("ChooseBonusTile", new ShowChoiceBonusTiles(mcontroller));
		genPBVAction.put("Choose Church Support", new ChooseSupport(mcontroller));
	}
	
	/**
	 * Gets the effect.
	 *
	 * @param a
	 *            the a
	 * @return the effect
	 */
	public static PBViewAction geteffect(String a){
		return genPBVAction.get(a);
	}

}
