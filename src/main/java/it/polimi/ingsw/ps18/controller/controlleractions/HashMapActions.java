package it.polimi.ingsw.ps18.controller.controlleractions;

import java.util.HashMap;
import java.util.Map;

public class HashMapActions {
    private static Map<String,ActionChoice> genActions = new HashMap<>();
	
	public static void init(){
		genActions.put("Turn Handle Init", new TurnHandleInit());
		genActions.put("FamtoTower", new FamtoTowerTrigger());
	}
	
	public static ActionChoice geteffect(String a){
		return genActions.get(a);
	}

}
