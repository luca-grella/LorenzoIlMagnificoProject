package it.polimi.ingsw.ps18.model.effect.generalEffects;

import org.json.simple.JSONArray;

import it.polimi.ingsw.ps18.model.effect.finalEffect.FinalEffect;
import it.polimi.ingsw.ps18.model.effect.harvestEffect.HarvestEffect;
import it.polimi.ingsw.ps18.model.effect.prodEffect.ProductionEffect;
import it.polimi.ingsw.ps18.model.effect.quickEffect.QuickEffect;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class AddVPforMP implements QuickEffect, HarvestEffect, ProductionEffect, FinalEffect {
	private String name = "GainVPforMP";
	private int countVP;
	private int countMP;

	@Override
	public void activate(PBoard player, GameLogic game) {
		int totMP = player.getResources().getMP();
		int multiplier = totMP/countMP;
		player.getResources().addVP(multiplier * countVP);
		//TODO: prevedere la lettura strana nelle carte blu
	}

	@Override
	public void setQuantity(int quantity) {
	}
	
	public void setQuantity(JSONArray count){
		this.countVP = (int) (long) count.get(0);
		this.countMP = (int) (long) count.get(1);
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("Gain " + this.countVP + " VP every " + this.countMP + " MP.");
		return builder.toString();
	}

}
