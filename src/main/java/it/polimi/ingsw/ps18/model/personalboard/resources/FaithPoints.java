package it.polimi.ingsw.ps18.model.personalboard.resources;

class FaithPoints implements Points{
    private int quantity;
	
	public FaithPoints(int value){
		this.quantity=value;
	}
	
	public int getQuantity(){
		return this.quantity;
	}
	
	public void addQuantity(int value){
		this.quantity= this.quantity+value;
	}

}
