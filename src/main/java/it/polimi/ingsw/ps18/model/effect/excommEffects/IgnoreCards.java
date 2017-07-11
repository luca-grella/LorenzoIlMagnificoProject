package it.polimi.ingsw.ps18.model.effect.excommEffects;

public class IgnoreCards implements ExcommEffects {
	private String name;

	@Override
	public void setQuantity(int quantity) {
		return;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	@Override
	public String toString(){
		return "Ignore the Victory Points Gain from " + name + "Cards";
	}

	/**
	 * @param quantity
	 * @return
	 */
	public int getQuantity(int quantity) {
		return quantity;
	}

}
