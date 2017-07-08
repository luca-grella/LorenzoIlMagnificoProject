package it.polimi.ingsw.ps18.controller.controlleractions;

import java.util.HashMap;
import java.util.Map;

import it.polimi.ingsw.ps18.controller.controlleractions.effectresolution.DifferentPrivilegeHandler;
import it.polimi.ingsw.ps18.controller.controlleractions.effectresolution.PrivilegeHandler;
import it.polimi.ingsw.ps18.controller.controlleractions.effectresolution.ReceiveFamforValueChange;
import it.polimi.ingsw.ps18.controller.controlleractions.effectresolution.WoodorRockHandler;
import it.polimi.ingsw.ps18.controller.controlleractions.famtocouncil.FamtoCouncilTrigger;
import it.polimi.ingsw.ps18.controller.controlleractions.famtocouncil.ReceiveFamtoCouncil;
import it.polimi.ingsw.ps18.controller.controlleractions.famtoharvest.ActivateHarvest;
import it.polimi.ingsw.ps18.controller.controlleractions.famtoharvest.FamtoHarvestTrigger;
import it.polimi.ingsw.ps18.controller.controlleractions.famtoharvest.ReceiveHarvestCell;
import it.polimi.ingsw.ps18.controller.controlleractions.famtoharvest.ReceiveFamtoHarvest;
import it.polimi.ingsw.ps18.controller.controlleractions.famtomarket.FamtoMarketTrigger;
import it.polimi.ingsw.ps18.controller.controlleractions.famtomarket.ReceiveFamtoMarket;
import it.polimi.ingsw.ps18.controller.controlleractions.famtomarket.ReceiveMarketCell;
import it.polimi.ingsw.ps18.controller.controlleractions.famtoproduction.ActivateProduction;
import it.polimi.ingsw.ps18.controller.controlleractions.famtoproduction.FamtoProductionTrigger;
import it.polimi.ingsw.ps18.controller.controlleractions.famtoproduction.ReceiveChoseneffect;
import it.polimi.ingsw.ps18.controller.controlleractions.famtoproduction.ReceiveFamtoProduction;
import it.polimi.ingsw.ps18.controller.controlleractions.famtoproduction.ReceiveProductionCell;
import it.polimi.ingsw.ps18.controller.controlleractions.famtoproduction.ReceiveSelectionCard;
import it.polimi.ingsw.ps18.controller.controlleractions.famtotower.FamtoTowerTrigger;
import it.polimi.ingsw.ps18.controller.controlleractions.famtotower.ReceiveChosenCost;
import it.polimi.ingsw.ps18.controller.controlleractions.famtotower.ReceiveFamtoTower;
import it.polimi.ingsw.ps18.controller.controlleractions.famtotower.ReceiveFloortoTower;
import it.polimi.ingsw.ps18.controller.controlleractions.famtotower.ReceiveTowertoTower;
import it.polimi.ingsw.ps18.controller.controlleractions.leadercards.ReceiveChoiceLCInitialDraft;
import it.polimi.ingsw.ps18.controller.controlleractions.leadercards.ReceiveLCtoCopy;
import it.polimi.ingsw.ps18.controller.controlleractions.leadercards.activation.LeaderActivationTrigger;
import it.polimi.ingsw.ps18.controller.controlleractions.leadercards.activation.ReceiveActivationChoice;
import it.polimi.ingsw.ps18.controller.controlleractions.leadercards.discard.DiscardLCTrigger;
import it.polimi.ingsw.ps18.controller.controlleractions.leadercards.discard.ReceiveDiscardChoice;
import it.polimi.ingsw.ps18.controller.controlleractions.leadercards.quickeffects.ActivationQETrigger;
import it.polimi.ingsw.ps18.controller.controlleractions.leadercards.quickeffects.ReceiveActivationLCQEChoice;
import it.polimi.ingsw.ps18.controller.controlleractions.vaticanreport.ReceiveVaticanAnswer;
import it.polimi.ingsw.ps18.controller.controlleractions.vaticanreport.VaticanReportTrigger;

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
		genActions.put("Add Servants", new ReceiveServants());
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
		genActions.put("ReceiveHarvCell", new ReceiveHarvestCell());
		genActions.put("actHarvest", new ActivateHarvest());
		genActions.put("FamtoProduction", new FamtoProductionTrigger());
		genActions.put("ReceiveFamtoProduction", new ReceiveFamtoProduction());
		genActions.put("ReceiveProdCell", new ReceiveProductionCell());
		genActions.put("actProduction", new ActivateProduction());
		genActions.put("Show Player", new ChoosePlayer());
		genActions.put("ReceivePlayertoShow", new ShowPlayer());
		genActions.put("Chosen Privilege", new PrivilegeHandler());
		genActions.put("Selected YCard", new ReceiveSelectionCard());
		genActions.put("Chosen Effect", new ReceiveChoseneffect());
		genActions.put("Chosen Resource", new WoodorRockHandler());
		genActions.put("Chosen Diff Privilege", new DifferentPrivilegeHandler());
		genActions.put("ReceiveChosenBonusTile", new ReceiveBonusTile());
		genActions.put("Verify Church Support", new VaticanReportTrigger());
		genActions.put("Receive Vatican Answer", new ReceiveVaticanAnswer());
		genActions.put("ReceiveFamforValueChange", new ReceiveFamforValueChange());
		genActions.put("ReceiveChoiceLC", new ReceiveChoiceLCInitialDraft());
		genActions.put("ActivateLC", new LeaderActivationTrigger());
		genActions.put("ReceiveActivationChoice", new ReceiveActivationChoice());
		genActions.put("DiscardLC", new DiscardLCTrigger());
		genActions.put("ReceiveDiscardChoice", new ReceiveDiscardChoice());
		genActions.put("ActivateLCQE", new ActivationQETrigger());
		genActions.put("ReceiveActivationLCQEChoice", new ReceiveActivationLCQEChoice());
		genActions.put("ReceiveConfirm", new ReceiveConfirm());
		genActions.put("ReceiveLCtoCopy", new ReceiveLCtoCopy());
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
