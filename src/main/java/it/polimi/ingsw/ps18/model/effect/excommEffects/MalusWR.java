package it.polimi.ingsw.ps18.model.effect.excommEffects;

public class MalusWR implements ExcommEffects {


	private int malusQuantity;
	private String name = "Wood/Rock";
	
	
	
	@Override
	public void setQuantity(int quantity) {

		this.malusQuantity=quantity;
		
	}
	
	/**
	 * @return the malusQuantity
	 */
	public int getMalusQuantity() {
		return malusQuantity;
	}
	
	@Override
	public String toString(){
		if(malusQuantity>=0){
			if(malusQuantity == 1){
				return "detract " + malusQuantity + " " + name;
			} else if(malusQuantity==0 || malusQuantity>1){
				return "detract " + malusQuantity + " " + name + "s";
			}
		} else {
			if(malusQuantity == -1){
				return "add " + malusQuantity + " " + name;
			} else {
				return "add " + malusQuantity + " " + name + "s";
			}
		}
		return "Error";
	}
	
	public String getName() {
		return name;
	}

}
