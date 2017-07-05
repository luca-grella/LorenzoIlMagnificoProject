package it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects;

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
	public void setParam(Stats discount) {
		this.discount = discount;
	}
	
	@Override
	public String toString(){
		return "Da Scrivere";
	}

	@Override
	public String getShortDescription() {
		return this.shortDescription;
	}
	
	

}
