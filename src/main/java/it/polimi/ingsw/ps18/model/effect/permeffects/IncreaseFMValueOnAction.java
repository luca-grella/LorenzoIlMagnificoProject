package it.polimi.ingsw.ps18.model.effect.permeffects;

import org.json.simple.JSONArray;

import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

/**
 * The Class IncreaseFMValueOnAction.
 */
public class IncreaseFMValueOnAction implements Permanenteffect {
	
	/**
	 * The name.
	 */
	private String name;
	
	/**
	 * The quantity.
	 */
	private int quantity;
	
	/** The discounts. */
	private Stats discounts;

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.effect.permeffects.Permanenteffect#getQuantity()
	 */
	@Override
	public int getQuantity() {
		return quantity;
	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.effect.permeffects.Permanenteffect#setQuantity(int)
	 */
	@Override
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * Sets the param.
	 *
	 * @param name the name
	 * @param quantity the quantity
	 * @param discounts the discounts
	 */
	public void setParam(String name, long quantity, JSONArray discounts){
		this.name = name;
		this.quantity = (int) quantity;
		this.discounts = new Stats(discounts);
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 * @see it.polimi.ingsw.ps18.model.effect.permeffects.Permanenteffect#getName()
	 */
	@Override
	public String getName() {
		return name;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("Incrase Permanently the Action Value by " + this.quantity + "\n"
				+ "\t   when you take a card from the " + this.name + " Tower");
		if(! this.discounts.isEmpty()){
			builder.append("\n\t with a discount of:\n" + discounts.toStringCost());
		}
		return builder.toString();
	}

	/**
	 * Gets the discounts.
	 *
	 * @return the discounts
	 */
	public Stats getDiscounts() {
		return discounts;
	}
	
	

}
