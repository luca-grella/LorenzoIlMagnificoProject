package it.polimi.ingsw.ps18.model.personalboard.resources;

class Servants implements Resources{
	private int quantity;
	
	protected Servants(int value){
		this.quantity=value;
	}
	
	public Servants(long value) {
		this.quantity = (int) value;
	}

	public int getQuantity(){
		return this.quantity;
	}
	
	public void addQuantity(int value){
		this.quantity= this.quantity+value;
	}

}
