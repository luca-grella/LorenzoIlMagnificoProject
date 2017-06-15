package it.polimi.ingsw.ps18.controller.controlleractions;

import java.util.HashMap;
import java.util.Map;

import it.polimi.ingsw.ps18.controller.controlleractions.effectresolution.PrivilegeHandler;
import it.polimi.ingsw.ps18.controller.controlleractions.famtocouncil.FamtoCouncilTrigger;
import it.polimi.ingsw.ps18.controller.controlleractions.famtocouncil.ReceiveFamtoCouncil;
import it.polimi.ingsw.ps18.controller.controlleractions.famtoharvest.ActivateHarvest;
import it.polimi.ingsw.ps18.controller.controlleractions.famtoharvest.FamtoHarvestTrigger;
import it.polimi.ingsw.ps18.controller.controlleractions.famtoharvest.ReceiveFamtoHarvest;
import it.polimi.ingsw.ps18.controller.controlleractions.famtomarket.FamtoMarketTrigger;
import it.polimi.ingsw.ps18.controller.controlleractions.famtomarket.ReceiveFamtoMarket;
import it.polimi.ingsw.ps18.controller.controlleractions.famtomarket.ReceiveMarketCell;
import it.polimi.ingsw.ps18.controller.controlleractions.famtoproduction.ActivateProduction;
import it.polimi.ingsw.ps18.controller.controlleractions.famtoproduction.FamtoProductionTrigger;
import it.polimi.ingsw.ps18.controller.controlleractions.famtoproduction.ReceiveFamtoProduction;
import it.polimi.ingsw.ps18.controller.controlleractions.famtoproduction.ReceiveSelectionCard;
import it.polimi.ingsw.ps18.controller.controlleractions.famtotower.FamtoTowerTrigger;
import it.polimi.ingsw.ps18.controller.controlleractions.famtotower.ReceiveFamtoTower;
import it.polimi.ingsw.ps18.controller.controlleractions.famtotower.ReceiveFloortoTower;
import it.polimi.ingsw.ps18.controller.controlleractions.famtotower.ReceiveTowertoTower;

public class HashMapActions {
    private static Map<String,ActionChoice> genActions = new HashMap<>();
	
	public static void init(){
		genActions.put("Turn Handle Init", new TurnHandleInit());
		genActions.put("FamtoTower", new FamtoTowerTrigger());
		genActions.put("ReceiveFamtoTower", new ReceiveFamtoTower());
		genActions.put("ReceiveTower", new ReceiveTowertoTower());
		genActions.put("ReceiveFloor", new ReceiveFloortoTower());
		genActions.put("FamtoMarket", new FamtoMarketTrigger());
		genActions.put("ReceiveFamtoMarket", new ReceiveFamtoMarket());
		genActions.put("ReceiveMarketCell", new ReceiveMarketCell());
		genActions.put("ReceiveTowertoShow", new ShowTowerCells());
		genActions.put("FamtoCouncil", new FamtoCouncilTrigger());
		genActions.put("ReceiveFamtoCouncil", new ReceiveFamtoCouncil());
		genActions.put("FamtoHarvest", new FamtoHarvestTrigger());
		genActions.put("ReceiveFamtoHarvest", new ReceiveFamtoHarvest());
		genActions.put("actHarvest", new ActivateHarvest());
		genActions.put("FamtoProduction", new FamtoProductionTrigger());
		genActions.put("ReceiveFamtoProduction", new ReceiveFamtoProduction());
		genActions.put("actProduction", new ActivateProduction());
		genActions.put("Show Player", new ChosePlayer());
		genActions.put("ReceivePlayertoShow", new ShowPlayer());
		genActions.put("Chosen Privilege", new PrivilegeHandler());
		genActions.put("Selected YCard", new ReceiveSelectionCard());
	}
	
	public static ActionChoice geteffect(String a){
		return genActions.get(a);
	}

}
