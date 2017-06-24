package it.polimi.ingsw.ps18.controller.controllerstatus;

import java.util.HashMap;
import java.util.Map;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.controller.controlleractions.TurnHandleInit;

public class HashMapStatus {
    private static Map<String,Status> genStatus = new HashMap<>();
	
	public static void init(){
		genStatus.put("Show Fam", new ShowFam());
		genStatus.put("Show Towers", new ShowTowers());
		genStatus.put("Show Towers Zoom", new ShowTowerswithZoom());
		genStatus.put("Show Market", new ShowMarket());
		genStatus.put("Show Council", new ShowCouncil());
		genStatus.put("Show Harvest", new ShowHarvest());
		genStatus.put("Show Production", new ShowProduction());
		genStatus.put("ShowBonusTiles", new ShowBonusTiles());
	}
	
	public static Status geteffect(String a){
		return genStatus.get(a);
	}

}
