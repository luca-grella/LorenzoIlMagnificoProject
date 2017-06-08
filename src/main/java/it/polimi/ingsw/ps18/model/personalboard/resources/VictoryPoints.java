package it.polimi.ingsw.ps18.model.personalboard.resources;

class VictoryPoints implements Points{
	private int quantity;
	
	public VictoryPoints(int value){
		this.quantity=value;
	}
	
	public VictoryPoints(long value) {
		this.quantity = (int) value;
	}

	public int getQuantity(){
		return this.quantity;
	}
	
	public void addQuantity(int value){
		this.quantity= this.quantity+value;
	}

}
