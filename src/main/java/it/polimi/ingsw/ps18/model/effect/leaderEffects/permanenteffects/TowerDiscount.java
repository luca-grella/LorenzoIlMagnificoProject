package it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects;

import org.json.simple.JSONArray;

import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

/**
 * The Class TowerDiscount.
 */
public class TowerDiscount implements LCPermEffect {
	
	/** The discount. */
	private Stats discount;
	
	/** The short description. */
	private String shortDescription = "TowerDiscount";

	/**
	 * Gets the discount.
	 *
	 * @return the discount
	 */
	public Stats getDiscount() {
		return discount;
	}

	/**
	 * Sets the param.
	 *
	 * @param discount the discount to set
	 */
	public void setParam(JSONArray discount) {
		this.discount = new Stats(discount);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("Every time you take a card from a tower, discount its cost by:\n");
		builder.append(this.discount.toStringCost());
		return builder.toString();
	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects.LCPermEffect#getShortDescription()
	 */
	@Override
	public String getShortDescription() {
		return this.shortDescription;
	}
	
	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects.LCPermEffect#getName()
	 */
	@Override
	public String getName(){
		return "TowerDiscount";
	}
	
	

}
