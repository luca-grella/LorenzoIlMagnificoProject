package it.polimi.ingsw.ps18.model.effect.generalEffects;

import java.util.HashMap;
import java.util.Map;

import it.polimi.ingsw.ps18.model.effect.finalEffect.FinalEffect;
import it.polimi.ingsw.ps18.model.effect.harvestEffect.HarvestEffect;
import it.polimi.ingsw.ps18.model.effect.prodEffect.ProductionEffect;
import it.polimi.ingsw.ps18.model.effect.quickEffect.QuickEffect;
import it.polimi.ingsw.ps18.model.personalBoard.PBoard;

public class privilege implements QuickEffect, HarvestEffect, ProductionEffect, FinalEffect   {
	private Map<String,QuickEffect> privileges = new HashMap<>();
	private int quantity;

	@Override
	public void activate(PBoard player) {
		//scelta privilegio + attivazione
		
	}
	
	@Override
	public void setQuantity(int quantity){
		
	}
	
	//hashmap potrebbe non essere la soluzione migliore
	private void init(){
		privileges.put("addWoodorRock", new addWoodorRock());
		privileges.put("addCoin", new addCoins());
		privileges.put("addServant", new addServants());
		privileges.put("addMP", new addMP());
		privileges.put("addFP", new addFP());
	}
     
}
