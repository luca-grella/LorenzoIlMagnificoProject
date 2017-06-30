package it.polimi.ingsw.ps18.model.effect.permeffects;

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
	 * @param name
	 *            the name
	 * @param quantity
	 *            the quantity
	 */
	public void setParam(String name, long quantity){
		this.name = name;
		this.quantity = (int) quantity;
	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.effect.permeffects.Permanenteffect#getName()
	 */
	@Override
	public String getName() {
		return name;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	//TODO: da modificare
	@Override
	public String toString(){
		return "Incrase Permanently the Action Value by " + this.quantity + "\n"
				+ "\t   when you take a card from the " + this.name + " Tower";
	}

}
