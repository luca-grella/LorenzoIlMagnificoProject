package it.polimi.ingsw.ps18.model.effect.generalEffects;

import org.json.simple.JSONArray;

import it.polimi.ingsw.ps18.model.effect.finalEffect.FinalEffect;
import it.polimi.ingsw.ps18.model.effect.harvestEffect.HarvestEffect;
import it.polimi.ingsw.ps18.model.effect.prodEffect.ProductionEffect;
import it.polimi.ingsw.ps18.model.effect.quickEffect.QuickEffect;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

/**
 * The Class AddVPforMP.
 */
public class AddVPforMP implements QuickEffect, HarvestEffect, ProductionEffect, FinalEffect {
	
	/**
	 * The name.
	 */
	private String name = "GainVPforMP";
	
	/**
	 * The count VP.
	 */
	private int countVP;
	
	/**
	 * The count MP.
	 */
	private int countMP;

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.effect.quickEffect.QuickEffect#activate(it.polimi.ingsw.ps18.model.personalboard.PBoard, it.polimi.ingsw.ps18.model.gamelogic.GameLogic)
	 */
	@Override
	public void activate(PBoard player, GameLogic game) {
		int totMP = player.getResources().getMP();
		int multiplier = totMP/countMP;
		player.getResources().addVP(multiplier * countVP);
	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.effect.quickEffect.QuickEffect#setQuantity(int)
	 */
	@Override
	public void setQuantity(int quantity) {
	}
	
	/**
	 * Sets the quantity.
	 *
	 * @param count
	 *            the new quantity
	 */
	public void setQuantity(JSONArray count){
		this.countVP = (int) (long) count.get(0);
		this.countMP = (int) (long) count.get(1);
	}
	
	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.effect.prodEffect.ProductionEffect#getName()
	 */
	@Override
	public String getName() {
		return name;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("Gain " + this.countVP + " VP every " + this.countMP + " MP.");
		return builder.toString();
	}

	/**
	 * @return
	 */
	public int getQuantity(int quantity) {
		
		return quantity;
	}

	/**
	 * @return 
	 * 
	 */
	public JSONArray getQuantity(JSONArray count) {
		
		return count;
		
	}

}
