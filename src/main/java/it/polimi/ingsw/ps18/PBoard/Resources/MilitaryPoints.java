package it.polimi.ingsw.ps18.PBoard.Resources;

class MilitaryPoints implements Points{
	private int quantity;
	
	public MilitaryPoints(int value){
		this.quantity=value;
	}
	
	public int getQuantity(){
		return this.quantity;
	}
	
	public void addQuantity(int value){
		this.quantity= this.quantity+value;
	}

}
