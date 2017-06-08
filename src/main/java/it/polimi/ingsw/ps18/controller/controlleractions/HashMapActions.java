package it.polimi.ingsw.ps18.controller.controlleractions;

import java.util.HashMap;
import java.util.Map;

import it.polimi.ingsw.ps18.controller.controlleractions.famtocouncil.FamtoCouncilTrigger;
import it.polimi.ingsw.ps18.controller.controlleractions.famtocouncil.RecieveFamtoCouncil;
import it.polimi.ingsw.ps18.controller.controlleractions.famtomarket.FamtoMarketTrigger;
import it.polimi.ingsw.ps18.controller.controlleractions.famtomarket.RecieveFamtoMarket;
import it.polimi.ingsw.ps18.controller.controlleractions.famtotower.FamtoTowerTrigger;
import it.polimi.ingsw.ps18.controller.controlleractions.famtotower.RecieveFamtoTower;
import it.polimi.ingsw.ps18.controller.controlleractions.famtotower.RecieveFloortoTower;
import it.polimi.ingsw.ps18.controller.controlleractions.famtotower.RecieveTowertoTower;

public class HashMapActions {
    private static Map<String,ActionChoice> genActions = new HashMap<>();
	
	public static void init(){
		genActions.put("Turn Handle Init", new TurnHandleInit());
		genActions.put("FamtoTower", new FamtoTowerTrigger());
		genActions.put("RecieveFamtoTower", new RecieveFamtoTower());
		genActions.put("RecieveTower", new RecieveTowertoTower());
		genActions.put("RecieveFloor", new RecieveFloortoTower());
		genActions.put("FamtoMarket", new FamtoMarketTrigger());
		genActions.put("RecieveFamtoMarket", new RecieveFamtoMarket());
		genActions.put("RecieveTowertoShow", new ShowTowerCells());
		genActions.put("FamtoCouncil", new FamtoCouncilTrigger());
		genActions.put("RecieveFamtoCouncil", new RecieveFamtoCouncil());
	}
	
	public static ActionChoice geteffect(String a){
		return genActions.get(a);
	}

}
