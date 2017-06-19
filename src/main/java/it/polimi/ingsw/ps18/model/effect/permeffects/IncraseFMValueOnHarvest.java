package it.polimi.ingsw.ps18.model.effect.permeffects;

public class IncraseFMValueOnHarvest implements Permanenteffect {
	private String name = "IncraseFMvalueOnHarvest";
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
				+ "when you do an Harvest Action";
	}

}
