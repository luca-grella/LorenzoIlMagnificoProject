package it.polimi.ingsw.ps18.model.personalBoard.resources;

class Coins implements Resources{
	private int quantity;
	
	protected Coins(int value){
		this.quantity=value;
	}
	
	public int getQuantity(){
		return this.quantity;
	}
	
	public void addQuantity(int value){
		this.quantity= this.quantity+value;
	}

}
