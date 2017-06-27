package it.polimi.ingsw.ps18.model.effect.permeffects;

/**
 * The Class BlockFloorBonus.
 */
public class BlockFloorBonus implements Permanenteffect {
	private String name = "BlockFloorBonus";
	private int floor;

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.effect.permeffects.Permanenteffect#getQuantity()
	 */
	@Override
	public int getQuantity() {
		return floor;
	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.effect.permeffects.Permanenteffect#setQuantity(int)
	 */
	@Override
	public void setQuantity(int quantity) {
		this.floor = quantity;
	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.effect.permeffects.Permanenteffect#getName()
	 */
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public String toString(){
		return "You can't receive anymore the Bonus from the\n"
				+ "\t" + this.floor + " floor of any Tower.";
	}

}
