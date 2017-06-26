package it.polimi.ingsw.ps18.controller.controlleractions;

import java.util.HashMap;
import java.util.Map;

import it.polimi.ingsw.ps18.controller.controlleractions.effectresolution.DifferentPrivilegeHandler;
import it.polimi.ingsw.ps18.controller.controlleractions.effectresolution.PrivilegeHandler;
import it.polimi.ingsw.ps18.controller.controlleractions.effectresolution.WoodorRockHandler;
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
import it.polimi.ingsw.ps18.controller.controlleractions.famtoproduction.ReceiveChoseneffect;
import it.polimi.ingsw.ps18.controller.controlleractions.famtoproduction.ReceiveFamtoProduction;
import it.polimi.ingsw.ps18.controller.controlleractions.famtoproduction.ReceiveSelectionCard;
import it.polimi.ingsw.ps18.controller.controlleractions.famtotower.FamtoTowerTrigger;
import it.polimi.ingsw.ps18.controller.controlleractions.famtotower.ReceiveChosenCost;
import it.polimi.ingsw.ps18.controller.controlleractions.famtotower.ReceiveFamtoTower;
import it.polimi.ingsw.ps18.controller.controlleractions.famtotower.ReceiveFloortoTower;
import it.polimi.ingsw.ps18.controller.controlleractions.famtotower.ReceiveTowertoTower;

// TODO: Auto-generated Javadoc
/**
 * The Class HashMapActions.
 */
public class HashMapActions {
    
    /**
	 * The gen actions.
	 */
    private static Map<String,ActionChoice> genActions = new HashMap<>();
	
	/**
	 * Inits the.
	 */
	public static void init(){
		genActions.put("Turn Handle Init", new TurnHandleInit());
		genActions.put("FamtoTower", new FamtoTowerTrigger());
		genActions.put("ReceiveFamtoTower", new ReceiveFamtoTower());
		genActions.put("ReceiveTower", new ReceiveTowertoTower());
		genActions.put("ReceiveFloor", new ReceiveFloortoTower());
		genActions.put("ReceiveChosenCost", new ReceiveChosenCost());
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
		genActions.put("Chosen Effect", new ReceiveChoseneffect());
		genActions.put("Chosen Resource", new WoodorRockHandler());
		genActions.put("Chosen Diff Privilege", new DifferentPrivilegeHandler());
		genActions.put("ReceiveChosenBonusTile", new ReceiveBonusTile());
		genActions.put("Verify Church Support", new VaticanReportTrigger());
		genActions.put("Receive Vatican Answer", new ReceiveVaticanAnswer());
	}
	
	/**
	 * Gets the effect.
	 *
	 * @param a
	 *            the a
	 * @return the effect
	 */
	public static ActionChoice geteffect(String a){
		return genActions.get(a);
	}

}
