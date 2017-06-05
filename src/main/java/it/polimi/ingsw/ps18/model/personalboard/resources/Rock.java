package it.polimi.ingsw.ps18.model.personalboard.resources;

class Rock implements Resources {
	private int quantity;
	
	public Rock(int value){
		this.quantity=value;
	}
	
	public int getQuantity(){
		return this.quantity;
	}
	
	public void addQuantity(int value){
		this.quantity= this.quantity+value;
	}

}
