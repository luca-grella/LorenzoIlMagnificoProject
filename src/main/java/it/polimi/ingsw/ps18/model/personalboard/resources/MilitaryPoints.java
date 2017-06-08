package it.polimi.ingsw.ps18.model.personalboard.resources;

class MilitaryPoints implements Points{
	private int quantity;
	
	public MilitaryPoints(int value){
		this.quantity=value;
	}
	
	public MilitaryPoints(long value) {
		this.quantity = (int) value;
	}

	public int getQuantity(){
		return this.quantity;
	}
	
	public void addQuantity(int value){
		this.quantity= this.quantity+value;
	}

}
