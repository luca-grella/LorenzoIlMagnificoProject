package it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects;

import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

public class TowerDiscount implements LCPermEffect {
	private Stats discount;
	private String shortDescription = "TowerDiscount";
	private String description;

	/**
	 * @return the discount
	 */
	public Stats getDiscount() {
		return discount;
	}

	/**
	 * @param discount the discount to set
	 */
	public void setParam(Stats discount, String description) {
		this.discount = discount;
		this.description = description;
	}
	
	@Override
	public String toString(){
		return description;
	}
	
	

}
