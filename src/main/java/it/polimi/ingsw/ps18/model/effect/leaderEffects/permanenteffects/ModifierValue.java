package it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects;

public class ModifierValue implements LCPermEffect {
	private String name = "ModifierValue";
	private String shortDescription;
	private int quantity;
	
	public void setParam(String shortDescription, int quantity){
		this.shortDescription = shortDescription;
		this.quantity = quantity;
	}
	
	
	@Override
	public String getShortDescription() {
		return this.shortDescription;
	}
	
	@Override
	public String toString(){
		return "Da Scrivere";
	}


	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	
	

}
