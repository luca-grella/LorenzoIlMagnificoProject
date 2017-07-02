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

}
