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
		StringBuilder builder = new StringBuilder();
		if("SkipCoinPaymentinTower".equals(shortDescription)){
			builder.append("Skip the tower fee payment even if the tower is already occupied.");
		} else if( "BonusVPVaticanReport".equals(shortDescription)){
			builder.append("Gain 5 VP bonus everytime you support the church");
		} else if("SkipMPCheckGreenCards".equals(shortDescription)){
			builder.append("Ignore the MP limitation when you take a green card.");
		} else if("DoubleBonus".equals(shortDescription)){
			builder.append("Every time you receive a quick bonus from a card, receive it two times");
		}
		return builder.toString();
	}
	
	@Override
	public String getName(){
		return "VariousModifier";
	}

}
