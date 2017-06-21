package it.polimi.ingsw.ps18.model.effect.permeffects;

public class IncreaseFMValueOnAction implements Permanenteffect {
	private String name;
	private int quantity;

	@Override
	public int getQuantity() {
		return quantity;
	}

	@Override
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void setParam(String name, long quantity){
		this.name = name;
		this.quantity = (int) quantity;
	}

	@Override
	public String getName() {
		return name;
	}
	
	//TODO: da modificare
	@Override
	public String toString(){
		return "Incrase Permanently the Action Value by " + this.quantity + "\n"
				+ "\t   when you take a card from the " + this.name + " Tower";
	}

}
