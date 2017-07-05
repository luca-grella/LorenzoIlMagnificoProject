package it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects;

public class VariousModifier implements LCPermEffect {
	private String shortDescription;
	
	public void setParam(String shortDescription){
		this.shortDescription = shortDescription;
	}

	@Override
	public String getShortDescription() {
		return this.shortDescription;
	}
	
	@Override
	public String toString(){
		return "Da Scrivere";
	}

}
