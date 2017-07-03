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
	
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		if("Green".equals(place)){
			builder.append("Reduce the action Value by " + malusValue + " when you take a card from the " + place + " Tower.");
		} else if("Blue".equals(place)){
			builder.append("Reduce the action Value by " + malusValue + " when you take a card from the " + place + " Tower.");
		} else if("Yellow".equals(place)){
			builder.append("Reduce the action Value by " + malusValue + " when you take a card from the " + place + " Tower.");
		} else if("Purple".equals(place)){
			builder.append("Reduce the action Value by " + malusValue + " when you take a card from the " + place + " Tower.");
		} else if("Harvest".equals(place)){
			builder.append("Reduce the action Value by " + malusValue + " when you make a " + place + " Action.");
		} else if("Production".equals(place)){
			builder.append("Reduce the action Value by " + malusValue + " when you make a " + place + " Action.");
		} else if("Dice".equals(place)){
			builder.append("Reduce Value of your Family Members by " + malusValue + ".");
		} else if("Market".equals(place)){
			builder.append("You can't pplace your Family Members in the Market anymore.");
		} else if("Servants".equals(place)){
			builder.append("Reduce Value of your Servants by " + malusValue + ".");
		} else if("TurnOrder".equals(place)){
			builder.append("You will be the last player to make an action for every first action of every turn.");
		}
		return builder.toString();
	}
	
	

}
