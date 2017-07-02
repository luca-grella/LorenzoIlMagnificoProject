package it.polimi.ingsw.ps18.model.effect.excommEffects;

public class MalusValue implements ExcommEffects {
	private String name = "MalusValue";
	private String place;
	private int malusValue;

	@Override
	public void setQuantity(int quantity) {
		this.malusValue = quantity;
	}
	
	public void setName(String nameplace){
		this.place = nameplace;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	

	/**
	 * @return the place
	 */
	public String getPlace() {
		return place;
	}

	/**
	 * @return the malusValue
	 */
	public int getMalusValue() {
		return malusValue;
	}
	
	

}
