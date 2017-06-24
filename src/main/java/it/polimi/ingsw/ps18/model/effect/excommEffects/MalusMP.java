package it.polimi.ingsw.ps18.model.effect.excommEffects;

// TODO: Auto-generated Javadoc
/**
 * The Class MalusMP.
 */
public class MalusMP implements ExcommEffects {

	
	/**
	 * The malus quantity.
	 */
	private int malusQuantity;
	
	/**
	 * The name.
	 */
	private String name = "Military Point";
	
	
	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.effect.excommEffects.ExcommEffects#setQuantity(int)
	 */
	@Override
	public void setQuantity(int quantity) {

		this.malusQuantity=quantity;
		
	}
	
	/**
	 * Gets the malus quantity.
	 *
	 * @return the malusQuantity
	 */
	public int getMalusQuantity() {
		return malusQuantity;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		if(malusQuantity>=0){
			if(malusQuantity == 1){
				return "detract " + malusQuantity + " " + name;
			} else if(malusQuantity==0 || malusQuantity>1){
				return "detract " + malusQuantity + " " + name + "s";
			}
		} else {
			if(malusQuantity == -1){
				return "add " + malusQuantity + " " + name;
			} else {
				return "add " + malusQuantity + " " + name + "s";
			}
		}
		return "Error";
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
