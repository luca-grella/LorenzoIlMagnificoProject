package it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects;

import org.json.simple.JSONArray;

public class ModifierValue implements LCPermEffect {
	private String name = "ModifierValue";
	private String shortDescription;
	private int quantity;
	
	public void setParam(JSONArray parameters){
		this.shortDescription = (String) parameters.get(0);
		long temp = (long) parameters.get(1);
		this.quantity = (int) temp;
	}
	
	
	@Override
	public String getShortDescription() {
		return this.shortDescription;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		if("BonusDiceValue".equals(shortDescription)){
			builder.append("Add " + this.quantity + " to the Action Value of each of your colored Family Member.");
		} else if("BonusNeutralFam".equals(shortDescription)){
			builder.append("Add " + this.quantity + " to the Action Value of your Neutral Family Member.");
		} else if("BaseFamValueModifier".equals(shortDescription)){
			builder.append("Your colored Family Member have a base value of " + this.quantity + ".");
		}
		return builder.toString();
	}
	
	
	

}
