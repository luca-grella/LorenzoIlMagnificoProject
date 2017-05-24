package it.polimi.ingsw.ps18.Model.PBoard.Resources;

class MilitaryPoints implements Points{
	private int quantity;
	
	protected MilitaryPoints(int value){
		this.quantity=value;
	}
	
	public int getQuantity(){
		return this.quantity;
	}
	
	public void addQuantity(int value){
		this.quantity= this.quantity+value;
	}

}
