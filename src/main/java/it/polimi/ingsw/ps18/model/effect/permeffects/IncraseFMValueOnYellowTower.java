package it.polimi.ingsw.ps18.model.effect.permeffects;

public class IncraseFMValueOnYellowTower implements Permanenteffect {
	private String name = "IncraseFMvalueOnYellowTower";
	private int quantity;

	@Override
	public int getQuantity() {
		return quantity;
	}

	@Override
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public String toString(){
		return "Incrase Permanently the Action Value by " + this.quantity + "\n"
				+ "when you take a card from the Yellow Tower";
	}

}
