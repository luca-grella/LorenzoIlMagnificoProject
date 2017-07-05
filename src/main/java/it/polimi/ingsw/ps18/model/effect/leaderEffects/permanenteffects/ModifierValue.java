package it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects;

public class ModifierValue implements LCPermEffect {
	private String name = "ModifierValue";
	private String shortDescription;
	private String description;
	private int quantity;
	
	public void setParam(String shortDescription, String description, int quantity){
		this.shortDescription = shortDescription;
		this.description = description;
		this.quantity = quantity;
	}
	
	
	@Override
	public String getShortDescription() {
		return this.shortDescription;
	}
	
	@Override
	public String toString(){
		return description;
	}


	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	
	
	
	

}
