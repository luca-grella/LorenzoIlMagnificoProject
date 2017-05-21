package it.polimi.ingsw.ps18.PBoard.Resources;

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
