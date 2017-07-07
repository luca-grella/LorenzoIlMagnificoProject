package it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects;

import org.json.simple.JSONArray;

import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

public class TowerDiscount implements LCPermEffect {
	private Stats discount;
	private String shortDescription = "TowerDiscount";

	/**
	 * @return the discount
	 */
	public Stats getDiscount() {
		return discount;
	}

	/**
	 * @param discount the discount to set
	 */
	public void setParam(JSONArray discount) {
		this.discount = new Stats(discount);
	}
	
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("Every time you take a card from a tower, discount its cost by:\n");
		builder.append(this.discount.toStringCost());
		return builder.toString();
	}

	@Override
	public String getShortDescription() {
		return this.shortDescription;
	}
	
	

}
